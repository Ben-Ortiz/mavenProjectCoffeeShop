package com.ben.model;

public class Coffee {
	
	private String coffeeName;
	private int coffeeCost;
	
	
	/**
	 * @param coffeeName
	 * @param coffeeCost
	 */
	public Coffee(String coffeeName, int coffeeCost) {
		super();
		this.coffeeName = coffeeName;
		this.coffeeCost = coffeeCost;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public int getCoffeeCost() {
		return coffeeCost;
	}
	public void setCoffeeCost(int coffeeCost) {
		this.coffeeCost = coffeeCost;
	}
	@Override
	public String toString() {
		return "Coffee [coffeeName=" + coffeeName + ", coffeeCost=" + coffeeCost + "]";
	}
	
	
	
	

}
