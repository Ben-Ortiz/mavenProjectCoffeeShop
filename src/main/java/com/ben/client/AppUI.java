package com.ben.client;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ben.model.Coffee;
import com.ben.model.Customer;
import com.ben.model.Employee;
import com.ben.model.Profile;
import com.ben.model.Wallet;
import com.ben.repository.CoffeeRepositoryImpl;
import com.ben.repository.CustomerRepositoryImpl;
import com.ben.repository.EmployeeRepositoryImpl;
import com.ben.repository.ProfileRepositoryImpl;
import com.ben.repository.WalletRepositoryImpl;
import com.ben.service.CustomerService;

/**
 * this is where anyhting you see on the app would be made
 * @author benor
 *
 */
public class AppUI {
	
	private static final Logger logger = LoggerFactory.getLogger(AppUI.class);
//	CustomerService customerService = new CustomerService();
	static ProfileRepositoryImpl profileRepositoryImpl = new ProfileRepositoryImpl();
	static WalletRepositoryImpl walletRepositoryImpl = new WalletRepositoryImpl();
	static CoffeeRepositoryImpl coffeeRepositoryImpl = new CoffeeRepositoryImpl();
	static EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl();
	static CustomerRepositoryImpl customerRepositoryImpl = new CustomerRepositoryImpl();
//	static AppUI appUI = new AppUI();

	
	public static String welcomeString() {
		return "welcome to the main customer page  enter 1 to login, 2 to register, 3 to exit, 4 to print customerList, 5 for employee login";
	}
	
	public static void mainCustomerPage() {
		System.out.println(welcomeString());
		logger.info("the welcome page of customer");
	}
	
	public static String registerPageString() {
		return "welcome to the register page, register your username and password. type 1 to exit, type 2 to register a new customer";
	}
	
	public static void registerPage() {
		System.out.println(registerPageString());
		logger.info("the register page of customer");
	}
	
	public static String loginPageString() {
		return "welcome to the login page, login with your username and password. type 1 to exit";
	}
	
	public static void loginPage() {
		System.out.println(loginPageString());
		logger.info("the login page of customer");
	}
	
	public static String notNumber () {
		return "You entered something other than a number, enter a choice that's a number and type enter";
	}
	
	/**
	 * this method handles user selection if they enter anything else but a number
	 * @param userAnswer
	 * @param scanner
	 * @return an int of what the user picked
	 */
	public static int handleUserSelectionNumberOnly(int userAnswer, Scanner scanner) {
		
		try {
			userAnswer = scanner.nextInt();
		}catch(InputMismatchException e) {
			System.out.println(notNumber());
		}
		
		return userAnswer;
	}
	
	public static String pickCustomerString() {
		return "pick the customerID you want to modify, or type 1 to exit";
	}
	
	public static String changeToWhatString() {
		return "change their name to what?";
	}
	
	public static String changePWToWhatString() {
		return "change their password to what?";
	}
	
	public static void adminModifyCustomers(Scanner scanner) {
		
//		ArrayList<Customer> customersListForAdmin = customerRepositoryImpl.save();
		
		boolean adminModifyCustomersPage = true;
		while (adminModifyCustomersPage) {
			ArrayList<Customer> customersListForAdmin = customerRepositoryImpl.save();
			for(Customer c: customersListForAdmin) {
				System.out.println(c);
			}
			
			System.out.println(pickCustomerString());
			int customerToModify = scanner.nextInt();
			if(customerToModify == 1) {
				break;
			}
			
			scanner.nextLine();
			
			System.out.println(changeToWhatString());
			String newName = scanner.nextLine();
			
			System.out.println(changePWToWhatString());
			String newPassword = scanner.nextLine();
			
			//DB UPDATE
			customerRepositoryImpl.modifyCustomer(customerToModify, newName, newPassword);
			
			
			System.out.println("modifications success");
			
		}
		
		
		
	}

