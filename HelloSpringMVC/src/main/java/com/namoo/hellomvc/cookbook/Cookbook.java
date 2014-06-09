package com.namoo.hellomvc.cookbook;

import java.util.List;
import java.util.Map;

public class Cookbook {
	//
	private String writer;
	private List<String> chapters;
	private Map<String, Recipe> recipeMap;
	
	//----------------------------------------------------------------
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public List<String> getChapters() {
		return chapters;
	}
	public void setChapters(List<String> chapters) {
		this.chapters = chapters;
	}
	public Map<String, Recipe> getRecipeMap() {
		return recipeMap;
	}
	public void setRecipeMap(Map<String, Recipe> recipeMap) {
		this.recipeMap = recipeMap;
	}
	
	//---------------------------------------------------------------------
	public Recipe findRecipeByName(String recipeName) {
		//
		return recipeMap.get(recipeName);
	}
	
	
}
