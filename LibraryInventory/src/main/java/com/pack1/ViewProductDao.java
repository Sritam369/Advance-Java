package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewProductDao {
	Connection con = DBConnect.getCon();
	ArrayList<ProductBean> list = new ArrayList<>();
	   public ArrayList<ProductBean> viewBook(ProductBean b) {
		   int rowCount=0;
		   try {
		     PreparedStatement psm6 = con.prepareStatement("select * from productmvc");
	
		     ResultSet rs = psm6.executeQuery();
		     while(rs.next()) {
		    	 ProductBean b2 = new ProductBean();
		    	 b2.setCode(rs.getString(1));
		    	 b2.setName(rs.getString(2));
		    	 b2.setPrice(rs.getString(3));
		    	 b2.setStock(rs.getString(4));
		    	 
		    	 list.add(b2);	    	 
		     }
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   return list;
	   }
}
