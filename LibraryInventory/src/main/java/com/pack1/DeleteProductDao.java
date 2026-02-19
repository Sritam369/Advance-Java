package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDao {
	public int deleteProd(ProductBean p) {
		int rowCount=0;
		try {
		Connection con = DBConnect.getCon();
		PreparedStatement psm = con.prepareStatement("delete from productmvc where code=?");
		psm.setString(1, p.getCode());

		rowCount = psm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
