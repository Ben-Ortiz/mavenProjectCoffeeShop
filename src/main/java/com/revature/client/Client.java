package com.revature.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.model.User;
import com.revature.repository.CoffeeRepository;
import com.revature.repository.CoffeeRepositoryImpl;

/*
 * I'm gonna have to redo this whole thing again.
 */
public class Client {

	public static void registerPage() {
		System.out
				.println("Welcome to the register page. Enter a username you want to use and password you want to use."
						+ " If you want to go back to the login page enter 1.");
	}
	
	public static void signInPage() {
		System.out.println("Welcome to the sign in page. Please sign in with your username and password. If you want to go back to the login page enter 1");
	}

	public static void loginPage() {
		System.out.println("Welcome to the login page. Please make a selection"
				+ "\n 1. Sign in"
				+ "\n 2. Register"
				+ "\n 3. Go back to main page");
	}

	public static void coffeeShopPage() {
		// where you show the selection of coffees you can buy
	}

	public static void welcomeMessage() {
		System.out.println("Welcome to Ben's Coffee shop! Where we have coffee that would keep even the dead awake."
				+ "\n 1. View the coffee menu" + "\n 2. View the history of Ben's Coffee shop."
				+ "\n 3. Go to the login page." + "\n 4. Exit the coffee shop.");
	}

	public static void historyOfCoffeeShop() {
		System.out.println(
				"The history of the Coffee shop began in Seattle, Washington. \nStarted before Starbucks, their coffee has the tastiest"
						+ " and most caffeine content allowed by FDA for human consumption. \nGuaranteed to keep you awake with just one sip.");
	}

	public static void initializeSigninPageUI() {
		
		ArrayList<User> userList = User.getUserList();
		Scanner scanner = new Scanner(System.in);
		
		boolean isUserInSignInPage = true;
		while(isUserInSignInPage) {
			
			signInPage();
			
			System.out.println("UserName: ");
			String signInPageUserAnswer = scanner.nextLine();
			if (signInPageUserAnswer.equals("1")) {
				break;
			}
			String signInPageUserPW = scanner.nextLine();
			
			if(userList.contains(new User(signInPageUserAnswer,signInPageUserPW))) {//this probhably can be done better
				System.out.println("Success. You are logged in.");
				
			} else {
				System.out.println("User not found or password incorrect. Try again");
			}
			
			System.out.println(userList);
			
		}
	}

	public static void initializeRegisterPageUI() {
		Scanner scanner = new Scanner(System.in);

		boolean isUserInRegisterPage = true;
		while (isUserInRegisterPage) {

			registerPage();

			System.out.print("Username: ");
			String registerPageUserAnswer = scanner.nextLine();

			if (registerPageUserAnswer.equals("1")) {
				break;
			}

			System.out.print("Password: ");
			String registerPageUserPW = scanner.nextLine();

			User.addToUserList(new User(registerPageUserAnswer, registerPageUserPW));

			ArrayList<User> temp = User.getUserList();
			System.out.println(temp.toString());

		}
	}

	public static void initializeLoginPageUI() {


		Scanner scanner = new Scanner(System.in);

		boolean isUserInLoginPage = true;
		while (isUserInLoginPage) {

			loginPage();

			int userAnswer = scanner.nextInt();

			switch (userAnswer) {
			case 1:
				initializeSigninPageUI();
				break;
			case 2:
				initializeRegisterPageUI();
				break;
			case 3:
				isUserInLoginPage = false;
				break;
			}

		}
	}

	public static void intializeCoffeeShopUI() {

		CoffeeRepository coffeeRepository = new CoffeeRepositoryImpl();

		Scanner scanner = new Scanner(System.in);

		boolean isUserHere = true;
		boolean isLoggedIn = true;

		while (isUserHere) {

			welcomeMessage();

			int userAnswer = scanner.nextInt();

			switch (userAnswer) {
			case 1:
				
				coffeeRepository.printCoffeeList();
				if(isLoggedIn == true) {
					coffeeRepository.pickCoffee();
				} else {
					System.out.println("Login or Register first before buying a coffee");
				}
				
				break;
			case 2:
				historyOfCoffeeShop();
				break;
			case 3:
				initializeLoginPageUI();
				break;
			case 4:
				System.out.println("bye customer");
				isUserHere = false;
				break;

			}
		}
		scanner.close();
	}

}
