package com.namoo.hellomvc.cookbook;

public class Chef {
	//
	private Recipe recipe;
	
	public Chef() {
		//
	}
	
	public Chef(Recipe recipe) {
		//
		this.recipe = recipe;
	}
	
	public void sayIngredients() {
		//
		System.out.println("요리명 : " + recipe.getRecipeName());

		StringBuffer sb = new StringBuffer();
		for (String ingredient : recipe.ingredients()) {
			sb.append(ingredient);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public void sayRecipe() {
		//
		System.out.println("요리명 : " + recipe.getRecipeName());
		
		StringBuffer sb = new StringBuffer();
		for (String step : recipe.recipe()) {
			sb.append(step);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	public void init() {
		System.out.println("Chef init..." + recipe.getRecipeName());
	}
	
	public void destroy() {
		System.out.println("Chef destroy" + recipe.getRecipeName());
	}
	
	
}
