package com.ben.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ben.client.AppUI;
import com.ben.model.Customer;
import com.ben.model.Profile;
import com.ben.util.ConnectionFactory;
import com.ben.util.ResourceCloser;

public class AccountsRepositoryImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountsRepositoryImpl.class);
	
	public ArrayList<Profile> saveProfiles(int profileID) {

		ArrayList<Profile> profiles = new ArrayList<Profile>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;

		final String SQL = "select * from profile_table_accounts_table where profile_id = " + profileID;
		logger.info("sql query, select * from profile_table_accounts_table where profile_id = profileID");

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				profiles.add(new Profile(set.getInt(1), set.getString(3)));

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

}
