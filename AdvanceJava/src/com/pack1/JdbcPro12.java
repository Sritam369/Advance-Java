package com.pack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcPro12 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "sritam";
	String dbPwd = "wolf";
	String q1="insert into mydatabase values(?,?)";
	String q2="Select pic_data from mydatabase where id=?";
	
	Connection connect() {
		Connection con = null;
		try {
			IO.println("connecting");
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
			IO.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	void m1() {
		Connection con = connect();
		try(con){
		FileInputStream fis = new FileInputStream("\\D:\\NEW\\PIC.PNG");
		PreparedStatement psm1 = con.prepareStatement(q1);
		psm1.setString(1, "101");
		psm1.setBlob(2, fis);
		int rowCount = psm1.executeUpdate();
		if(rowCount<=0) {
			IO.println("Data not inserted");
		}
		else {
			IO.println("Data inserted");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void m2() {
		Connection con = connect();
		try(con){
			PreparedStatement psm2 = con.prepareStatement(q2);
			psm2.setString(1, "101");
			ResultSet rs = psm2.executeQuery();
			if(rs.next()) {
				Blob b = rs.getBlob(1);
				byte []arr = b.getBytes(1, (int) b.length());
				FileOutputStream fos = new FileOutputStream("\\D:\\NEW\\PIC2.PNG");
				fos.write(arr);
				IO.println("Image retrieved");				
			}
			else {
				IO.println("Image not retrieved");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
void main() {
	JdbcPro12 j12=new JdbcPro12();
	j12.m1();
	j12.m2();

}
}