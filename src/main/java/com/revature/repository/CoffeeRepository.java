package com.revature.repository;

import java.util.ArrayList;

import com.revature.model.Coffee;

public interface CoffeeRepository {

	public ArrayList<Coffee> getCoffeeList();

	public void printCoffeeList();
	
	public void pickCoffee();

}
