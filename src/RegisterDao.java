package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;

public class RegisterDao {
	public String registerUser(RegisterBean registerBean) {
		String fullName = registerBean.getFullName();
		String email = registerBean.getEmail();
		String userName = registerBean.getUserName();
		String password = registerBean.getPassword();

		ResultSet rs = null;
		

		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		// am adding this stuff shari - its broadcom
		
		String url = "jdbc:mysql://localhost:3306/broadcom"; //database connection url string
		System.out.println("Url is ." + url);
		String uname = "root"; // database username
		String pass = ""; // database password

		try {


			Class.forName("com.mysql.jdbc.Driver");// load driver
			System.out.println("Found class for JDBC driver.");
			con = DriverManager.getConnection(url, uname, pass); // create connection
		
			System.out.println("Server connected!");
			con = DBConnection.createConnection();
			System.out.println("are we connected?" + con);
			String query = "insert into broadcom.user(SlNo,fullName,Email,userName,password) values (NULL,?,?,?,?)";
			//System.out.println("The query IS " + query);
			// rs = preparedStatement.execute("SELECT SlNo broaddom.user");
			//I cannot stad exlcdi
			// Insert user details into the table 'USER'
			
			//Making use of prepared statements here to insert bunch of data

			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, fullName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, password);

			con.prepareStatement(query);// heck yea shari
			
			System.out.println("The query is "+ query);


			int i = preparedStatement.executeUpdate();// execute query

			preparedStatement.close(); // close statement

			con.close(); // close connection

			if (i != 0) // Just to ensure data has been inserted into the database
						
				return "SUCCESS";
		}

		catch (SQLException ep) {
			ep.printStackTrace();
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: " + e.getMessage());
		}
		return "FAIL REGISTER"; // if invalid return string "FAIL REGISTER"
	}
}
