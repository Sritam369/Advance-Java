package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminLoginDao {
	ArrayList<AdminBean>list=new ArrayList<>();
	public ArrayList<AdminBean> view() {
		Connection con=DBConnect.getCon();
		try {
		PreparedStatement psm2 = con.prepareStatement("select name,password from admin");
		ResultSet rs = psm2.executeQuery();
		while(rs.next()) {
			AdminBean ab = new AdminBean();
			ab.setName(rs.getString(1));
			ab.setPass(rs.getString(2));
			list.add(ab);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
   
}
