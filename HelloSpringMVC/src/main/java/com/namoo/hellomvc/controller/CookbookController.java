package com.namoo.hellomvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.namoo.hellomvc.cookbook.Cookbook;
import com.namoo.hellomvc.cookbook.Recipe;

@Controller
@RequestMapping("/cookbook")
public class CookbookController {
	//
	@Autowired
	private Cookbook cookbook;
	
	@RequestMapping(value="/chapters", method=RequestMethod.GET)
	public ModelAndView chapters() {
		//
		return new ModelAndView("cookbook/chapters", "cookbook", cookbook);
	}
	
	@RequestMapping(value="/chapters/{recipeName}", method=RequestMethod.GET)
	public ModelAndView recipe(@PathVariable("recipeName") String recipeName) {
		//
		//PathVariable그 이름의 파라미터를 받아서 쓰겟다!
		
		Recipe recipe = cookbook.findRecipeByName(recipeName);
		return new ModelAndView("cookbook/recipe", "recipe", recipe);
	}
	
}
