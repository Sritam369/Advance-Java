package com.pack1;

import java.io.Serializable;

public class EmpBean implements Serializable {
  private String id;
  private String firat_name;
  private String last_name;
  private int sal;
  private String address;
  
  public EmpBean() {
	  
  }
  
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFirat_name() {
	return firat_name;
}
public void setFirat_name(String firat_name) {
	this.firat_name = firat_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public int getSal() {
	return sal;
}
public void setSal(int sal) {
	this.sal = sal;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
  
}
