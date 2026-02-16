package com.pack1;

import java.io.Serializable;

public class ProdBean implements Serializable {
  private String code;
  private String name;
  private String comp;
  private String price;
  private String qty;
  
  public ProdBean() {
	  
  }

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getComp() {
	return comp;
}

public void setComp(String comp) {
	this.comp = comp;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getQty() {
	return qty;
}

public void setQty(String qty) {
	this.qty = qty;
}
  
}