	public static void adminModifyWallets(Scanner scanner) {
		
		ArrayList<Wallet> walletsOfAllCustomers = walletRepositoryImpl.saveAllWalletsOfCustomers();
		System.out.println("do you want to add or remove funds?");
		boolean adminModifyWalletsPage = true;
		while (adminModifyWalletsPage) {
			
			int walletAmount = 0;
			
			String addOrRemoveAns = scanner.nextLine();
			
			if(addOrRemoveAns.equalsIgnoreCase("add")) {
				
				System.out.println("How much do you want to add?");
				int amountToAdd = scanner.nextInt();
				
				
				scanner.nextLine();
				
				System.out.println("to which wallet?");

				
				//print wallets
				for(Wallet w: walletsOfAllCustomers) {
					System.out.println(w.getWalletName() + " has " + w.getFunds());
				}
				
				String walletToAddIn = scanner.nextLine();
				
				if(amountToAdd < 0) {
					System.out.println("can't add a negative amount");
					break;
				}

				//DB UPDATE
				walletRepositoryImpl.addFundsAdmin(walletToAddIn, amountToAdd);
				System.out.println("added");
				break;
				
			} else if(addOrRemoveAns.equalsIgnoreCase("remove")) {
				System.out.println("How much do you want to remove?");
				int amountToRemove = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("from which wallet?");
				
				//print wallets
				for(Wallet w: walletsOfAllCustomers) {
					System.out.println(w.getWalletName() + " has " + w.getFunds());
				}
				
				String walletToRemoveFrom = scanner.nextLine();
				

				
				if(amountToRemove > walletAmount) {
					System.out.println("cant remove " + amountToRemove + " from " + walletToRemoveFrom + ". there's only " + walletAmount + " in that wallet");
					break;
				}
				
				//DB UPDATE
				walletRepositoryImpl.removeFundsAdmin(walletToRemoveFrom, amountToRemove);
				System.out.println("removed");
				break;
				
			}
			
		}
	}
	
	public static void adminMainPage(Employee employee, Scanner scanner) {
		
		boolean adminInMainPage = true;
		while (adminInMainPage) {
			
			System.out.println("welcome to the admin main page, type 1 to cancel accounts, type 2 modify wallets, type 3 to modify customer info, type 4 to exit");
			int employeeAnswer = scanner.nextInt();
			
			switch(employeeAnswer) {
			case 1:
				System.out.println("welcome to the admin cancel accounts page, type 1 show list customer accounts to cancel, type 2 to exit");
				employeeInCancelAccountsPage(employee, scanner);
//				break;
			case 2:
				adminModifyWallets(scanner);
				break;
			case 3:
				adminModifyCustomers(scanner);
				break;
			case 4:
				System.out.println("exit the admin page");
				adminInMainPage = false;
				break;
				
			}
			
		}
		
	}
	
	public static void employeeInCancelAccountsPage(Employee employee, Scanner scanner) {
		boolean employeeInCancelAccountsPage = true;
		while (employeeInCancelAccountsPage) {
//			System.out.println("welcome to the employee cancel accounts page, type 1 show list customer accounts to cancel, type 2 to exit");
			int employeeAnswer = scanner.nextInt();
			
			switch(employeeAnswer) {
			case 1:
				ArrayList<Wallet> walletsOfAllCustomers = walletRepositoryImpl.saveAllWalletsOfCustomers();
				for(Wallet w: walletsOfAllCustomers) {
					System.out.println(w.getWalletName() + " has " + w.getFunds());
				}
				System.out.println("which account do you want to cancel?");
				scanner.nextLine();
				String walletName = scanner.nextLine();
				
				
				Wallet walletToCancel = new Wallet();
				for(Wallet w: walletsOfAllCustomers) {
					if(w.getWalletName().equalsIgnoreCase(walletName)) {
						walletToCancel.setWalletName(w.getWalletName());
						walletToCancel.setFunds(w.getFunds());
						walletToCancel.setWalletID(w.getWalletID());
						walletToCancel.setProfileName(w.getProfileName());
						break;
					}
				}
				
				//UPDATE DB HERE
				walletRepositoryImpl.removeWallet(walletToCancel);
				
				break;
			case 2:
				employeeInCancelAccountsPage = false;
				break;
			}
			
			
		}
		
		
	}
	
	public static void employeeViewsCustomerInfo(Employee employee, Scanner scanner) {
		boolean employeeInViewsCustomerInfoPage = true;
		while (employeeInViewsCustomerInfoPage) {
			System.out.println("welcome to the employee views customer info page, type 1 for customer info, type 2 to exit");
			int employeeAnswer = scanner.nextInt();
			
			switch(employeeAnswer) {
			case 1:
				ArrayList<Customer> customers = customerRepositoryImpl.save();
				for(Customer c: customers) {
					System.out.println(c);
				}
				break;
			case 2:
				employeeInViewsCustomerInfoPage = false;
				break;
			}
			
			
		}
		
		
	}
	
