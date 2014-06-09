package com.namoo.mvc.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	//
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception e) throws Exception {
		//
		System.out.println("intercept!!!! - afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView mav) throws Exception {
		//
		System.out.println("intercept!!!! - postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		//
		System.out.println("intercept!!!! - preHandle");
		return true;
	}
}
