package com.sri.lab_questions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class StudentProcedure {
	String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uName = "sritam";
	String pwd = "wolf";
	
	void m1() {
		try {
		Connection con = DriverManager.getConnection(url,uName,pwd);
		CallableStatement cs = con.prepareCall("{call insertStudent(?,?,?,?,?,?,?,?,?)}");
		cs.setString(1,"101");
		cs.setInt(2, 1);
		cs.setString(3, "sritam");
		cs.setString(4, "mechanical");
		cs.setString(5, "anadeula105");
		cs.setString(6, "balasore");
		cs.setInt(7, 756083);
		cs.setString(8, "chksri@gmail.com");
		cs.setLong(9, 8658958889l);
		cs.execute();
		IO.println("Data inserted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		void m2() {
		try {
		Connection con = DriverManager.getConnection(url,uName,pwd);
		CallableStatement cs2 = con.prepareCall("{call studentRetrieval(?,?,?,?,?,?,?,?,?)}");
		cs2.setString(1,"101");
		
		cs2.registerOutParameter(2, Types.NUMERIC);
		cs2.registerOutParameter(3, Types.VARCHAR);
		cs2.registerOutParameter(4, Types.VARCHAR);
		cs2.registerOutParameter(5, Types.VARCHAR);
		cs2.registerOutParameter(6, Types.VARCHAR);
		cs2.registerOutParameter(7, Types.NUMERIC);
		cs2.registerOutParameter(8, Types.VARCHAR);
		cs2.registerOutParameter(9, Types.NUMERIC);
		
		cs2.execute();
		
		IO.println("Student roll: "+cs2.getInt(2));
		IO.println("Student name: "+cs2.getString(3));
		IO.println("Student branch: "+cs2.getString(4));
		IO.println("Student house number: "+cs2.getString(5));
		IO.println("Student city: "+cs2.getString(6));
		IO.println("Student pincode: "+cs2.getInt(7));
		IO.println("Student mail id: "+cs2.getString(8));
		IO.println("Student phone number: "+cs2.getLong(9));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    void main() {
    	StudentProcedure sp = new StudentProcedure();
    //	sp.m1();
    	sp.m2();
    }
}
