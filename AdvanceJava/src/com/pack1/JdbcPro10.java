package com.pack1;

import java.sql.Connection;

public class JdbcPro10 {
	String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uName = "sritam";
	String pwd = "wolf";
	
	void meth1() {
		ConnectionPool cp = new ConnectionPool(driver,url,uName,pwd);
		cp.con_Initialization();
		
		IO.println("===== User 1 =====");
		Connection con1 = cp.con_Acquistion();
		IO.println("User1 : "+con1);
		IO.println("===>"+cp.v.size());
		
		IO.println("===== User 2 =====");
		Connection con2 = cp.con_Acquistion();
		IO.println("User1 : "+con2);
		IO.println("===>"+cp.v.size());
		
		IO.println("===== User 3 =====");
		Connection con3 = cp.con_Acquistion();
		IO.println("User1 : "+con3);
		IO.println("===>"+cp.v.size());
		
		IO.println("====================");
		cp.con_Return(con1); //user 1
		cp.con_Return(con2); //user 2
		cp.con_Return(con3); //user 3
	}
	
	void main() {
		JdbcPro10 obj = new JdbcPro10();
		obj.meth1();
	}
}
