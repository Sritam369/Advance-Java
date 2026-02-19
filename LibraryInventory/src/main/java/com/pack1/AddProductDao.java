package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDao {
	Connection con = DBConnect.getCon();
	   public int insertProd(ProductBean p) {
		   int rowCount=0;
		   try {
		     PreparedStatement psm3 = con.prepareStatement("insert into productmvc values (?,?,?,?)");
		     psm3.setString(1, p.getCode());
		     psm3.setString(2, p.getName());
		     psm3.setString(3, p.getPrice());
		     psm3.setString(4, p.getStock());
		     
		     rowCount = psm3.executeUpdate();
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   return rowCount;
	   }
}
