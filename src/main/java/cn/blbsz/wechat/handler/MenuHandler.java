package cn.blbsz.wechat.handler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import cn.blbsz.wechat.builder.ImageBuilder;
import cn.blbsz.wechat.utils.QrcodeUtil;
import com.github.binarywang.utils.qrcode.QrcodeUtils;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * @author Binary Wang
 */
@Component
public class MenuHandler extends AbstractHandler {

    private static final String FORMAT = "jpg";// 生成二维码的格式

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
            Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager) {

        String msg = String.format("type:%s, event:%s, key:%s",
            wxMessage.getMsgType(), wxMessage.getEvent(),
            wxMessage.getEventKey());
        if (WxConsts.BUTTON_VIEW.equals(wxMessage.getEvent())) {
            return null;
        }
        if ("V1001_BUSINESS_CARD".equals(wxMessage.getEventKey())){
            int scene = 123;
            Integer expire_seconds = 2592000;
            int length = 380;
            String bgImgSrc = "src\\main\\resources\\static\\img\\bg_img.jpg";
            try {
                WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(scene, expire_seconds);
                File file = Files.createTempFile("qrcode_", "." + FORMAT).toFile();
                logger.debug(file.getAbsolutePath());

                // 制作带背景的二维码
                QrcodeUtil.writeToFile(ticket.getUrl(),length,bgImgSrc,FORMAT,file);
//                File file = wxMpService.getQrcodeService().qrCodePicture(ticket);
                // 上传图片到微信服务器
                WxMediaUploadResult res = wxMpService.getMaterialService().mediaUpload(WxConsts.MEDIA_IMAGE, file);
                // 获取图片资源ID
                String content = res.getMediaId();
                // 下发给用户
                return new ImageBuilder().build(content, wxMessage, wxMpService);
            } catch (WxErrorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return WxMpXmlOutMessage.TEXT().content(msg)
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();
    }

}
