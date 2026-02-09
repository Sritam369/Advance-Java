package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

public class JdbcPro14 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "sritam";
	String dbPwd = "wolf";
	
	Connection connect() {
		Connection con = null;
		try {
			IO.println("connecting");
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	void m1() {
		Connection con = connect();
		try(con){
			Statement stm = con.createStatement();
			int no_of_query = Integer.parseInt(IO.readln("How many queries do you want to execute"));
			for(int i=1;i<=no_of_query;i++) {
				stm.addBatch(IO.readln("Enter query"));
			}
			
			IO.println(no_of_query+" number of queries added to the batch");
			int rowCount[] = stm.executeBatch();
			IO.println("==="+Arrays.toString(rowCount));
			stm.clearBatch();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
void main() {
	JdbcPro14 j14=new JdbcPro14();
	j14.m1();
}
}