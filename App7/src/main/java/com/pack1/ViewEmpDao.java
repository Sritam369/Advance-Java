package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewEmpDao {

	 ArrayList<EmpBean> al = new ArrayList<>();
	 
	 public ArrayList<EmpBean> retrieveEmpData(){
		 try {
		 Connection con = DBConnect.getCon();
		 PreparedStatement psm = con.prepareStatement("select * from employee");
		 ResultSet rs = psm.executeQuery();
		 
		 while(rs.next()) {
			 EmpBean eb = new EmpBean();
			 eb.setId(rs.getString(1));
			 eb.setFirat_name(rs.getString(2));
			 eb.setLast_name(rs.getString(3));
			 eb.setSal(rs.getInt(4));
			 eb.setAddress(rs.getString(5));
			 
			 al.add(eb);
		 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return al;
	 }
}
