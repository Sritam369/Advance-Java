package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateBookDao {
	Connection con = AdminCon.getCon();
	  public int updateBook(Books b) {
		  int rowCount=0;
		  try {
			  PreparedStatement psm5 = con.prepareStatement("update book set  bookname=? , authorname=? , bookprice=? where bookid=?");
			  psm5.setString(1, b.getBname());
			  psm5.setString(2, b.getAname());
			  psm5.setDouble(3, b.getPrice());
			  psm5.setString(4, b.getId());
			  rowCount = psm5.executeUpdate();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return rowCount;
	  }
}
