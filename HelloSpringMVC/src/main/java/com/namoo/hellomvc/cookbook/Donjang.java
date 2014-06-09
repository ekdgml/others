package com.namoo.hellomvc.cookbook;

public class Donjang implements Recipe{
	//
	private String name;
	
	public Donjang(String name) {
		//
		this.name = name;
	}
	@Override
	public String[] ingredients() {
		//
		return new String[] {"된장","두부","감자","마늘","대파"};
	}

	@Override
	public String[] recipe() {
		//
		return new String[] {
				"1. 육수를 끓인다.",
				"2. 된장을 육수에 넣는다.",
				"3. 다른 거 다 넣고 끓인다."
				};
	}
	@Override
	public String getRecipeName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
