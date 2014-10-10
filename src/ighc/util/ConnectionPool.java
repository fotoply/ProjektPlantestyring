package ighc.util;

import java.sql.SQLException;

public class ConnectionPool {
	
	private static DatabaseConnection  databaseConnection;

	public static DatabaseConnection getDatabaseConnection() throws SQLException {
		if(databaseConnection == null) {
			databaseConnection = new DatabaseConnection(new Configuration());
		}
		return databaseConnection;
	}
	

}
