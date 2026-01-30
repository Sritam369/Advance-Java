package com.sri.lab_questions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScrollableResultSet {
	String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uName = "sritam";
	String pwd = "wolf";
	String query1 = "insert into productjdbc values(?,?,?,?)";
	String query2 = "select * from productjdbc";
	
	void meth1() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uName, pwd);
			PreparedStatement psm1 = con.prepareStatement(query1);
			
			String id = IO.readln("Enter product id");
			String name = IO.readln("Enter product name");
			int price = Integer.parseInt(IO.readln("Enter product price"));
			int qty = Integer.parseInt(IO.readln("Enter product quantity"));
			
			psm1.setString(1, id);
			psm1.setString(2, name);
			psm1.setInt(3, price);
			psm1.setInt(4, qty);
			
			int rowCount = psm1.executeUpdate();
			if(rowCount<=0) {
				IO.println("Data not inserted");
			}
			else {
				IO.println("Data inserted");
			}
		}
		catch(Exception e) {
		   e.printStackTrace();
		}
	}
	
	void meth2() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uName, pwd);
			PreparedStatement psm2 = con.prepareStatement(query2,1004,1007);
			ResultSet rs = psm2.executeQuery();
			
			rs.beforeFirst();
			while(rs.next()) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
			}
		}
		catch(Exception e) {
		   e.printStackTrace();
		}
	}
	
	void meth3() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uName, pwd);
			PreparedStatement psm3 = con.prepareStatement(query2,1004,1007);
			ResultSet rs = psm3.executeQuery();
			
			rs.afterLast();
			while(rs.previous()) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
			}
		}
		catch(Exception e) {
		   e.printStackTrace();
		}
	}
	
	void meth4() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uName, pwd);
			PreparedStatement psm4 = con.prepareStatement(query2,1004,1007);
			ResultSet rs = psm4.executeQuery();
			
			rs.absolute(3);
			IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
		}
		catch(Exception e) {
		   e.printStackTrace();
		}
	}
	
	void meth5() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uName, pwd);
			PreparedStatement psm5 = con.prepareStatement(query2,1004,1007);
			ResultSet rs = psm5.executeQuery();
			
			rs.absolute(-3);
			IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
		}
		catch(Exception e) {
		   e.printStackTrace();
		}
	}
	
	void meth6() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uName, pwd);
			PreparedStatement psm5 = con.prepareStatement(query2,1004,1007);
			ResultSet rs = psm5.executeQuery();
			
			rs.absolute(-4);
			while(rs.next()) {
			IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
			}
		}
		catch(Exception e) {
		   e.printStackTrace();
		}
	}
	
   void main() {
	   ScrollableResultSet sr = new ScrollableResultSet();
	   
	   while(true) {
	   IO.println("=== Product Menu ===");
	   IO.println("1. Insert productdetails");
	   IO.println("2. Retrieve productdetails in forward direction");
	   IO.println("3. Retrieve productdetails in backward direction");
	   IO.println("4. Retrieve 3rd record from top");
	   IO.println("5. Retrieve 3rd record from bottom");
	   IO.println("6. Retrieve last three record from product table");
	   
	   int choice = Integer.parseInt(IO.readln("Enter your choice"));
	   
	   switch(choice) {
	   case 1-> sr.meth1();
	   case 2-> sr.meth2();
	   case 3-> sr.meth3();
	   case 4-> sr.meth4();
	   case 5-> sr.meth5();
	   case 6-> sr.meth6(); 
	   default-> System.exit(0);
	   }
	   }
   }
}
