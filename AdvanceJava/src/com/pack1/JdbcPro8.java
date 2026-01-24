package com.pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcPro8 {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uName = "sritam";
	String pwd = "wolf";
	
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
	
	void main() {
		JdbcPro8 obj = new JdbcPro8();
		obj.meth1();
	}
}
