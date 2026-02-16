package com.pack1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewDatabase {
	ArrayList<ProdBean> list = new ArrayList<>();
  public ArrayList<ProdBean> view() {
	  Connection con = ProdConn.getCon();
	  try {
		  PreparedStatement psm2 = con.prepareStatement("select * from product_jsp");
		  ResultSet rs = psm2.executeQuery();
		  while(rs.next()) {
			  ProdBean pb = new ProdBean();
			  pb.setCode(rs.getString(1));
			  pb.setName(rs.getString(2));
			  pb.setComp(rs.getString(3));
			  pb.setPrice(rs.getString(4));
			  pb.setQty(rs.getString(5));
			  list.add(pb);
		  }
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  return list;
  }
}
