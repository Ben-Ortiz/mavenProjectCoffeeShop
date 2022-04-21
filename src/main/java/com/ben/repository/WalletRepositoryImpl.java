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
import com.ben.model.Employee;
import com.ben.model.Profile;
import com.ben.model.Wallet;
import com.ben.util.ConnectionFactory;
import com.ben.util.ResourceCloser;

public class WalletRepositoryImpl {

	private static final Logger logger = LoggerFactory.getLogger(WalletRepositoryImpl.class);
	
	public void addWalletToCustomer(String newWallet, int customerID, int newAmount, String newPW) {

		Connection conn = null;
		PreparedStatement stmt = null;

//		final String SQL = "insert into profile_table_accounts_table values(?, ?);";
		final String SQL = "insert into accounts_table (account_to_customer_id, account_username, account_funds, account_password) values (?, ?, ?, ?);";
		
		logger.info("sql query, insert into profile_table_accounts_table values(?, ?);");

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, customerID);
			stmt.setString(2, newWallet);
			stmt.setInt(3, newAmount);
			stmt.setString(4, newPW);
//			stmt.setBoolean(3, customer.isMainUser());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}

	}

	public void removeWallet(Wallet wallet) {

		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "delete from accounts_table where account_username = ? ";
		logger.info("sql query, delete from accounts_table where account_username = ?");

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, wallet.getWalletName());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}

	public ArrayList<Wallet> saveAllWalletsOfCustomers() {

		ArrayList<Wallet> wallets = new ArrayList<Wallet>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;

		final String SQL = "select * from accounts_table";
		logger.info("sql query, select * from accounts_table");

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				wallets.add(new Wallet(set.getString(3), set.getInt(5)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}

		return wallets;
	}

	public ArrayList<Wallet> saveAllWalletsOfProfiles() {

		ArrayList<Wallet> wallets = new ArrayList<Wallet>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;

		final String SQL = "select * from profile_table_accounts_table";
		logger.info("sql query, select * from profile_table_accounts_table");

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				wallets.add(new Wallet(set.getString(1), set.getString(2)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}

		return wallets;
	}

	public void addWalletToProfile(String walletToUse, String profileToGiveAccess) {

		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "insert into profile_table_accounts_table values(?, ?);";
		logger.info("sql query, insert into profile_table_accounts_table values(?, ?);");

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, profileToGiveAccess);
			stmt.setString(2, walletToUse);
//			stmt.setBoolean(3, customer.isMainUser());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}

	}

	public void removeFundsAdmin(String accountName, int amountToAdd) {

		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "update accounts_table set account_funds = account_funds - ? where account_username = ? ";
		logger.info(
				"sql query, update accounts_table set account_funds = account_funds - ? where account_username = ? admin version");

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, amountToAdd);
			stmt.setString(2, accountName);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}

	public void addFundsAdmin(String accountName, int amountToAdd) {

		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "update accounts_table set account_funds = account_funds + ? where account_username = ? ";
		logger.info(
				"sql query, update accounts_table set account_funds = account_funds + ? where account_username = ?, admin version ");

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, amountToAdd);
			stmt.setString(2, accountName);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}

	public void removeFunds(String accountName, int amountToAdd, Customer customer) {

		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "update accounts_table set account_funds = account_funds - ? where account_username = ? ";
		logger.info(
				"sql query, update accounts_table set account_funds = account_funds - ? where account_username = ? ");

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, amountToAdd);
			stmt.setString(2, accountName);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}

	public void addFunds(String accountName, int amountToAdd, Customer customer) {

		Connection conn = null;
		PreparedStatement stmt = null;

		final String SQL = "update accounts_table set account_funds = account_funds + ? where account_username = ? ";
		logger.info(
				"sql query, update accounts_table set account_funds = account_funds + ? where account_username = ? ");

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, amountToAdd);
			stmt.setString(2, accountName);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
	}

	public ArrayList<Wallet> getAccountsOfCustomer(Customer customer) {

		ArrayList<Wallet> wallets = new ArrayList<Wallet>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;

		final String SQL = "select * from accounts_table where account_to_customer_id = " + "'"
				+ customer.getCustomerID() + "'";
		logger.info("sql query, select * from accounts_table where account_to_customer_id = customer.getCustomerID()");

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				wallets.add(new Wallet(set.getInt(1), set.getString(2), set.getString(3), set.getInt(5)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}

		return wallets;
	}

	public ArrayList<Wallet> saveWallets(String profileName) {

		ArrayList<Wallet> wallets = new ArrayList<Wallet>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;

		final String SQL = "select * from profile_table_accounts_table where profile_username = " + "'" + profileName
				+ "'";
		logger.info("sql query, select * from profile_table_accounts_table where profile_username = profileName");

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				wallets.add(new Wallet(set.getString(1), set.getString(2)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}

		return wallets;

	}

}
