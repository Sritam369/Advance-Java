package com.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcPro11 {
	String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uName = "sritam";
	String pwd = "wolf";
	String query = "select * from employee where EID = ?";
	
	Connection connect() {
		   Connection con=null;
		   try {
			   Class.forName(driver);
			    con = DriverManager.getConnection(url, uName, pwd);
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		   return con;
	   }
	
	void meth1() {
		Connection con = connect();
		try(con){
			
			DatabaseMetaData dmdt = con.getMetaData();
			IO.println("getDatabaseProductName() : "+dmdt.getDatabaseProductName());
			IO.println("getDatabaseProductVersion() : "+dmdt.getDatabaseProductVersion());
			IO.println("getDriverName() : "+dmdt.getDriverName());
			IO.println("supportsStoredProcedures() : "+dmdt.supportsStoredProcedures());
			
			IO.println("===========================");
			
			PreparedStatement psm = con.prepareStatement(query);			
			psm.setString(1, "101");
			ResultSet rs = psm.executeQuery();
			ParameterMetaData pmd = psm.getParameterMetaData();
			IO.println("getParameterCount() : "+pmd.getParameterCount());
//			IO.println("getParameterType() : "+pmd.getParameterType(1));
//			IO.println("getParameterMode() : "+pmd.getParameterMode(1));
//			IO.println("isNullable() : "+pmd.isNullable(1));
			
			IO.println("===========================");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			IO.println("getColumnCount() : "+rsmd.getColumnCount());
			IO.println("getColumnName() : "+rsmd.getColumnName(1));
			IO.println("getColumnDisplaySize() : "+rsmd.getColumnDisplaySize(1));
			IO.println("isAutoIncrement() : "+rsmd.isAutoIncrement(1));
			
			IO.println("===========================");
			
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.setUrl(url);
			crs.setUsername(uName);
			crs.setPassword(pwd);
			crs.setCommand("select * from employee");
			crs.execute();
			
			RowSetMetaData rsm = (RowSetMetaData)crs.getMetaData();
			IO.println("getColumnCount() : "+rsm.getColumnCount());
			IO.println("getColumnName() : "+rsm.getColumnName(1));
			IO.println("getColumnDisplaySize() : "+rsm.getColumnDisplaySize(1));
			IO.println("isAutoIncrement() : "+rsm.isAutoIncrement(1));
			IO.println("getColumnType() : "+rsm.getColumnType(1));
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void main() {
		new JdbcPro11().meth1();
	}
}
