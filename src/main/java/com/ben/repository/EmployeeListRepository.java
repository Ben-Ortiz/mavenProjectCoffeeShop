package com.ben.repository;

import java.util.ArrayList;

import com.ben.model.Employee;

public class EmployeeListRepository {
	
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();

	/**
	 * @param employeeList
	 */
	public EmployeeListRepository() {
		super();
//		this.employeeList = employeeList;
//		this.employeeList.add(new Employee("worker1", "password"));
//		this.employeeList.add(new Employee("worker2", "password"));
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	


}
