package com.pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class UpdateProductDao {
	public int updateProd(ProductBean p) {
		int rowCount=0;
		try {
		Connection con = DBConnect.getCon();
		PreparedStatement psm = con.prepareStatement("update productmvc set price=? , stock=? where code=?");
		
		psm.setString(1, p.getPrice());
		psm.setString(2, p.getStock());
		psm.setString(3, p.getCode());
		rowCount = psm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
  
}
