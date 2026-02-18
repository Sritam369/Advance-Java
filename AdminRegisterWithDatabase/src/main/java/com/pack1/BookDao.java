package com.pack1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class BookDao {
   Connection con = AdminCon.getCon();
   public int insertBook(Books b) {
	   int rowCount=0;
	   try {
	     PreparedStatement psm3 = con.prepareStatement("insert into book values (?,?,?,?,?)");
	     psm3.setString(1, b.getId());
	     psm3.setString(2, b.getBname());
	     psm3.setString(3, b.getAname());
	     psm3.setDouble(4, b.getPrice());
	     psm3.setInt(5, b.getQty());
	     rowCount = psm3.executeUpdate();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return rowCount;
   }
}
