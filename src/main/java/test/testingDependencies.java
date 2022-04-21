package test;

import java.sql.Connection;

public class testingDependencies {
	
	public static void main(String[] args) {
		String uname = "postgres";
		String password = "postgres";
		String query = "select * from cupcake";
		String driver ="com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("jdbc driver not installed");
			e.printStackTrace();
		}
		
	}
	
	Connection con = null;
	
	

}
