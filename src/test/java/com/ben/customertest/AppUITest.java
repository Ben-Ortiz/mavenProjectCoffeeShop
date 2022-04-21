package com.ben.customertest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ben.client.AppUI;
import com.ben.model.Customer;
import com.ben.model.Employee;
import com.ben.model.Profile;

import uk.org.webcompere.systemstubs.SystemStubs;

/*
 * video is day 5, last video on testing, not mockito
 */

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class AppUITest {
	
	private AppUI appUI;

	
	@BeforeAll
	public void beforeAll() {
		this.appUI = new AppUI();
	}
	
	
	@Test
	public void testGeCustomerInformation() throws Exception{
		SystemStubs.withTextFromSystemIn("ben", "123").execute(() -> {
			Scanner scanner = new Scanner(System.in);
			Customer customer = AppUI.getCustomerInformation(scanner);
			Customer testCustomer = new Customer("ben", "123");
			Assertions.assertEquals(customer, testCustomer);
		});
		
		
	}
	
	@Test
	public void testGetEmployeeInformation() throws Exception {
		SystemStubs.withTextFromSystemIn("worker1", "123").execute(() -> {
			Scanner scanner = new Scanner(System.in);
			Employee employee = AppUI.getEmployeeInformation(scanner);
			Employee testEmployee = new Employee("worker1", "123", false);
			Assertions.assertEquals(employee, testEmployee);
			
			
		});
	}
	
	@Disabled
	@Test
	public void testsomething() throws Exception {
		SystemStubs.withTextFromSystemIn("1").execute(() -> {
			Scanner scanner = new Scanner(System.in);
			Mockito.when(AppUI.handleUserSelectionNumberOnly(1, scanner)).thenReturn(1);
			int ans = AppUI.handleUserSelectionNumberOnly(1, scanner);
			Assertions.assertEquals(1, ans);
			
			
		});
	}
	
	@Test
	public void testWelcomeString() {
		String actual = AppUI.welcomeString();
		Assertions.assertEquals("welcome to the main customer page  enter 1 to login, 2 to register, 3 to exit, 4 to print customerList, 5 for employee login", actual);
	}
	
	@Test
	public void testRegisterPageString() {
		String actual = AppUI.registerPageString();
		Assertions.assertEquals("welcome to the register page, register your username and password. type 1 to exit, type 2 to register a new customer", actual);
	}
	
	@Test
	public void testLoginPageString() {
		String actual = AppUI.loginPageString();
		Assertions.assertEquals("welcome to the login page, login with your username and password. type 1 to exit", actual);
	}
	
	@Test
	public void test7() {
		String actual = AppUI.notNumber();
		Assertions.assertEquals("You entered something other than a number, enter a choice that's a number and type enter", actual);
	}
	
	@Test
	public void test8() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	
	@Test
	public void test9() {
		String actual = AppUI.changeToWhatString();
		Assertions.assertEquals("change their name to what?", actual);
		
	}
	
	@Test
	public void test10() {
		String actual = AppUI.changePWToWhatString();
		Assertions.assertEquals("change their password to what?", actual);
	}
	
	@Test
	public void test11() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	
	@Test
	public void test12() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	
	@Test
	public void test13() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	
	@Test
	public void test14() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	
	@Test
	public void test15() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	
	@Test
	public void test16() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	
	@Test
	public void test17() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	
	@Test
	public void test18() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test19() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test20() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test21() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test22() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test23() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test24() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test25() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test26() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test27() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test28() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test29() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	@Test
	public void test30() {
		String actual = AppUI.pickCustomerString();
		Assertions.assertEquals("pick the customerID you want to modify, or type 1 to exit", actual);
	}
	
	
	

}
