package com.ben.service;

import java.util.ArrayList;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ben.model.Customer;
import com.ben.model.Profile;
import com.ben.repository.CustomerRepository;
import com.ben.repository.CustomerRepositoryImpl;

/**
 * this is where logging would also happen
 * @author benor
 *
 */
public class CustomerService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	private CustomerRepository customerRepository;
	
	/**
	 * @param customerRepository
	 */
	public CustomerService() {
		super();
		this.customerRepository = new CustomerRepositoryImpl();
	}
	
	public void loginCustomer(Customer customer) {
		ArrayList<Customer> customers = customerRepository.save();
		
	}
	
	

	/**
	 * this method will add a customer to the customer table in the db just passing the customer object to to customerRepository.create(Customer customer)
	 * @param customer
	 */
	public void create(Customer customer) {
		this.customerRepository.create(customer);
	}
	
	/*
	 * reason this wasn't working initially was because ther was no object instance that was being made to call the read method
	 * making a constructor created the impl method that then points to customerRepository. A private variable rn that can be seen as
	 * private CustomerRepository customerRepository = null;
	 * 
	 * the CustomerService constructor created a new object of customerRepositoryImpl that allowed the customerRepository to use CustomerRepositoryImpl's methods
	 * 
	 * this method just reads from the db the customers table
	 */
	public ArrayList<Customer> save() {
		return this.customerRepository.save();
	}
	
	public ArrayList<Profile> showProfiles(Customer customer) {
		return this.customerRepository.showProfiles(customer);
	}

}
