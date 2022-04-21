package com.ben.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ben.repository.ProfileRepositoryImpl;

public class ConnectionFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

	public static Connection getConnection() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					System.getenv("db_url"), 
					System.getenv("db_username"),
					System.getenv("db_password"));
			logger.info("connection to db successful");

		} catch (SQLException e1) {
			System.out.println("you messed up somewhere in the ConnectionFactory.java file");
			e1.printStackTrace();
		}

		return conn;

	}

}
