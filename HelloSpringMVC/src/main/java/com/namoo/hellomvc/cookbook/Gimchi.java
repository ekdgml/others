package com.namoo.hellomvc.cookbook;

public class Gimchi implements Recipe{
	//
	private String name;
	
	public Gimchi(String name) {
		//
		this.name = name;
	}
	public String[] ingredients() {
		//
		return new String[] {"김치", "돼지고기", "양파", "대파", "두부"};
	}
	
	public String[] recipe() {
		//
		return new String[] {
				"1. 김치를 볶는다.", 
				"2. 돼지고기를 볶는다.",
				"3. 다 넣고 끓인다."
		};
	}
	@Override
	public String getRecipeName() {
		//
		return this.name;
	}
}
