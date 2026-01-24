package com.pack1;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcPro7 {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uName = "sritam";
	String pwd = "wolf";
	
	void meth1() {
		IO.println("Implementing JdbcRowSet");
		try {
			RowSetFactory rsf = RowSetProvider.newFactory();
			JdbcRowSet jrs = rsf.createJdbcRowSet();
			jrs.setUrl(url);
			jrs.setUsername(uName);
			jrs.setPassword(pwd);
			jrs.setCommand("select * from employee");
			jrs.execute();
			IO.println();
			
			while(jrs.next()) {
				IO.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
			}
			IO.println();
			
			jrs.afterLast();
			while(jrs.previous()) {
				IO.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void meth2() {
		IO.println("Implementing CachedRowSet");
		try {
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.setUrl(url);
			crs.setUsername(uName);
			crs.setPassword(pwd);
			crs.setCommand("select eid,efname,esal from employee");
			crs.execute();
			while(crs.next()) {
				String e_id=crs.getString(1);
				if(e_id.equals("102")) {
					crs.updateInt(3, 75000);
					crs.updateRow();
				}
			}
			crs.acceptChanges();
			crs.beforeFirst();
			while(crs.next()) {
				if(crs.getString(1).equals("102")) {
					IO.println(crs.getString(1)+" "+crs.getString(2)+" "+crs.getInt(3));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
void main() {
	JdbcPro7 obj = new JdbcPro7();
	obj.meth1();
	obj.meth2();
}
}
