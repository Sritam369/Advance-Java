package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDao {

	public AdminBean checkAdminLogin(String uname,String pwd) {
		AdminBean ab =null;
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement psm = con.prepareStatement("select * from adminclass where uname=? and pword=?");
			psm.setString(1, uname);
			psm.setString(2, pwd);
			ResultSet rs = psm.executeQuery();
			if(rs.next()) {
				ab = new AdminBean();
				ab.setUname(rs.getString(1));
				ab.setPwd(rs.getString(2));
				ab.setFname(rs.getString(3));
				ab.setLname(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setMailid(rs.getString(6));
				ab.setPhone(rs.getString(7));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