	public static void employeViewsAccountBalances(Employee employee, Scanner scanner) {
		boolean employeeInViewsAccountBalancesPage = true;
		while (employeeInViewsAccountBalancesPage) {
			System.out.println("welcome to the employee views account balances page, type 1 for account balances, type 2 to exit");
			int employeeAnswer = scanner.nextInt();
			
			switch(employeeAnswer) {
			case 1:
				ArrayList<Wallet> walletsOfAllCustomers = walletRepositoryImpl.saveAllWalletsOfCustomers();
				for(Wallet w: walletsOfAllCustomers) {
					System.out.println(w.getWalletName() + " has " + w.getFunds());
				}
				break;
			case 2:
				employeeInViewsAccountBalancesPage = false;
				break;
			}
			
			
		}
	}
	
	public static void employeeViewsAccountInfo(Employee employee, Scanner scanner) {
		
		boolean employeeInViewAccountInfoPage = true;
		while (employeeInViewAccountInfoPage) {
			System.out.println("welcome to the employee views accounts and users page, type 1 for account information, type 2 to exit");
			int employeeAnswer = scanner.nextInt();
			
			switch(employeeAnswer) {
			case 1:
				ArrayList<Wallet> walletsOfAll = walletRepositoryImpl.saveAllWalletsOfProfiles();
				for(Wallet w: walletsOfAll) {
					System.out.println(w.getProfileName() + " has access to " + w.getWalletName());
				}
				break;
			case 2:
				employeeInViewAccountInfoPage = false;
				break;
			}
			
			
		}
		
	}
	
	public static void employeeMainPage(Employee employee, Scanner scanner) {
		
		boolean employeeInMainPage = true;
		while (employeeInMainPage) {
			
			System.out.println("welcome to the employee main page, type 1 for account information, type 2 for account balances, type 3 for customer information, type 4 to cancel accounts, type 5 to exit");
			int employeeAnswer = scanner.nextInt();
			
			switch(employeeAnswer) {
			case 1:
				employeeViewsAccountInfo(employee, scanner);
				break;
			case 2:
				employeViewsAccountBalances(employee, scanner);
				break;
			case 3:
				employeeViewsCustomerInfo(employee, scanner);
				break;
			case 4:
				System.out.println("welcome to the employee cancel accounts page, type 1 show list customer accounts to cancel, type 2 to exit");
				employeeInCancelAccountsPage(employee, scanner);
				break;
			case 5:
				employeeInMainPage = false;
				break;
			}
			
		}
		
	}
	
	
	public static void employeeLoginPage(Scanner scanner) {
		boolean employeeLoginPage = true;
		while (employeeLoginPage) {
			System.out.println("this is the employee login page, type your username and password");
			Employee employeeLoggingIn = getEmployeeInformation(scanner);
			
			if(employeeLoggingIn.getEmployeeName().isEmpty() || employeeLoggingIn.getEmployeePassword().isEmpty()) {
				System.out.println("you entered an empty name or password try again");
				break;
			}
			
			ArrayList<Employee> employees = employeeRepositoryImpl.save();
			
			for(Employee e: employees) {
				boolean employeeFound = employeeLoggingIn.getEmployeeName().equals(e.getEmployeeName()) 
						&& employeeLoggingIn.getEmployeePassword().equals(e.getEmployeePassword());
				
				boolean adminFound = employeeLoggingIn.getEmployeeName().equals(e.getEmployeeName()) 
						&& employeeLoggingIn.getEmployeePassword().equals(e.getEmployeePassword()) 
						&& e.isIsAdmin() == true;
				
				if(adminFound) {
					System.out.println("welcome admin");
					System.out.println(e);
					adminMainPage(e, scanner);
					break;
				} else if(employeeFound) {
					
//					System.out.println("employee found " + e);
					employeeMainPage(e, scanner);
					break;
				}
			}
			break;
		}
		
	}
	
