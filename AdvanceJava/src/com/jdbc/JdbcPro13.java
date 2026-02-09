package com.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPro13 {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbUname = "sritam";
	String dbPwd = "wolf";
	String q1="insert into mydatabase2 values(?,?)";
	String q2="Select file_data from mydatabase2 where id=?";
	
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
		try {
			IO.println("passing a file into the database");
			Connection con=connect();
			PreparedStatement pstmt1=con.prepareStatement(q1);
			pstmt1.setString(1, "101");
			pstmt1.setClob(2, new FileReader("D:\\NEW\\file1.txt"));
			int rs=pstmt1.executeUpdate();
			if(rs>0) {
				IO.println("inserted");
			}
			else {
				throw new SQLException("file not inserted");
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}       
	}
	void m2() {
		IO.println("retriving file");
		try {
			Connection con=connect();
			PreparedStatement pstmt2=con.prepareStatement(q2);
			pstmt2.setString(1, "101");
			ResultSet rs=pstmt2.executeQuery();
			
			if(rs.next()) {
				Clob b=rs.getClob(1);
				Reader data=b.getCharacterStream();
				BufferedReader br=new BufferedReader(data);
				FileWriter fw=new FileWriter("D:\\NEW\\file2.txt");
				String line;
				while((line=br.readLine())!=null) {
					fw.write(line);
				}
				br.close();
				fw.close();
				
				IO.println("file data retrived");
			}
			else {
				throw new SQLException("file not retrived");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
void main() {
	JdbcPro13 j13=new JdbcPro13();
	j13.m1();
	j13.m2();
}
}