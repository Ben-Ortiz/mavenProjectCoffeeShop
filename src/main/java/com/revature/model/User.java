package com.revature.model;

import java.util.*;

/*
 * the parent class 
 * 
 * notes for myself:
 * think of customers with multiple accounts as this: bank user with multiple accounts, like checking and saving.
 * This of customer class as the parent class.
 * With 1 child class: accounts. You can make multiple accounts,
 * The secondary user would be another user that can access this customer class.
 * 
 *  Think of it like this.
 *  
 *  Netflix needs a "user" account. With that user account you can create multiple "profiles".
 *  A secondary user can access the first user account with a different username and different password if the original user gives that
 *  secondary user access.
 *  
 */
public class User {

	private static ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<Account> accountList = new ArrayList<Account>();
	private String userRealName;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userAddress;
	private int userDOB;
	private int wallet;

	/**
	 * This constructor will be used to login
	 * 
	 * @param userName
	 * @param userPassword
	 * 
	 */
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public static void addToUserList(User user) {
		userList.add(user);
	}

	public static ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		User.userList = userList;
	}

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(int userDOB) {
		this.userDOB = userDOB;
	}
	

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "User [accountList=" + accountList + ", userRealName=" + userRealName + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userAge=" + userAge + ", userAddress=" + userAddress
				+ ", userDOB=" + userDOB + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountList == null) ? 0 : accountList.hashCode());
		result = prime * result + ((userAddress == null) ? 0 : userAddress.hashCode());
		result = prime * result + userAge;
		result = prime * result + userDOB;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userRealName == null) ? 0 : userRealName.hashCode());
		result = prime * result + wallet;
		return result;
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
		User other = (User) obj;
		if (accountList == null) {
			if (other.accountList != null) {
				return false;
			}
		} else if (!accountList.equals(other.accountList)) {
			return false;
		}
		if (userAddress == null) {
			if (other.userAddress != null) {
				return false;
			}
		} else if (!userAddress.equals(other.userAddress)) {
			return false;
		}
		if (userAge != other.userAge) {
			return false;
		}
		if (userDOB != other.userDOB) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		if (userPassword == null) {
			if (other.userPassword != null) {
				return false;
			}
		} else if (!userPassword.equals(other.userPassword)) {
			return false;
		}
		if (userRealName == null) {
			if (other.userRealName != null) {
				return false;
			}
		} else if (!userRealName.equals(other.userRealName)) {
			return false;
		}
		if (wallet != other.wallet) {
			return false;
		}
		return true;
	}
	
	

}
