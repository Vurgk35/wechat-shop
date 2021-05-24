package cn.blbsz.wechat.handler;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import cn.blbsz.wechat.builder.ImageBuilder;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.blbsz.wechat.builder.TextBuilder;
import cn.blbsz.wechat.utils.JsonUtils;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * 
 * @author Binary Wang
 *
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
            Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager)    {

        if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                && wxMpService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                    .fromUser(wxMessage.getToUser())
                    .toUser(wxMessage.getFromUser()).build();
            }
            if (StringUtils.startsWithAny(wxMessage.getContent(),"名片")){
                String lang = "zh_CN"; //语言
//                String openid = wxMessage.getFromUser(); //openid
//                WxMpUser wxMpUser = wxMpService.getUserService().userInfo(openid, lang);
                int scene = 123;
                Integer expire_seconds = 2592000;
                WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(scene, expire_seconds);
                File file = wxMpService.getQrcodeService().qrCodePicture(ticket);
                WxMediaUploadResult res = wxMpService.getMaterialService().mediaUpload(WxConsts.MEDIA_IMAGE, file);
                String content = res.getMediaId();
//                String pictureUrl = wxMpService.getQrcodeService().qrCodePictureUrl(ticket.getTicket(), true);
//                String content = pictureUrl;
                return new ImageBuilder().build(content, wxMessage, wxMpService);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        //TODO 组装回复消息
        String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);

        return new TextBuilder().build(content, wxMessage, wxMpService);

    }

}
