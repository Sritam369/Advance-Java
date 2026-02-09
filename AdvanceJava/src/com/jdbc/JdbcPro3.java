package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro3 {
  String driver = "oracle.jdbc.OracleDriver";
  String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
  String dbUserName="sritam";
  String dbPwd="wolf";
  
  Connection connect() {
	  Connection con = null;
	  try {
		  Class.forName(driver);
		  con=DriverManager.getConnection(dbUrl, dbUserName, dbPwd);		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  return con;
  }
  
  void addDetails() {
	  try {
	  Connection con = connect();
	  Statement stm = con.createStatement();
	  String bookId = IO.readln("enter bookid");
	  String bookName = IO.readln("enter book name");
	  String author = IO.readln("enter author name");
	  String genre = IO.readln("enter genre of the book");
	  double price = Double.parseDouble(IO.readln("enter book cost"));
	  int rowCount = stm.executeUpdate("insert into LIBRARY values ('"+bookId+"' , '"+bookName+"' , '"+author+"' , '"+genre+"' , "+price+")");
	  if(rowCount==0) {
		  IO.println("no row added");
	  }
	  else {
		  IO.println(rowCount+"row added successfully");
	  }
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }	  
  }
  
  void deleteDetails() {
	   try {
		   Connection con=connect();
		   Statement stm = con.createStatement();
		   String bookId = IO.readln("enter book id to be deleted");
		   int rowCount=stm.executeUpdate("delete from library where bookid="+bookId+"");
		   if(rowCount==0) {
			   IO.println("there is no data with given empid");
		   }
		   else {
			   IO.println("data with given empid deleted successfully ");
		   }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
  }
  
  void displayDetails() {
	  try {
		   Connection con=connect();
		   Statement stm = con.createStatement();
		   ResultSet rs = stm.executeQuery("select * from library");
		   while(rs.next()) {
				 IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDouble(5));
			   }
	  }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
  }
  void displayParticularBookDetails() {
	  try {
		   Connection con=connect();
		   Statement stm = con.createStatement();
		   String bookId = IO.readln("enter book id to be displayed");
		   ResultSet rs = stm.executeQuery("select * from library where bookid="+bookId+"");
		   while(rs.next()) {
				 IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getDouble(5));
			   }
	  }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
  }
  
  void main() {
	  JdbcPro3 jp = new JdbcPro3();
	  while(true) {
	  IO.println("Library menu");
	  IO.println("1. add books");
	  IO.println("2. delete books");
	  IO.println("3. retrieve particular book");
	  IO.println("4. display all books");
	  IO.println("5. exit");
	  int choice = Integer.parseInt(IO.readln("enter your choice"));
	  if(choice==1) {
		  jp.addDetails();
	  }
	  else if(choice==2) {
		  jp.deleteDetails();
	  }
	  else if(choice==3) {
		  jp.displayParticularBookDetails();
	  }
	  else if(choice==4) {
		  jp.displayDetails();
	  }
	  else if(choice==5) {
		  System.exit(0);
	  }
	  else {
		  IO.println("invalid choice");
	  }
	  }  
  }
}
