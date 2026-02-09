package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {
  String driver,url,uName,pwd;
  Vector<Connection> v = new Vector<>();
  public ConnectionPool(String driver, String url, String uName, String pwd) {
	super();
	this.driver = driver;
	this.url = url;
	this.uName = uName;
	this.pwd = pwd;
  }
  
  public void con_Initialization() {
	  IO.println("Connection pool is empty");
	  IO.println("There are "+v.size()+" connection objects");
	  while(v.size()<5) {
		  try {
			  Class.forName(driver);
			  Connection con = DriverManager.getConnection(url, uName,pwd);
			  v.add(con);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  for(Object o:v) {
		  IO.println(o);
	  }
	  IO.println("There are "+v.size()+" connection objects");
  }
  
  public Connection con_Acquistion() {
	  Connection con = v.get(0);
	  v.remove(0);
	  return con;
  }
  
  public void con_Return(Connection con) {
	  IO.println("Adding the connection object to the ConnectionPool");
	  v.add(con);
	  IO.println("There are "+v.size()+" connection objects");
	  for(Object o:v) {
		  IO.println(o);
	  }
	  
  }
}
