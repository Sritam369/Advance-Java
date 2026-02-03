package com.pack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcPro12 {
	 String driver = "oracle.jdbc.OracleDriver";
	 String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	 String uName="sritam";
	 String pwd = "wolf";
	 String query1 = "insert into mydatabase values(?,?)";
	 String query2 = "select PIC_DATA from mydatabase where id=?";
	 
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
	 
	 void m1() {
		 Connection con = connect();
		 try(con){
			 PreparedStatement psm1 = con.prepareStatement(query1);
			 psm1.setString(1, "101");
			 FileInputStream fis = new FileInputStream("\\D:\\NEW\\PIC.PNG");
			 psm1.setBlob(2, fis);
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
	
	 void m2() {
		 Connection con = connect();
		 try(con){
			 PreparedStatement psm2 = con.prepareStatement(query2);
			 psm2.setString(1, "101");
			 ResultSet rs = psm2.executeQuery();
			 if(rs.next()) {
				 Blob b = rs.getBlob(1);
				 byte arr[] = b.getBytes(1, (int) b.length());
				 FileOutputStream fos = new FileOutputStream("\\D:\\NEW\\PIC2.PNG");
				 fos.write(arr);
				 IO.println("Image retrieved");
			 }
			 else {
				 IO.println("Image not retrieved");
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	
  void main() {
	  JdbcPro12 obj = new JdbcPro12();
	  //obj.m1();
	  obj.m2();
  }
}
