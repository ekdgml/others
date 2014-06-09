package com.namoo.hellomvc.cookbook;

public class Chicken implements Recipe{
	//
	private String name;
	
	public Chicken(String name) {
		//
		this.name = name;
	}

	@Override
	public String[] ingredients() {
		//
		return new String[] {"닭", "치킨튀김가루", "올리브유", "마늘", "양념소스"};
	}

	@Override
	public String[] recipe() {
		//
		return new String[] {
				"1. 반죽물에 치킨을 다 넣고 튀김가루 옷을 입혀준다. ",
				"2. 튀긴다.",
				"3. 먹는다."
		};
	}

	@Override
	public String getRecipeName() {
		//
		return name;
	}
	
	
}