	public static void storePage(String profileName, Scanner scanner, Customer customer) {
		
		ArrayList<Coffee> coffeeList = coffeeRepositoryImpl.saveCoffee();
		Wallet pickedWallet = customer.getWalletPicked();
		int coffeeCost = 0;
		int amountInWallet = 0;
		int newWalletAmount = 0;
		
		boolean customerInStorePage = true;
		while (customerInStorePage) {
			System.out.println("Welcome to Ben's Coffee Shop! Here is our selection of coffees. Pick the one you want to drink.");
			
			System.out.println(pickedWallet + "is the wallet you have");
			
			for(Coffee c: coffeeList) {
				System.out.println(c.getCoffeeName() + " " + c.getCoffeeCost());
			}
			
			
			System.out.println("enter the name of the coffee you want to buy, or type 1 to exit");
			String coffeeChoice = scanner.nextLine();
			if(coffeeChoice.equalsIgnoreCase("1")) {
				break;
			}
			
			for(Coffee c: coffeeList) {
				if(c.getCoffeeName().equalsIgnoreCase(coffeeChoice)) {
					coffeeCost = c.getCoffeeCost();
					amountInWallet = pickedWallet.getFunds();
					newWalletAmount = amountInWallet - coffeeCost;
					pickedWallet.setFunds(newWalletAmount);
				}
			}
			
			System.out.println("thank you for ordering the latte! that'll be " + coffeeCost);
			System.out.println("you only have " + newWalletAmount + " left in your wallet");
			
			
			
			//MAKE DB UPDATE THIS 
			walletRepositoryImpl.removeFunds(pickedWallet.getWalletName(), coffeeCost, customer);
			
			
		}
	}
	
	public static void transferFundsBetweenWallets(Scanner scanner, Customer customer, ArrayList<Wallet> walletsOfCustomer) {
		
		boolean customerInTransferFundsBetweenWalletsPage = true;
		while (customerInTransferFundsBetweenWalletsPage) {
			
			System.out.println("pick the wallet you want to transfer from");
			
			for(Wallet w: walletsOfCustomer) {
				System.out.println(w.getWalletName() + " "  + w.getFunds());
			}
			
			String walletNameToTransferFrom = scanner.nextLine();
			
			System.out.println("how much do you want to transfer?");
			int amountToTransfer = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("To which wallet?");
			for(Wallet w: walletsOfCustomer) {
				System.out.println(w.getWalletName() + " "  + w.getFunds());
			}
			String walletNameToTransferTo = scanner.nextLine();
			
			
			walletRepositoryImpl.removeFunds(walletNameToTransferFrom, amountToTransfer, customer);
			walletRepositoryImpl.addFunds(walletNameToTransferTo, amountToTransfer, customer);
			
			System.out.println("success");
			
			break;
		}
		
	}
	
