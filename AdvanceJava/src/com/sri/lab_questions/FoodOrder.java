package com.sri.lab_questions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class FoodOrder {
	String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uName = "sritam";
	String pwd = "wolf";
	String query = "select * from food";
	String query2 = "select price from food where food_id=?";
	String query3 = "insert into food_orders values(?,?,?,?)";
			
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
		try(con) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			IO.println("====== Food Menu =====");
			while(rs.next()) {
				IO.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));				
			}
						
			PreparedStatement psm1 = con.prepareStatement(query2);
			int id = Integer.parseInt(IO.readln("enter food id"));
			int qty = Integer.parseInt(IO.readln("enter food quantity"));
			psm1.setInt(1, id);
			ResultSet rs2 = psm1.executeQuery();
			int total=0;
			if(rs2.next()) {
			int price = rs2.getInt(1);		
			total = qty*price;
			IO.println("Total price : "+total);
			}
			
			PreparedStatement psm2 = con.prepareStatement(query3);
			psm2.setInt(1, 1);
			psm2.setInt(2, id);
			psm2.setInt(3, qty);
			psm2.setInt(4,total);
			int rc = psm2.executeUpdate();
			if(rc==0) {
				IO.println("Data not inserted");
			}
			else {
				IO.println("Data inserted");
			}
			
			PreparedStatement psm3 = con.prepareStatement("select * from food_orders");
			ResultSet rs3 = psm3.executeQuery();
			while(rs3.next()) {
				IO.println(rs3.getInt(1)+" "+rs3.getInt(2)+" "+rs3.getInt(3)+" "+rs3.getInt(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
  void main() {
	  FoodOrder obj = new FoodOrder();
	  obj.m1();
  }
}
