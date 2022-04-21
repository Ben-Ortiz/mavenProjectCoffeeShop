package com.ben.model;

/**
 * this class is suppoed to be accounts
 * @author benor
 *
 */
public class Wallet {
	
	private int walletID;
	private String profileName;
	private String walletName;
	private int funds;
	
	
	
	

	/**
	 * 
	 */
	public Wallet() {
		super();
	}
	/**
	 * @param walletID
	 * @param profileName
	 * @param walletName
	 * @param funds
	 */
	public Wallet(int walletID, String profileName, String walletName, int funds) {
		super();
		this.walletID = walletID;
		this.profileName = profileName;
		this.walletName = walletName;
		this.funds = funds;
	}
	/**
	 * @param walletID
	 * @param walletName
	 * @param funds
	 */
	public Wallet(int walletID, String walletName, int funds) {
		super();
		this.walletID = walletID;
		this.walletName = walletName;
		this.funds = funds;
	}
	/**
	 * @param profileName
	 * @param walletName
	 * @param funds
	 */
	public Wallet(String profileName, String walletName, int funds) {
		super();
		this.profileName = profileName;
		this.walletName = walletName;
		this.funds = funds;
	}
	/**
	 * @param profileName
	 * @param walletName
	 */
	public Wallet(String profileName, String walletName) {
		super();
		this.profileName = profileName;
		this.walletName = walletName;
	}
	

	/**
	 * @param walletName
	 * @param funds
	 */
	public Wallet(String walletName, int funds) {
		super();
		this.walletName = walletName;
		this.funds = funds;
	}
	public int getWalletID() {
		return walletID;
	}
	public void setWalletID(int walletID) {
		this.walletID = walletID;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getWalletName() {
		return walletName;
	}
	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}
	public int getFunds() {
		return funds;
	}
	public void setFunds(int funds) {
		this.funds = funds;
	}
	@Override
	public String toString() {
		return "Wallet [walletID=" + walletID + ", profileName=" + profileName + ", walletName=" + walletName
				+ ", funds=" + funds + "]";
	}

	

	

	
	
	

}
