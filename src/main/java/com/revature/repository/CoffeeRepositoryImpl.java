package com.revature.repository;

import java.util.*;

import com.revature.model.Coffee;

public class CoffeeRepositoryImpl implements CoffeeRepository {

	private ArrayList<Coffee> coffeeList = new ArrayList<Coffee>();

	public CoffeeRepositoryImpl() {
		super();
		coffeeList.add(new Coffee("Caramel Latte", 15, "Ben's Cafe"));
		coffeeList.add(new Coffee("Macchiato", 12, "Ben's Cafe"));
		coffeeList.add(new Coffee("Cappucino", 10, "Ben's Cafe"));
		coffeeList.add(new Coffee("Black", 7, "Ben's Cafe"));
		coffeeList.add(new Coffee("The Traitor", 20, "Ben's Cafe"));
	}

	public ArrayList<Coffee> getCoffeeList() {
		return coffeeList;
	}

	public void printCoffeeList() {
		System.out.println("Pick the coffee you want");
		for (int i = 0; i < coffeeList.size(); i++) {
			System.out.println( i+1 + " " + coffeeList.get(i));
		}
	}
	
	public void pickCoffee() {
		Scanner scanner = new Scanner(System.in);
		
		int pickCoffeeAnswer = scanner.nextInt();
		
		switch (pickCoffeeAnswer) {
		case 1:
			System.out.println(coffeeList.get(pickCoffeeAnswer-1));
			break;
		case 2:
			System.out.println(coffeeList.get(pickCoffeeAnswer-1));
			break;
		case 3:
			System.out.println(coffeeList.get(pickCoffeeAnswer-1));
			break;
		case 4:
			System.out.println(coffeeList.get(pickCoffeeAnswer-1));
			break;

		}
	}

}