	public static void addProfilesToWallets(Scanner scanner, Customer customer, ArrayList<Wallet> walletsOfCustomer) {
		CustomerService customerService = new CustomerService();

		String walletToUse = "";
		boolean customerInAddProfilesToWalletsPage = true;
		while (customerInAddProfilesToWalletsPage) {
			for(Wallet w: walletsOfCustomer) {
				System.out.println(w.getWalletName());
			}
			System.out.println("pick the wallet you want give a profile access to");
			
			String walletName = scanner.nextLine();
			for(Wallet w: walletsOfCustomer) {
				if(w.getWalletName().equalsIgnoreCase(walletName)) {
					walletToUse = w.getWalletName();
					
					
					break;
				}
			}
			
			
			ArrayList<Profile> profiles = customerService.showProfiles(customer);
			for(Profile p: profiles) {
				System.out.println(p.getProfileName());
			}
			
			System.out.println("which profile do you want to give access to this wallet?");
			String profileToGiveAccess = scanner.nextLine();
			
			System.out.println(profileToGiveAccess);
			
			walletRepositoryImpl.addWalletToProfile(walletToUse, profileToGiveAccess);
			System.out.println("success");
			customerInAddProfilesToWalletsPage = false;
			break;
			
		}
		
	}
	
	
	public static void addOrRemoveFundsAccountPage(Scanner scanner, Customer customer) {
//		System.out.println("add profiles to an acc");
//		System.out.println(customer.getCustomerID());
		
//		ArrayList<Wallet> walletsOfCustomer = walletRepositoryImpl.getAccountsOfCustomer(customer);
		customer.setWalletList(walletRepositoryImpl.getAccountsOfCustomer(customer));
		
		
		boolean customerInAddOrRemoveFundsAccountPage = true;
		while (customerInAddOrRemoveFundsAccountPage) {
			
			int walletAmount = 0;
			
			
			
			System.out.println("do you want to add or remove funds?");
			
			String addOrRemoveAns = scanner.nextLine();
			
			if(addOrRemoveAns.equalsIgnoreCase("add")) {
				
				System.out.println("How much do you want to add?");
				int amountToAdd = scanner.nextInt();
				
				
				scanner.nextLine();
				
				System.out.println("to which wallet?");
				String walletToAddIn = scanner.nextLine();
				
				if(amountToAdd < 0) {
					System.out.println("can't add a negative amount");
					break;
				}

				
				
				

				walletRepositoryImpl.addFunds(walletToAddIn, amountToAdd, customer);
				System.out.println("added");
				break;
				
			} else if(addOrRemoveAns.equalsIgnoreCase("remove")) {
				System.out.println("How much do you want to remove?");
				int amountToRemove = scanner.nextInt();
				
				

				scanner.nextLine();
				
				System.out.println("from which wallet?");
				String walletToRemoveFrom = scanner.nextLine();
				
				for(Wallet w: customer.getWalletList()) {
					if(w.getWalletName().equalsIgnoreCase(walletToRemoveFrom)) {
						walletAmount = w.getFunds();
					}
				}
				
				if(amountToRemove > walletAmount) {
					System.out.println("cant remove " + amountToRemove + " from " + walletToRemoveFrom + ". there's only " + walletAmount + " in that wallet");
					break;
				}
				
				
				walletRepositoryImpl.removeFunds(walletToRemoveFrom, amountToRemove, customer);
				System.out.println("removed");
				break;
				
				
			}
			
			
		}
		
		
	}
	
	
	public static void addWalletForCustomer(Scanner scanner, Customer customer) {
		boolean customerAddWalletForCustomerPage = true;
		while (customerAddWalletForCustomerPage) {
			
			int customerID = customer.getCustomerID();
			
			System.out.println("welcome to add the wallet for customer page");
			System.out.println("what do you want to name this wallet?");
			String walletName = scanner.nextLine();
			
			System.out.println("how much do you want to put in this wallet?");
			int amountToPutIn = scanner.nextInt();
			
//			scanner.nextLine();
			
//			System.out.println("whats the password for this wallet?");
			String newPW = "";
			
			walletRepositoryImpl.addWalletToCustomer(walletName, customerID, amountToPutIn, newPW);
			
			System.out.println("successfully added wallet");
			break;
			
		}
	}
	
	public static void walletsPage(Scanner scanner, Customer customer, ArrayList<Wallet> walletsOfCustomer) {
		boolean customerInWalletPage = true;
		while (customerInWalletPage) {

			System.out.println("Welcome to the wallet page, type 1 to add/remove funds to a wallet, 2 to add profiles to a wallet, 3 to transfer funds between wallets, 4 to add a wallet for this customer , 5 to exit");
//			ArrayList<Wallet> walletsOfCustomer = walletRepositoryImpl.getAccountsOfCustomer(customer);
			System.out.println("Wallets of customer: ");
			for(Wallet w: walletsOfCustomer) {
				System.out.println(w.getWalletName() + " " + w.getFunds());
			}
			
			int mainPageAnswer = 0;
			mainPageAnswer = handleUserSelectionNumberOnly(mainPageAnswer, scanner);
			/*
			 * scanner.nextLine() needed so it doesn't loop foerver.
			 */
			scanner.nextLine();
			
			switch (mainPageAnswer) {
			case 1:
//				System.out.println("add/remove funds to an account");
				addOrRemoveFundsAccountPage(scanner, customer);
				break;
			case 2:
				addProfilesToWallets(scanner, customer, walletsOfCustomer);
				break;
			case 3:
				transferFundsBetweenWallets(scanner, customer, walletsOfCustomer);
				break;
			case 4:
				addWalletForCustomer(scanner, customer);
				break;
			case 5:
				System.out.println("exit wallets");
				customerInWalletPage = false;
				break;
			}
			
			
		}
	}
	
