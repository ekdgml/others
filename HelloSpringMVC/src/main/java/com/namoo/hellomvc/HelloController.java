package com.namoo.hellomvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	//
	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public String sayHello(Model model) {
		//
		model.addAttribute("userName", "Sarah Park-get");
		return "hello";
	}
	
	@RequestMapping(value = "/hello.do", method = RequestMethod.POST)
	public String sayHello2(Model model) {
		//
		model.addAttribute("userName", "Sarah Park-post");
		return "hello";
	}
	
	@RequestMapping(value = "/sayHello.do", params = "type=admin")
	public String sayHello3(Model model) {
		//
		model.addAttribute("userName", "관리자");
		return "hello";
	}
	
	@RequestMapping(value = "/sayHello.do", params = "type=member")
	public String sayHello4(Model model) {
		//
		model.addAttribute("userName", "회원");
		return "hello";
	}
	
	@RequestMapping("/sayHello5")
	public String sayHello5(HttpServletRequest req) {
		//
		req.setAttribute("userName", "요건 HttpServletRequest!");
		return "hello";
	}
}
