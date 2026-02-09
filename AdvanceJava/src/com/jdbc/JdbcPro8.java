package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JdbcPro8 {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uName = "sritam";
	String pwd = "wolf";
	
	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, uName, pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	void meth1() {
		IO.println("Implementing CallableStatement");
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,uName,pwd);
			CallableStatement cst = con.prepareCall("{call InsertData(?,?,?,?,?)}");
			
			String id = IO.readln("Enter your id");
			String name = IO.readln("Enter your name");
			String desg = IO.readln("Enter your designation");
			int bsal = Integer.parseInt(IO.readln("Enter your basic salary"));
			
			float tsal = bsal+(0.35f*bsal)+(0.15f*bsal);
			
			cst.setString(1, id);
			cst.setString(2, name);
			cst.setString(3, desg);
			cst.setInt(4, bsal);
			cst.setFloat(5, tsal);
			
			cst.execute();
			
			IO.println("Data inserted");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void meth2() {
		IO.println("Implementing CallableStatement to retrieve data");
		Connection con = connect();
		try(con) {
		CallableStatement cst = con.prepareCall("{call RetrieveData(?,?,?,?,?)}");
		
		/* Procedure : SQL>  CREATE OR REPLACE PROCEDURE RetrieveData(EID VARCHAR2 , ENAME OUT VARCHAR2, EDESG OUT VARCHAR2, EBSAL OUT NUMBER, ETSAL OUT NUMBER) IS BEGIN
		  2  SELECT EMPNAME,EMPDESG INTO ENAME,EDESG FROM EMPDATA WHERE EMPID=EID;
		  3  SELECT EMPBSAL,EMPTSAL INTO EBSAL,ETSAL FROM EMPSAL WHERE EMPID=EID;
		  4  END;
		  5  /
		  */
		
		  String eid = IO.readln("Enter employee id");
		  cst.setString(1, eid);
		  
		  cst.registerOutParameter(2, Types.VARCHAR);
		  cst.registerOutParameter(3, Types.VARCHAR);
		  cst.registerOutParameter(4, Types.NUMERIC);
		  cst.registerOutParameter(5, Types.NUMERIC);
		  
		  cst.execute();
		  
		  IO.println("====== Employee Details ======");
		  IO.println("Employee id: "+eid);
		  IO.println("Employee name: "+cst.getString(2));
		  IO.println("Employee designation: "+cst.getString(3));
		  IO.println("Employee basic sal: "+cst.getInt(4));
		  IO.println("Employee total sal: "+cst.getInt(5));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void meth3() {
		IO.println("Implementing CallableStatement to retrieve data through function");
		Connection con = connect();
		try(con){
			CallableStatement cst = con.prepareCall("{call ?:=RetriveTsal(?)}");
			
			/*Function: SQL> CREATE OR REPLACE FUNCTION RetriveTsal(EID VARCHAR2) RETURN NUMBER AS ETSAL NUMBER;
			  2  BEGIN
			  3  SELECT EMPTSAL INTO ETSAL FROM EMPSAL WHERE EMPID=EID;
			  4  RETURN ETSAL;
			  5  END;
			  6  /
			  */
			
			String id = IO.readln("Enter employee id");
			cst.setString(2, id);
			cst.registerOutParameter(1, Types.NUMERIC);
			cst.execute();
			
			IO.println("===== Employee Details =====");
			IO.println("Employee id: "+id);
			IO.println("Employee total salary: "+cst.getInt(1));
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void main() {
		JdbcPro8 obj = new JdbcPro8();
		//obj.meth1();
		//obj.meth2();
		obj.meth3();
	}
}