	public static void profileMainPage(String profileName, Scanner scanner, Customer customer) {
		
		System.out.println("the profile you picked is " + profileName);
		
		ArrayList<Wallet> walletsOfCustomer = walletRepositoryImpl.getAccountsOfCustomer(customer);
		
		ArrayList<Wallet> walletsProfileHasAccessTo = walletRepositoryImpl.saveWallets(profileName);
		
		//function merges 2 arraylists
		for(Wallet w: walletsOfCustomer) {
//			System.out.println(w);
//			System.out.println(w.getFunds());
			for(Wallet wp: walletsProfileHasAccessTo) {
//				System.out.println(wp);
				if(w.getWalletName().equalsIgnoreCase(wp.getWalletName())) {
					wp.setWalletID(w.getWalletID());
					wp.setFunds(w.getFunds());
				}
			}
			
		}
		
		
		boolean customerInProfileMainPage = true;
		while (customerInProfileMainPage) {
			System.out.println("welcome to your profile page, type 1 to enter the store or type 2 to pick which wallet to use from your profile, 3 to exit");
			
			//TODO program crashes if this sysout is hit
//			System.out.println(customer.getWalletPicked().getWalletName() + " is your wallet picked");
			
			int mainPageAnswer = 0;
			mainPageAnswer = handleUserSelectionNumberOnly(mainPageAnswer, scanner);
			/*
			 * scanner.nextLine() needed so it doesn't loop foerver.
			 */
			scanner.nextLine();
			
			switch (mainPageAnswer) {
			case 1:
				storePage(profileName, scanner, customer);
				break;
			case 2:
//				ArrayList<Wallet> walletsOfCustomer = walletRepositoryImpl.getAccountsOfCustomer(customer);
//				
//				ArrayList<Wallet> walletsProfileHasAccessTo = walletRepositoryImpl.saveWallets(profileName);
				
				
//				//function merges 2 arraylists
//				for(Wallet w: walletsOfCustomer) {
////					System.out.println(w);
////					System.out.println(w.getFunds());
//					for(Wallet wp: walletsProfileHasAccessTo) {
////						System.out.println(wp);
//						if(w.getWalletName().equalsIgnoreCase(wp.getWalletName())) {
//							wp.setWalletID(w.getWalletID());
//							wp.setFunds(w.getFunds());
//						}
//					}
//					
//				}

				for(Wallet w: walletsProfileHasAccessTo) {
					System.out.println(w);
				}
				
				System.out.println("pick the wallet you want to use. example: ben_acc1");
				
				//validate TODO
				String walletName = scanner.nextLine();
				
				Wallet walletPicked = new Wallet();
				
				for(Wallet w: walletsProfileHasAccessTo) {
					if(w.getWalletName().equalsIgnoreCase(walletName)) {
						walletPicked.setFunds(w.getFunds());
						walletPicked.setProfileName(w.getProfileName());
						walletPicked.setWalletID(w.getWalletID());
						walletPicked.setWalletName(w.getWalletName());
					}
				}
				
				System.out.println(walletPicked.getWalletName() + " is the wallet picked. amount: " + walletPicked.getFunds());
				
				customer.setWalletPicked(walletPicked);
				
				break;
			case 3:
				customerInProfileMainPage = false;
				break;
			}
		}
		
	}
	
	public static void addProfilePage(Scanner scanner, Customer customer) {
		
		boolean customerInAddProfilePage = true;
		while (customerInAddProfilePage) {
			
			System.out.println("welcome to add a profile page enter a profile name");
//			String ans = scanner.nextLine();
//			if(ans.equalsIgnoreCase("1")) {
//				break;
//			}

			Profile newProfile = getProfileInformation(scanner);
			System.out.println(newProfile);
			profileRepositoryImpl.createProfile(newProfile, customer);
			
			break;
		}
		
	}
	
	

