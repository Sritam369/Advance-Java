package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDao {

	public CustomerBean login(String name,String pwd) {
		CustomerBean cb = null;
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement psm = con.prepareStatement("select * from customerclass where uname=? and pword=?");
			psm.setString(1, name);
			psm.setString(2,pwd);
			
			ResultSet rs = psm.executeQuery();
			if(rs.next()) {
				cb = new CustomerBean();
				cb.setUname(rs.getString(1));
				cb.setPass(rs.getString(2));
				cb.setFname(rs.getString(3));
				cb.setLname(rs.getString(4));
				cb.setAddr(rs.getString(5));
				cb.setMail(rs.getString(6));
				cb.setMob(rs.getString(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return cb;
}
}