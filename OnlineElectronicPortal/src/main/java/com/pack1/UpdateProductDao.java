package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDao {

	public int updateProd(ProductBean pb) {
		int rowCount=0;
		try{
			Connection con = DBConnect.getCon();
			PreparedStatement psm = con.prepareStatement("update productclass set pprice=? , pqty=? where pcode=? ");
			psm.setString(1, pb.getPrice());
			psm.setString(2, pb.getQty());
			psm.setString(3, pb.getCode());
			
			rowCount = psm.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
