package com.namoo.hellomvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	//
	@RequestMapping("/regist")
	public String registUser(@ModelAttribute("userInfo")User user) {
		//
		System.out.println(user.getEmail());
		System.out.println(user.getName());
		System.out.println(user.getUserId());
		return "user";
	}
	
//	@RequestMapping("/login")
//	public String login(@RequestParam("userId") String userId, @RequestParam(value="password", required=false, defaultValue="1234") String password, Model model) {
//		//
//		System.out.println(userId);
//		System.out.println(password);
//		
//		model.addAttribute("userId", userId);
//		model.addAttribute("password", password);
//		
//		return "login";
//	}
	
	@RequestMapping("/login")
	public Map<String, String> login(@RequestParam("userId") String userId, @RequestParam(value="password", required=false, defaultValue="1234") String password) {
		//
		System.out.println(userId);
		System.out.println(password);
		
		//리턴방법2-모델객체를 사용해 모델을 리턴
//		Model model = new ExtendedModelMap();
//		model.addAttribute("userId", userId);
//		model.addAttribute("password", password);
//		
//		return model;
		
		//리턴방법3-맵객체를 사용해 맵을 리턴
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("password", password);
		return  map;
	}
	
	@RequestMapping("/{userId}")
	public ModelAndView readUser(@PathVariable("userId") String userId) {
		//
		User user = new User();
		user.setEmail("ekdgml@naver.com");
		user.setName("박상희");
		
		//리턴방법1-1 모델앤뷰객체를 사용해 모델앤뷰를 리턴
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("user");
//		mav.addObject("userInfo", user);
//		
//		return mav;
		
		//리턴방법1-2
		return new ModelAndView("user", "userInfo", user);
	}
}
