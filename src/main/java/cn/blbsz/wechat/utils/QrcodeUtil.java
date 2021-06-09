package cn.blbsz.wechat.utils;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

/**
 * Created by Lenovo on 2017/3/30.
 */
public class QrcodeUtil {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    private static Logger logger = LoggerFactory.getLogger(QrcodeUtil.class);

    /**
     * 根据内容生成二维码数据
     *
     * @param content 二维码文字内容[为了信息安全性，一般都要先进行数据加密]
     * @param length  二维码图片宽度和高度
     */
    private static BitMatrix createQrcodeMatrix(String content, int length) {
        Map<EncodeHintType, Object> hints = Maps.newEnumMap(EncodeHintType.class);
        // 设置字符编码
        hints.put(EncodeHintType.CHARACTER_SET, Charsets.UTF_8.name());
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 白边大小，取值范围0~4
        hints.put(EncodeHintType.MARGIN, 0);

        try {
            return new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, length, length, hints);
        } catch (Exception e) {
            logger.warn("内容为：【" + content + "】的二维码生成失败！", e);
            return null;
        }

    }

    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static void writeToFile(BitMatrix matrix, String format, File file)
            throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    /**
     * 生成内容为 content 边长为 length 的二维码，加上背景并写入file 中
     * @param content
     * @param length
     * @param bgImgSrc
     * @param format
     * @param file
     * @throws IOException
     */
    public static void writeToFile(String content, int length, String bgImgSrc, String format, File file)
            throws IOException {
        BitMatrix matrix = createQrcodeMatrix(content, length);
        BufferedImage qrcode = toBufferedImage(matrix);
        BufferedImage image = ImageIO.read(new File(bgImgSrc));
        overlapImage(qrcode,image);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    /**
     * 自定义图片合并规则
     * @param qrcode
     * @param bg
     */
    private static void overlapImage(BufferedImage qrcode, BufferedImage bg) {
        Graphics2D g = bg.createGraphics();
        int x = (bg.getWidth() - qrcode.getWidth()) / 2;
        int y = bg.getHeight() * 3 / 4 - qrcode.getHeight() / 2;
        g.drawImage(qrcode, x, y, null);
        g.dispose();
    }


    public static void main1(String[] args) {
        BitMatrix bitMatrix = createQrcodeMatrix("yipingdong", 380);
        BufferedImage qrcode = toBufferedImage(bitMatrix);
        try {
            //File file = Files.createTempFile("qrcode_", "." + FORMAT).toFile();
            //logger.debug(file.getAbsolutePath());

            BufferedImage logo = ImageIO.read(new File("src\\main\\resources\\static\\img\\bg_img.jpg"));
            Graphics2D g = logo.createGraphics();

            int x = (logo.getWidth() - qrcode.getWidth()) / 2;
            int y = logo.getHeight() * 3 / 4 - qrcode.getHeight() / 2;

            g.drawImage(qrcode, x, y, null);
            g.dispose();

            ImageIO.write(logo, "jpg", new File("result.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
