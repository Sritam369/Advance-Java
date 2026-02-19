package com.pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class UpdateProductDao {
	public int updateProd(ProductBean p) {
		int rowCount=0;
		try {
		Connection con = DBConnect.getCon();
		PreparedStatement psm = con.prepareStatement("update productmvc set name=? , price=? , stock=? where code=?");
		psm.setString(1, p.getName());
		psm.setString(2, p.getPrice());
		psm.setString(3, p.getStock());
		psm.setString(4, p.getCode());
		rowCount = psm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
  
}
