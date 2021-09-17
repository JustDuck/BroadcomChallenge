package com.BROADCOM.challengTwo;

//reference https://www.tutorialspoint.com/how-to-retrieve-the-contents-of-a-resultset-from-last-to-first-in-jdbc
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class dispayResultSet {
	public static void main(String args[]) throws Exception {

		String url = "jdbc:mysql://localhost:3306/broadcom";
		System.out.println("Url is: " + url);
		String username = "root";
		String password = "";

		// Registering the Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Getting the connection

		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection established......");
		System.out.println("\n");
		// Creating a Statement object
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		// Statement stmt=con.createStatement();// Keep

		// Retrieving the data
		ResultSet rs = stmt.executeQuery("select * from customers");

		// ResultSet rsView = stmt.executeQuery("SELECT * FROM `my user view`");

		String view = "SELECT * FROM `my user view`";

		// do not put the view here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		System.out.println("Contents of the table are: ");
		System.out.println("\n");

		// Place here

		// Statement stmtView = con.createStatement();
		// rsView = stmtView.executeQuery("SELECT * FROM `my user view`");
		/*
		 * while (rsView.next()) { String lastName = rsView.getString("NAME");
		 * System.out.println(lastName + "\n"); }
		 */

		// rsView.close();// close resultset
		// stmtView.close();// close statement
		// con.close();// close connection
		// rs.afterLast();

		while (rs.next()) {// use rs.previous() to move backward

			int empNum = rs.getInt("ID");// ID

			int salary = rs.getInt("SALARY");
			System.out.print("ID:" + empNum + ", ");

			System.out.print("Name: " + rs.getString("NAME") + ", ");
			System.out.print("City: " + rs.getString("ADDRESS1") + ", ");
			System.out.print("State: " + rs.getString("ADDRESS2"));
			salary = rs.getInt("SALARY");
			System.out.print(" SALARY: " + salary);
			System.out.println("\n");

		} // end of while
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		System.out.println("The number of columns in this table are " + columnsNumber);
		rs.last();
		System.out.println("Table contains " + rs.getRow() + " rows");
		System.out.println("Count is the same as row count " + rs.getRow() + " count");

		rs = stmt.executeQuery("SELECT * FROM `my user view`");
		System.out.println("View is shown: " + view);

		// I was able to continue here

		System.out.println("This is the view created ");
		System.out.println("\n");

		System.out.println("NAME " + "AGE ");
		System.out.println("\n");

		while (rs.next()) {
			String Name = rs.getString("NAME");
			// System.out.println(Name + "");
			int yourage = rs.getInt("age");
			// System.out.println(yourage + "");
			// or all together
			System.out.println(Name + " " + yourage + " ");
			// System.out.println("");
		} // end of while
		System.out.println("\n");
		rs = stmt.executeQuery("SELECT NAME,age FROM CUSTOMERS WHERE age> 0 order by age");
		// int age = rs.getInt("AGE")
		System.out.println("this is the conditional query");
		System.out.println("\n");
		while (rs.next()) {
			String Name = rs.getString("NAME");
			// System.out.println("NAME "+Name);
			int yourage = rs.getInt("age");
			// System.out.print(" age: " + yourage);
			System.out.println(Name + " " + yourage + " ");
			// System.out.println("");
		} // end of while

	}// end of main method

} // end of class