	public static void profilePage(Scanner scanner, Customer customer, CustomerService customerService, ArrayList<Wallet> walletsOfCustomer) {
		
		boolean customerInProfilePage = true;
		while (customerInProfilePage) {

			System.out.println("Welcome to the profiles page, pick the profile you want to use, or type 1 to exit");
			
			ArrayList<Profile> profiles = customerService.showProfiles(customer);
			
			for(Profile p: profiles) {
				System.out.println(p.getProfileName());
			}
			
//			int mainPageAnswer = 0;
//			mainPageAnswer = handleUserSelectionNumberOnly(mainPageAnswer, scanner);
//			/*
//			 * scanner.nextLine() needed so it doesn't loop foerver.
//			 */
//			scanner.nextLine();
			
			
			String profileName = scanner.nextLine();
			if(profileName.equalsIgnoreCase("1")) {
				break;
			}
			for(Profile p: profiles) {
				if(p.getProfileName().equalsIgnoreCase(profileName)) {
					profileMainPage(profileName, scanner, customer);
				}
			}
			
			System.out.println("profile doesnt exist type again");
			
		}
		
	}
	
	
	public static void customerLoggedInPage(Scanner scanner, Customer customer, CustomerService customerService) {
		
		boolean customerInLoggedInPage = true;
		while (customerInLoggedInPage) {

			System.out.println("Welcome customer "+ customer.getCustomerName() + " you have logged in, type 1 to pick the profile, type 2 to add a profile, type 3 to go to the wallets page, 4 to exit");
//			System.out.println(customer.getCustomerID());
			ArrayList<Wallet> wallets = walletRepositoryImpl.getAccountsOfCustomer(customer);
			int mainPageAnswer = 0;
			mainPageAnswer = handleUserSelectionNumberOnly(mainPageAnswer, scanner);
			/*
			 * scanner.nextLine() needed so it doesn't loop foerver.
			 */
			scanner.nextLine();
			
			switch (mainPageAnswer) {
			case 1:
				profilePage(scanner, customer, customerService, wallets);
				break;
			case 2:
				addProfilePage(scanner, customer);
				break;
			case 3:
//				ArrayList<Wallet> wallets = walletRepositoryImpl.getAccountsOfCustomer (customer);
				walletsPage(scanner, customer, wallets);
				
				break;
			case 4:
				System.out.println("exited");
				customerInLoggedInPage = false;
				break;
			}
		}
			
		
	}
	
	
	public static Customer customerFound(Scanner scanner, Customer customer, CustomerService customerService) {
		for(Customer c: customerService.save()) {
//			System.out.println(c);
			
			if(customer.getCustomerName().equalsIgnoreCase(c.getCustomerName()) && customer.getCustomerPassword().equalsIgnoreCase(c.getCustomerPassword())) {
				return c;
			}
		}
		
		return null;
	}
	
	
	public static void exitOrRegisterCustomerRegisterPage(Scanner scanner, CustomerService customerService) {

		boolean customerInRegisterPage = true;
		while (customerInRegisterPage) {
			registerPage();
			int mainPageAnswer = 0;
			mainPageAnswer = handleUserSelectionNumberOnly(mainPageAnswer, scanner);
			/*
			 * scanner.nextLine() needed so it doesn't loop foerver.
			 */
			scanner.nextLine();
			
			switch (mainPageAnswer) {
			case 1:
				customerInRegisterPage = false;
				break;
			case 2:
				Customer newCustomer = getCustomerInformation(scanner);
				customerService.create(newCustomer);
				break;
			}

		}
	}
	
	
	public static Customer getCustomerInformation(Scanner scanner) {
		Customer customer = new Customer();
		System.out.println("Enter the customer username: ");
		

		customer.setCustomerName(scanner.nextLine());
		System.out.println("Enter the customer password: ");
		customer.setCustomerPassword(scanner.nextLine());
//		System.out.println("Is this customer a secondary user?");
		
		return customer;
	}
	
	
	public static Profile getProfileInformation(Scanner scanner) {
		Profile profile = new Profile();
		System.out.println("Enter the profile username: ");
		profile.setProfileName(scanner.nextLine());
		System.out.println("are they the main profile?");
		profile.setMainProfile(scanner.nextBoolean());
		
		return profile;
	}
	
	public static Employee getEmployeeInformation(Scanner scanner) {
		Employee employee = new Employee();
		System.out.println("Enter the employee name");
		String employeeName = scanner.nextLine();
		
		employee.setEmployeeName(employeeName);
		System.out.println("Enter the employee password");
		employee.setEmployeePassword(scanner.nextLine());
		
		return employee;
	}

	
	/**
	 * method that prints what's on the customer table from the arraylist populated by the db
	 * @param customerService needs to be passed a CustomerService object
	 */
	public static void printCustomerRepo(CustomerService customerService) {
		for(Customer customer: customerService.save()) {
			System.out.println(customer);
		}
	}

}
