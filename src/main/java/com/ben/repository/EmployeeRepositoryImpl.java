package com.ben.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ben.model.Customer;
import com.ben.model.Employee;
import com.ben.model.Profile;
import com.ben.util.ConnectionFactory;
import com.ben.util.ResourceCloser;

public class EmployeeRepositoryImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);
	
	public ArrayList<Employee> save() {

		ArrayList<Employee> employees = new ArrayList<Employee>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;

		final String SQL = "select * from employees_table";
		logger.info("sql query, select * from employees_table");

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				employees.add(new Employee(set.getString(2), set.getString(3), set.getBoolean(4)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}

		return employees;
	}

}
