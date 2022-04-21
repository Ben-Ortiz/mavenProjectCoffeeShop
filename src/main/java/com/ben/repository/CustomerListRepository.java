package com.ben.repository;

import java.util.ArrayList;

import com.ben.model.Customer;

public class CustomerListRepository {
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> userList) {
		customerList = userList;
	}
	
	

}
