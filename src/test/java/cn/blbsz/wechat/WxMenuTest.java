package cn.blbsz.wechat;

import cn.blbsz.Application;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.mp.api.WxMpService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class WxMenuTest {

	@Autowired
	private WxMpService wxMpService;

	@Test
	public void menuCreate() throws Exception {
//		WxMenu wxMenu = WxMenu.fromJson("{\"menu\":{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"歌手简介\",\"key\":\"V1001_TODAY_SINGER\",\"sub_button\":[]},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\",\"sub_button\":[]},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\",\"sub_button\":[]}]}]}}");
		// 设置菜单
		WxMenu wxMenu = WxMenu.fromJson("{\"menu\":{\"button\":[{\"key\":\"V1001_BUSINESS_CARD \",\"name\":\"公司简介\",\"sub_button\":[],\"type\":\"click\"},{\"key\":\"V1001_BUSINESS_CARD\",\"name\":\"推广名片\",\"sub_button\":[],\"type\":\"click\"},{\"name\":\"菜单\",\"sub_button\":[{\"name\":\"搜索\",\"sub_button\":[],\"type\":\"view\",\"url\":\"http://www.soso.com/\"},{\"name\":\"视频\",\"sub_button\":[],\"type\":\"view\",\"url\":\"http://v.qq.com/\"},{\"key\":\"V1001_GOOD\",\"name\":\"赞一下我们\",\"sub_button\":[],\"type\":\"click\"}]}]}}");
		wxMpService.getMenuService().menuCreate(wxMenu);
	}

}
