package com.ben;

import java.util.ArrayList;
import java.util.Scanner;

import com.ben.client.AppUI;
//import com.ben.model.Account;
import com.ben.model.Customer;
import com.ben.model.Employee;
import com.ben.repository.CustomerListRepository;
import com.ben.repository.CustomerRepository;
import com.ben.repository.CustomerRepositoryImpl;
import com.ben.repository.EmployeeListRepository;
import com.ben.service.CustomerService;

public class Driver {
	


	public static void main(String[] args) {

		CustomerService customerService = new CustomerService();
		
		Scanner scanner = new Scanner(System.in);

		boolean customerInMainPage = true;
		while (customerInMainPage) {
			
			CustomerListRepository customerListRepository = new CustomerListRepository();
			EmployeeListRepository employeeListRepository = new EmployeeListRepository();
			
			
			AppUI.mainCustomerPage();
			int mainPageAnswer = 0;
			mainPageAnswer = AppUI.handleUserSelectionNumberOnly(mainPageAnswer, scanner);
			/*
			 * scanner.nextLine() needed so it doesn't loop foerver.
			 */
			scanner.nextLine();

			switch (mainPageAnswer) {
			case 1://done 
				//prints customer view
				AppUI.loginPage();
				//gets userinput and saves it in customer object, loginCustomer
				Customer loginCustomer = AppUI.getCustomerInformation(scanner);
				//puts the query from db into an arraylist in customerListRepository
				
				customerListRepository.setCustomerList(customerService.save());
				
				loginCustomer = AppUI.customerFound(scanner, loginCustomer, customerService);
				
				if(loginCustomer != null) {
					AppUI.customerLoggedInPage(scanner, loginCustomer, customerService);
				}
				break;
			case 2://fixed
				AppUI.exitOrRegisterCustomerRegisterPage(scanner, customerService);
				break;
			case 3://this is fine
				System.out.println("you typed 3, exit now");
				customerInMainPage = false;
				break;
			case 4: //fixed
				AppUI.printCustomerRepo(customerService);
				break;
			case 5:
//				loginPageEmployee(employeeListRepository, customerListRepository);
				AppUI.employeeLoginPage(scanner);
				break;
				
			}
		}

		scanner.close();
		

	}

}
