package com.ben.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ben.model.Customer;
import com.ben.model.Profile;
import com.ben.util.ConnectionFactory;
import com.ben.util.ResourceCloser;

public class ProfileRepositoryImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileRepositoryImpl.class);
	
//	public ArrayList<Profile> saveProfiles(Customer customer) {
//
//		ArrayList<Profile> profiles = new ArrayList<Profile>();
//
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet set = null;
//		int customerId = customer.getCustomerID();
//
//		final String SQL = "select * from profiles_table where profile_to_customers_id = " + customerId;
//
//		try {
//			conn = ConnectionFactory.getConnection();
//
//			stmt = conn.createStatement();
//			set = stmt.executeQuery(SQL);
//
//			while (set.next()) {
//				profiles.add(new Profile(set.getInt(1), set.getString(3)));
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			ResourceCloser.closeConnection(conn);
//			ResourceCloser.closeResultSet(set);
//			ResourceCloser.closeStatement(stmt);
//		}
//
//		return profiles;
//
//	}
//	
//	public ArrayList<Profile> save() {
//
//		ArrayList<Profile> customers = new ArrayList<Profile>();
//
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet set = null;
//
//		final String SQL = "select * from customers_table";
//
//		try {
//			conn = ConnectionFactory.getConnection();
//
//			stmt = conn.createStatement();
//			set = stmt.executeQuery(SQL);
//
//			while (set.next()) {
////				customers.add(new Customer(set.getInt(1), set.getString(2), set.getString(3)));
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			ResourceCloser.closeConnection(conn);
//			ResourceCloser.closeResultSet(set);
//			ResourceCloser.closeStatement(stmt);
//		}
//
//		return customers;
//	}
	
	public void showAccountsOfCustomer() {
		
	}
	
	public void createProfile(Profile profile, Customer customer) {

		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "insert into profiles_table (profile_to_customers_id, profile_username, profile_isMainProfile) values(?, ?, ?)";
		logger.info("sql query, insert into profiles_table (profile_to_customers_id, profile_username, profile_isMainProfile) values(?, ?, ?)");

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, customer.getCustomerID());
			stmt.setString(2, profile.getProfileName());
			stmt.setBoolean(3, profile.isMainProfile());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}

}
