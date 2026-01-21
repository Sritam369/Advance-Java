package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public class JdbcPro4 {
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
 
 public void patientOperations() {
	 Connection con = connect();
	 try(con) {
	 PreparedStatement psm1 = con.prepareStatement("insert into patient values (?,?,?,?)");
	 PreparedStatement psm2 = con.prepareStatement("select * from patient");
	 PreparedStatement psm3 = con.prepareStatement("select * from patient where pid=?");
	 PreparedStatement psm4 = con.prepareStatement("update patient set age=? where pid=?");
	 PreparedStatement psm5 = con.prepareStatement("delete from patient where pid=?");
	 
	 while(true) {
		 IO.println("-----Patient Data-----");
		 IO.println("1. Add patient details");
		 IO.println("2. View all patient details");
		 IO.println("3. Retrieve patient details");
		 IO.println("4. Update patient details");
		 IO.println("5. Delete patient details");
		 IO.println("6. Thank you for visiting");
		 int choice = Integer.parseInt(IO.readln("enter your choice"));
		 if(choice==1) {
			String id = IO.readln("enter patient id");
			String name = IO.readln("enter patient name");
			int age = Integer.parseInt(IO.readln("enter patient age"));
			long contact = Long.parseLong(IO.readln("enter patient contact"));
			
			psm1.setString(1, id);
			psm1.setString(2, name);
			psm1.setInt(3, age);
			psm1.setLong(4, contact);
			int rowCount=psm1.executeUpdate();
			
			if(rowCount>0) {
				IO.println("Data added successfully");
			}
			else {
				throw new RuntimeException("Patient data not inserted");
			}
		 }
		 
		 else if(choice==2) {
			ResultSet rs= psm2.executeQuery();
			while(rs.next()) {
				IO.println(rs.getString(1) +" "+ rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4));
			}
		 }
		 
		 else if(choice==3) {
			 String id = IO.readln("enter patient id");
			
			 psm3.setString(1, id);
			 ResultSet rs = psm3.executeQuery();
			 if(rs.next()) {
					IO.println(rs.getString(1) +" "+ rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4));
				}
			 else {
				 IO.println("patient record with id "+id+" not found");
			 }
		 }
		 
		 else if(choice==4) {
			 String id = IO.readln("enter patient id");
			 int age = Integer.parseInt(IO.readln("enter age"));
			 psm4.setString(2, id);
			 psm4.setInt(1, age);
			 int rowCount=psm4.executeUpdate();
			 if(rowCount>0) {
				 IO.println("data updated successfully");
			 }
			 else {
				 IO.println("patient record with id "+id+" not found");
			 }
		 }
		 
		 else if(choice==5) {
			 String id = IO.readln("enter patient id");				
			 psm5.setString(1, id);
			 int rowCount = psm5.executeUpdate();
			 if(rowCount>0) {
				 IO.println("patient record deleted successfully");
			 }
			 else {
				 IO.println("patient record with id "+id+" not found");
			 }
		 }
		 
		 else if(choice==6) {
			 System.exit(0);
		 }
	 }
	 }
	 catch(Exception e) {
		 if(e instanceof SQLIntegrityConstraintViolationException ) {
			 IO.println("Duplicate values are not allowed for patient id");
		 }
		 else {
		 e.printStackTrace();
		 }
	 }
	 
 }
 
 void main() {
	 JdbcPro4 obj = new JdbcPro4();
	 obj.patientOperations();
 }
}
