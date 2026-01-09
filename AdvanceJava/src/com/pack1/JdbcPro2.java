package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcPro2 {
   String driver = "oracle.jdbc.OracleDriver";
   String dbUrl= "jdbc:oracle:thin:@localhost:1521:orcl";
   String dbUname="sritam";
   String dbPwd="wolf";
   String query="select * from employee";
   
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
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   void main() {
	   new JdbcPro2().getEmployeeDetails();
   }
}

