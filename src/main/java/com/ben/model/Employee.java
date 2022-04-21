package com.ben.model;

import java.util.Objects;

public class Employee {
	
	private String employeeName;
	private String employeePassword;
	private boolean IsAdmin;
	
	
	/**
	 * 
	 */
	public Employee() {
		super();
	}

	
	/**
	 * @param employeeName
	 * @param employeePassword
	 * @param isAdmin
	 */
	public Employee(String employeeName, String employeePassword, boolean isAdmin) {
		super();
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		IsAdmin = isAdmin;
	}


	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public boolean isIsAdmin() {
		return IsAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		IsAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeePassword=" + employeePassword + ", IsAdmin="
				+ IsAdmin + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(IsAdmin, employeeName, employeePassword);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		return IsAdmin == other.IsAdmin && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeePassword, other.employeePassword);
	}
	
	

	
	
	

}
