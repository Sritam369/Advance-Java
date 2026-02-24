package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDao {
   public int addProd(ProductBean pb) {
	   int rowCount=0;
	   try {
		   Connection con = DBConnect.getCon();
		   PreparedStatement psm = con.prepareStatement("insert into productclass values(?,?,?,?,?)");
		   psm.setString(1, pb.getCode());
		   psm.setString(2, pb.getName());
		   psm.setString(3, pb.getCompany());
		   psm.setString(4, pb.getPrice());
		   psm.setString(5, pb.getQty());
		   rowCount = psm.executeUpdate();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return rowCount;
   }
}
