package test0709;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQL {

	public static Connection getConnection() {
		Connection connect = null;
		try {
			// load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://192.168.56.126/Student", "julian", "admin123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connect;
	}

}
