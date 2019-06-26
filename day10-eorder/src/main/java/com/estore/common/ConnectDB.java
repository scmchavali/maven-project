package com.estore.common;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {
	private Connection connection =null;
	public Connection getConnection(){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
		}catch(Exception e){
			
			System.out.println("unable to connect to database check DB");
			
		}
		return connection;
	}

	/**
	 * @param args
	 * @throws SQLException 
	 */
	

}
