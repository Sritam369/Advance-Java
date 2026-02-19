package com.pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminRegisterDao {
  Connection con =  DBConnect.getCon();
  public int insertData(AdminBean ab) {
	  int rowCount=0;
  try {
	  PreparedStatement psm1 = con.prepareStatement("insert into admin values (?,?,?,?,?,?)");
	  psm1.setString(1,ab.getName());
	  psm1.setString(2,ab.getPass());
	  psm1.setString(3,ab.getFname());
	  psm1.setString(4,ab.getLname());
	  psm1.setString(5,ab.getMail());
	  psm1.setString(6,ab.getPhone());
	  rowCount =  psm1.executeUpdate();
  }
  catch(Exception e) {
	  e.printStackTrace();
  }
  return rowCount;
  }
}
