package cn.blbsz.shop.controller;

import cn.blbsz.shop.entity.UserEntity;
import cn.blbsz.shop.repository.UserRepository;
import cn.blbsz.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2017/3/27.
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

//    @RequestMapping("/user/{id}")
    
//    public List<Map<String, Object>> getUser(@PathVariable("id") Long id,Model model) {
        @RequestMapping("/user/{id}")
    	public String getUser(@PathVariable("id") Long id,Model model) {
        UserEntity user = userRepository.findNickNameByUserId(id);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "user/info";
//        return userService.getNewBankUserInfo(id);
    }

}
