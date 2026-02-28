package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerRegisterDao {

	public int register(CustomerBean cb) {
		int rowCount = 0;
		try {

		Connection con = DBConnect.getCon();
		PreparedStatement psm = con.prepareStatement("insert into customerclass values(?,?,?,?,?,?,?)");
		psm.setString(1, cb.getUname());
		psm.setString(2, cb.getPass());
		psm.setString(3, cb.getFname());
		psm.setString(4, cb.getLname());
		psm.setString(5, cb.getAddr());
		psm.setString(6, cb.getMail());
		psm.setString(7, cb.getMob());
		
		 rowCount = psm.executeUpdate();
		
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
