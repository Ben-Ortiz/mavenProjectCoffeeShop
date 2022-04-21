package com.ben.model;

public class Profile {
	
	private int profileID;
	private String profileName;
	private boolean isMainProfile;
	


	
	

	/**
	 * 
	 */
	public Profile() {
		super();
	}



	/**
	 * @param profileID
	 * @param profileName
	 * @param isMainProfile
	 */
	public Profile(int profileID, String profileName, boolean isMainProfile) {
		super();
		this.profileID = profileID;
		this.profileName = profileName;
		this.isMainProfile = isMainProfile;
	}



	/**
	 * @param profileID
	 * @param profileName
	 */
	public Profile(int profileID, String profileName) {
		super();
		this.profileID = profileID;
		this.profileName = profileName;
	}



	public int getProfileID() {
		return profileID;
	}



	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}



	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	



	public boolean isMainProfile() {
		return isMainProfile;
	}



	public void setMainProfile(boolean isMainProfile) {
		this.isMainProfile = isMainProfile;
	}



	@Override
	public String toString() {
		return "Profile [profileID=" + profileID + ", profileName=" + profileName + ", isMainProfile=" + isMainProfile
				+ "]";
	}



	
	
	

}
