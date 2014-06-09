package com.namoo.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.namoo.mvc.exception.NamooException;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		System.err.println("controller called.");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String sayHello() {
		//
		throw new NamooException("안녕하지 못합니다.");
		// return "hello";
	}
	
	@RequestMapping(value="/hello/a", method = RequestMethod.GET)
	public String sayHello2() {
		//
		return "hello";
	}
	
//	@ExceptionHandler(NamooException.class)
//	public String handleException(NamooException e) {
//		//
//		return "errors/error";
//	}
	
//	@ExceptionHandler(NamooException.class)
//	public String handleException(HttpServletRequest req, NamooException e) {
//		//
//		req.setAttribute("errorMessage", "에러발생:"+e.getMessage());
//		return "errors/error";
//	}
	
//	@ExceptionHandler(NamooException.class)
//	public ModelAndView handleException(NamooException e) {
//		//
//		String message = "에러발생:"+e.getMessage();
//		return new ModelAndView("errors/error", "errorMessage", message);
//	}
}
