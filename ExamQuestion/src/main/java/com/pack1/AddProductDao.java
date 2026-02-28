package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDao {

	public int add(ProductBean pb) {
		int rowCount=0;
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement psm = con.prepareStatement("insert into productexam values (?,?,?,?)");
			psm.setString(1, pb.getId());
			psm.setString(2, pb.getName());
			psm.setString(3, pb.getPrice());
			psm.setString(4, pb.getQty());
			rowCount = psm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
