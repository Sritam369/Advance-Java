package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public class JdbcPro5 {

	 String driver = "oracle.jdbc.OracleDriver";
	 String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	 String uName="sritam";
	 String pwd = "wolf";
	 
	 Connection connect() {
		 Connection con = null;
		 try {
			 Class.forName(driver);
			 con = DriverManager.getConnection(url, uName, pwd);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return con;
	 }
	 
	 public void employeeRegistration() {
		 try {
		 Connection con = connect();
		 PreparedStatement psm1 = con.prepareStatement("insert into employee_reg values(?,?,?,?,?,?,?)");
		 PreparedStatement psm2 = con.prepareStatement("select * from employee_reg");
		 PreparedStatement psm3 = con.prepareStatement("select * from employee_reg where ename =? and pword=?");
		 PreparedStatement psm4 = con.prepareStatement("update employee_reg set addr=? where ename=? and pword=?");
		 PreparedStatement psm5 = con.prepareStatement("update employee_reg set phn=? where ename=?");
		 
		 while(true) {
			 IO.println("-----Employee Login-----");
			 IO.println("1. Add employee data");
			 IO.println("2. view employee data");
			 IO.println("3. retrieve employee data");
			 IO.println("4. update employee data");
			 IO.println("5. Exit");
			 
			 int choice = Integer.parseInt(IO.readln("enter your choice"));
			 if(choice==1) {
				 
				 String userName = IO.readln("enter user name");
				 String pwd = IO.readln("enter password");
				 String fname = IO.readln("enter first name");
				 String lname = IO.readln("enter last name");
				 String addr = IO.readln("enter address");
				 String mail = IO.readln("enter mail id");
				 long phn = Long.parseLong(IO.readln("enter phone number"));
				 
				 psm1.setString(1, userName);
				 psm1.setString(2, pwd);
				 psm1.setString(3, fname);
				 psm1.setString(4, lname);
				 psm1.setString(5, addr);
				 psm1.setString(6, mail);
				 psm1.setLong(7, phn);
				 
				 int rowCount = psm1.executeUpdate();
				 if(rowCount>0) {
					 IO.println("Data inserted successfully");
				 }
				 else {
					 IO.println("Data not inserted");
				 }
			 }
			 else if(choice==2) {
				 ResultSet rs = psm2.executeQuery();
				 while(rs.next()) {
					 IO.println(rs.getString(1)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
				 }
			 }
			 else if(choice==3) {
				 String name = IO.readln("enter username");
				 String pwd = IO.readln("enter password");			 
				 psm3.setString(1, name);
				 psm3.setString(2, pwd);
				 
				 ResultSet rs = psm3.executeQuery();
				 if(rs.next()) {
					 IO.println(rs.getString(1)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
				 }
				 else {
					 IO.println("User name / password not matched");
				 }
			 }
			 
			 else if(choice==4) {				 
				 String updateChoice = IO.readln("Do you want to change your address or phone number ? select [addr/phn]");
				 if(updateChoice.equalsIgnoreCase("addr")) {
					 String name = IO.readln("enter username");
					 String pwd = IO.readln("enter password");
					 String addr = IO.readln("enter new address");			 
					 psm4.setString(2, name);
					 psm4.setString(1, addr);
					 psm4.setString(3, pwd);
					 
					 int rowCount = psm4.executeUpdate();
					 if(rowCount>0) {
						 IO.println("Address updated successfully");
					 }
					 else {
						 IO.println("User name / password not matched");
					 }
				 }
				
				 else if(updateChoice.equalsIgnoreCase("phn")) {
					 String name = IO.readln("enter username");
					 String pwd = IO.readln("enter password");
					 Long phn = Long.parseLong(IO.readln("enter new phone number"));			 
					 psm5.setString(2, name);
					 psm5.setLong(1, phn);
					 psm5.setString(3, pwd);
					 
					 int rowCount = psm5.executeUpdate();
					 if(rowCount>0) {
						 IO.println("phone number updated successfully");
					 }
					 else {
						 IO.println("User name / password not matched");
					 }
			 }
				 else {
					 IO.println("Please insert value as addr/phn");
				 } 
			 }
			 else if(choice==5) {
				 IO.println("Thank you for visiting");
				 System.exit(0);
			 }
			 else {
				 IO.println("invalid choice");
			 }
		 }}
		 catch(Exception e) {
			 if(e instanceof SQLIntegrityConstraintViolationException) {
				 IO.println("Duplicate username not allowed");
			 }
			 if(e instanceof NumberFormatException ) {
				 IO.println("Please enter valid phone number");
			 }
			 else {
			 e.printStackTrace();
			 }
		 }
	 }
	 
	 void main() {
		 JdbcPro5 obj = new JdbcPro5();
		 obj.employeeRegistration();
	 }
}
