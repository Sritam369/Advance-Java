package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBookDao {
  Connection con = AdminCon.getCon();
  public int deleteBook(Books b) {
	  int rowCount=0;
	  try {
		  PreparedStatement psm4 = con.prepareStatement("delete from book where bookid=?");
		  psm4.setString(1,b.getId());
		  rowCount = psm4.executeUpdate();
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  return rowCount;
  }
}
