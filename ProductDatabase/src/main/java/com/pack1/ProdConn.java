package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProdConn {
	static Connection con=null;
  static {

	  try {
		  Class.forName(Product.driver);
		   con=DriverManager.getConnection(Product.url, Product.uName, Product.pwd);
		   
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  public static Connection getCon() {
       return con;
  }
}
