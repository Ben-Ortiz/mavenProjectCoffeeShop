package com.revature.model;

public class Coffee {

	private String coffeeFlavor;
	private int coffeeCost;
	private String coffeeCafe;

	public Coffee(String coffeeFlavor, int coffeeCost, String coffeeCafe) {
		super();
		this.coffeeFlavor = coffeeFlavor;
		this.coffeeCost = coffeeCost;
		this.coffeeCafe = coffeeCafe;
	}

	public String getCoffeeFlavor() {
		return coffeeFlavor;
	}

	public void setCoffeeFlavor(String coffeeFlavor) {
		this.coffeeFlavor = coffeeFlavor;
	}

	public int getCoffeeCost() {
		return coffeeCost;
	}

	public void setCoffeeCost(int coffeeCost) {
		this.coffeeCost = coffeeCost;
	}

	public String getCoffeeCafe() {
		return coffeeCafe;
	}

	public void setCoffeeCafe(String coffeeCafe) {
		this.coffeeCafe = coffeeCafe;
	}

	@Override
	public String toString() {
		return coffeeFlavor + " " + coffeeCost;
	}

}
