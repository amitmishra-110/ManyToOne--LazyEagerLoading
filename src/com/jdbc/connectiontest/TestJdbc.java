package com.jdbc.connectiontest;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			String  jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
			String user="hbstudent";
			String pass="hbstudent";
			String pass1="amit"; //wrong password for false connection
			
		try
		{
			System.out.println("Connecting to database"+jdbcUrl);
			Connection myConn= DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection Succesfull!!!!");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

}
