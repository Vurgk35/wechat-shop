package cn.blbsz.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.blbsz.shop.repository.IMyUserRepository;

@Controller
@RequestMapping("/user")
public class MyUserController {
	
	@Autowired
	IMyUserRepository myUserRepository;
	
	
	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping("/page1")
	@PreAuthorize("hasAnyRole('ROLE_NORMAL')")
	public String getPage1() {
		System.out.println(myUserRepository.findByUsername("zhangjian")+"aaaaaaaaaaa");
		return "page1";
	}
	
	@RequestMapping("/page2")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public String getPage2() {
		System.out.println(myUserRepository.findByUsername("zhangjian")+"aaaaaaaaaaa");
		return "page2";
	}
}
