package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BuyProductdao {

	public int buy(String code,String qty) {
		int rowCount = 0;
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement psm = con.prepareStatement("update productclass set pqty=? where pcode=?");
			psm.setString(1,qty);
			psm.setString(2,code);
			
			rowCount = psm.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
