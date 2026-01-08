package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcPro1 {
	String driver="oracle.jdbc.OracleDriver";
	String dbUrl="jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname="sritam";
	String dbPwd="wolf";
   void connect() {
	   IO.println("connecting to the database");	   
	   try {
		   Class.forName(driver);
		   Connection con = DriverManager.getConnection(dbUrl,dbUname,dbPwd);
		   IO.println ("connection created");
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   void main() {
	   JdbcPro1 obj = new JdbcPro1();
	   obj.connect();
   }
}
