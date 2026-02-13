package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEmpDao {
	
  public int insertEmpData(EmpBean eb) {
	  int rowCount=0;
	  try {
		  
		  Connection con  = DBConnect.getCon();
		  PreparedStatement psm1 = con.prepareStatement("insert into employee values (?,?,?,?,?)");
		  psm1.setString(1, eb.getId());
		  psm1.setString(2, eb.getFirat_name());
		  psm1.setString(3, eb.getLast_name());
		  psm1.setInt(4, eb.getSal());
		  psm1.setString(5, eb.getAddress());
		  
		  rowCount = psm1.executeUpdate();
	  }
	  catch(Exception e) {
		  
		  e.printStackTrace();
	  }
	  return rowCount;
  }
}
