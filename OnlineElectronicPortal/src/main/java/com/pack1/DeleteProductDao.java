package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDao {

	public int deleteProd(String pcode) {
		int rowCount=0;
		
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement psm = con.prepareStatement("delete from productclass where pcode=?");
			psm.setString(1, pcode);
			rowCount = psm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
