package com.firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
	static	Connection  con=null;	
	public static Connection getConnection(){
		
		if(con==null){
		
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Daddymummy$1");
		
			}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		}
return con;	
	}
}
