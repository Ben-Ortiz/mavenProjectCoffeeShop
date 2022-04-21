package com.ben.repository;

import java.util.ArrayList;
import java.util.HashSet;

import com.ben.model.Customer;
import com.ben.model.Profile;

public interface CustomerRepository {
	
	/**
	 * register a new customer to db
	 * @param customer
	 */
	public void create(Customer customer);
	
	/**
	 * save the customer table to an arraylist
	 * @return
	 */
	public ArrayList<Customer> save();
	public ArrayList<Profile> showProfiles(Customer customer);
	
	public void login(Customer customer);
	public void update(Customer customer);
	public void delete(Customer customer);
	
}
