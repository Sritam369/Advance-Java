package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewCustomerProductsDao {

ArrayList<ProductBean> list = new ArrayList<>();
	
	public ArrayList<ProductBean> view() {
		try {
			Connection con = DBConnect.getCon();
			PreparedStatement psm = con.prepareStatement("select * from productclass");
			ResultSet rs = psm.executeQuery();
			while(rs.next()) {
				ProductBean pb= new ProductBean();
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setCompany(rs.getString(3));
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


