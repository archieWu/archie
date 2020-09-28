package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQL {
	private static MySQL instance = null;
	MySQL() {}
	public static MySQL getInstance() {
		if(instance == null) {
			instance = new MySQL();
		}
		return instance;
	}
	
	public static Connection getConnection() {
		Connection connect = null;
		try {
			//load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/demo", "Archie", "x19970710");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connect;
	}

}