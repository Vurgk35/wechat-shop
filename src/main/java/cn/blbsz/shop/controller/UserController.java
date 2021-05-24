package cn.blbsz.shop.controller;

import cn.blbsz.shop.entity.UserEntity;
import cn.blbsz.shop.repository.UserRepository;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Lenovo on 2017/3/27.
 */

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id, Model model) {
        UserEntity user = userRepository.findByUserId(id);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "user/info";
    }

}
