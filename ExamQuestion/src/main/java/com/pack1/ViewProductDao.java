package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewProductDao {

	ArrayList<ProductBean> list = new ArrayList<>();
	
	public ArrayList<ProductBean> view(){
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement psm = con.prepareStatement("select * from productexam");
			ResultSet rs = psm.executeQuery();
			while(rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setId(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getString(3));
				pb.setQty(rs.getString(4));
				list.add(pb);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
