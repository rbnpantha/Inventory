package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static String DbName = "inventory";
	private static String userName = "root";
	private static String password = "";

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DbName, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

}
