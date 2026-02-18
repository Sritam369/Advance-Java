package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdminCon {
  static Connection con=null;
  static {
  try {
	  Class.forName(Admin.driver);
	  con = DriverManager.getConnection(Admin.url, Admin.uName, Admin.pwd);
  }
  catch(Exception e) {
	  e.printStackTrace();
  }
  }
  public static Connection getCon() {
	  return con;
  }
}
