package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro6 {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uname="sritam";
	String pwd = "wolf";
	
	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, uname, pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void m1() {
		Connection con=connect();
		try (con){
			Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery("select * from employee");
			
			while(rs.next()) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			IO.println();
			while(rs.previous()) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			IO.println();
			if(rs.last()) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(1));				
			}
			IO.println();
			if(rs.first()) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(1));				
			}
			IO.println();
			rs.afterLast();
			while(rs.previous()) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(1));
			}
			IO.println();
			rs.beforeFirst();
			while(rs.next()) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(1));
			}
			IO.println();
			if(rs.absolute(2)) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(1));
			}
			IO.println();
			if(rs.relative(2)) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(1));
			}
			IO.println();
			if(rs.absolute(-2)) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(1));
			}
			IO.println();
			if(rs.relative(-2)) {
				IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void m2() {
		Connection con=connect();
		try(con) {
			Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stm.executeQuery("select eid,efname,esal from employee");
			while(rs.next()) {
				String e_id=rs.getString(1);
				if(e_id.equals("102")) {
					rs.updateInt(3, 15000);
					rs.updateRow();
				}
			}
			IO.println("Data updated");
			rs.absolute(3);
			IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
 void main() {
	 JdbcPro6 obj=new JdbcPro6();
	 //obj.m1();
	 obj.m2();
 }
}
