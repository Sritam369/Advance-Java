package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Database {
	
	public int connect(ProdBean pb) {
		int rowCount=0;
		Connection con= ProdConn.getCon();
		try {
		PreparedStatement psm1 = con.prepareStatement("insert into product_jsp values(?,?,?,?,?)");
		psm1.setString(1,pb.getCode());
		psm1.setString(2, pb.getName());
		psm1.setString(3, pb.getComp());
		psm1.setString(4, pb.getPrice());
		psm1.setString(5, pb.getQty());
		 rowCount = psm1.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
  
}
