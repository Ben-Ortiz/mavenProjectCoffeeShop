package com.ben.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ben.model.Coffee;
import com.ben.model.Customer;
import com.ben.util.ConnectionFactory;
import com.ben.util.ResourceCloser;

public class CoffeeRepositoryImpl {
	private static final Logger logger = LoggerFactory.getLogger(CoffeeRepositoryImpl.class);

	
	public ArrayList<Coffee> saveCoffee() {

		ArrayList<Coffee> coffeeList = new ArrayList<Coffee>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;

		final String SQL = "select * from coffees_table";
		logger.info("sql query, select * from coffees_table");

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				coffeeList.add(new Coffee(set.getString(1), set.getInt(2)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}

		return coffeeList;
	}
}
