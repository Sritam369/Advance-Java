package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewBookDao {
	Connection con = AdminCon.getCon();
	ArrayList<Books> list = new ArrayList<>();
	   public ArrayList<Books> viewBook(Books b) {
		   int rowCount=0;
		   try {
		     PreparedStatement psm6 = con.prepareStatement("select * from book");
	
		     ResultSet rs = psm6.executeQuery();
		     while(rs.next()) {
		    	 Books b2 = new Books();
		    	 b2.setId(rs.getString(1));
		    	 b2.setBname(rs.getString(2));
		    	 b2.setAname(rs.getString(3));
		    	 b2.setPrice(rs.getDouble(4));
		    	 b2.setQty(rs.getInt(5));
		    	 list.add(b2);	    	 
		     }
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   return list;
	   }
}
