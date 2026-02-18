package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPro2 {
   String driver = "oracle.jdbc.OracleDriver";
   String dbUrl= "jdbc:oracle:thin:@localhost:1521:orcl";
   String dbUname="sritam";
   String dbPwd="wolf";
   Scanner sc = new Scanner(System.in);
   String query="select * from employee";
   String sqlQuery2="insert into employee values ('103','subrat','naik',45000,'hyd')";
   String sqlQuery3="delete from employee where eid='103'";
   String sqlQuery4="update employee set esal=35000 where EID='101'";
   
   Connection connect() {
	   Connection con=null;
	   try {
		   Class.forName(driver);
		   con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return con;
   }
   void getEmployeeDetails() {
	   try {
	   Class.forName(driver); // THIS WILL THROW CLASSNOTFOUNDEXCEPTION
	   Connection con = DriverManager.getConnection(dbUrl,dbUname,dbPwd); // IT WILL THROW SQLException
	   IO.println("connection created with database");
	   Statement stm = con.createStatement();
	   ResultSet rs = stm.executeQuery(query);
	   IO.println("----------Employee Details----------");
	   while(rs.next()) {
		 IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
//		 int sal = rs.getInt(4);
//		 if(sal>50000) {
//			 IO.println(sal);
//		 }
	   }
	   }
	   catch(ClassNotFoundException | SQLException e) {
		  if(e instanceof ClassNotFoundException) {
			  IO.println("can't find the class to load. check your driver");
		  }
		  else {
			  IO.println("something is wrong with your connection to database. check your url/user name/password");
		  }
	   }
   }
   
   void insertEmpData() {
	   try {
		  
		   Connection con = connect();
		   Statement stm = con.createStatement();
		   int rowCount = stm.executeUpdate(sqlQuery2);
		   if(rowCount==0) {
			   IO.println("Data not inserted");
		   }
		   else {
			   IO.println(rowCount+" row inserted successfully");
			   getEmployeeDetails();
		   }
	   }
	   catch(Exception e) {
		   if(e instanceof SQLIntegrityConstraintViolationException) {
			   IO.println("Duplicate EMPID'S are not allowed");
		   }
		   else {
		   e.printStackTrace();
		   }
	   }
   }
   		
   void deleteEmpData() {
	   try {
		   Connection con=connect();
		   Statement stm = con.createStatement();
		   int rowCount=stm.executeUpdate(sqlQuery3);
		   if(rowCount==0) {
			   IO.println("there is no data with given empid");
		   }
		   else {
			   IO.println("data with given empid deleted successfully ");
			   IO.println("Do you want to view the emp table data [y/n]");
			   char choice=sc.nextLine().charAt(0);
			   if(choice=='y'|| choice=='Y') {
				   getEmployeeDetails();
			   }
			   else {
				   System.exit(0);
			   }
		   }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   void updateEmpDetails() {
	
	   try {
	   Connection con=connect();
	 
	   Statement stm = con.createStatement();
	  
	   int rowCount=stm.executeUpdate(sqlQuery4);
	   
	   IO.println(rowCount);
	   if(rowCount==0) {
		   IO.println("No data found with given empid");
	   }
	   else {
		   IO.println("data updated successfully");
		   IO.println("Do you want to view the emp table data [y/n]");
		   char choice=sc.nextLine().charAt(0);
		   if(choice=='y'|| choice=='Y') {
			   getEmployeeDetails();
		   }
		   else {
			   IO.println("System exited successfully");
			   System.exit(0);
		   }
	   }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   
   void main() {
	   JdbcPro2 jdbc= new JdbcPro2();
	   //jdbc.insertEmpData();
	   //jdbc.deleteEmpData();
	   jdbc.updateEmpDetails();
   }
	   
   }


