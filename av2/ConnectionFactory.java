package com.menezes.pob.av2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection createConnection() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/Clientela";
		String user = "root";
		String password = "";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
}
