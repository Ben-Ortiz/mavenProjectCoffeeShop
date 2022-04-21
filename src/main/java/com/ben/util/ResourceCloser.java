package com.ben.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceCloser {
	
	private static final Logger logger = LoggerFactory.getLogger(ResourceCloser.class);
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
			logger.info("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void closeStatement(Statement stmt) {
		try {
			stmt.close();
			logger.info("statement closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void closeResultSet(ResultSet set) {
		try {
			set.close();
			logger.info("set closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
