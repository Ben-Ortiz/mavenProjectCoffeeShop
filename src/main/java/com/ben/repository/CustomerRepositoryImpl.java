package com.ben.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ben.model.Customer;
import com.ben.model.Profile;
import com.ben.util.ConnectionFactory;
import com.ben.util.ResourceCloser;

public class CustomerRepositoryImpl implements CustomerRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryImpl.class);
	
	
	public void modifyCustomer(int customerToModifyID, String newName, String newPassword) {
		Connection conn = null;
		PreparedStatement stmt = null;

//		final String SQL = "update accounts_table set account_funds = account_funds - ? where account_username = ? ";
		final String SQL = "update customers_table set customer_username = ?, customer_password = ? where customer_id = ?";
		logger.info("sql query, update customers_table set customer_username = ?, customer_password = ? where customer_id = ?");
		

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, newName);
			stmt.setString(2, newPassword);
			stmt.setInt(3, customerToModifyID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}

	public ArrayList<Profile> showProfiles(Customer customer) {

		ArrayList<Profile> profiles = new ArrayList<Profile>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		int customerId = customer.getCustomerID();

		final String SQL = "select * from profiles_table where profile_to_customers_id = " + customerId;
		logger.info("sql query, select * from profiles_table where profile_to_customers_id = customerID");

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				profiles.add(new Profile(set.getInt(1), set.getString(3), set.getBoolean(4)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}

		return profiles;

	}

	@Override
	public void create(Customer customer) {

		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "insert into customers_table (customer_username, customer_password) values(?, ?)";
		logger.info("sql query, insert into customers_table (customer_username, customer_password) values(?, ?)");
		

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, customer.getCustomerName());
			stmt.setString(2, customer.getCustomerPassword());
//			stmt.setBoolean(3, customer.isMainUser());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}

	}

	@Override
	public ArrayList<Customer> save() {

		ArrayList<Customer> customers = new ArrayList<Customer>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;

		final String SQL = "select * from customers_table";
		logger.info("sql query, select * from customers_table");
		

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				customers.add(new Customer(set.getInt(1), set.getString(2), set.getString(3)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}

		return customers;
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void login(Customer customer) {
		// TODO Auto-generated method stub

	}

}
