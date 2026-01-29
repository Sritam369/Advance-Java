package com.sri.lab_questions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeLogIn {
	String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uName = "sritam";
	String pwd = "wolf";
	String sqlQuery1 = "insert into employeelogin values(?,?,?,?,?,?,?)";
	String sqlQuery2 = "select * from employeelogin";
	String sqlQuery3 = "update employeelogin set EMIAL=? , EPH=? where EID=?";
	String sqlQuery4 = "delete from employeelogin where ESAL between 50000 and 70000";
	String sqlQuery5 = "update employeelogin set ESAL=ESAL+(ESAL*0.10) ";
	
	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uName, pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	void insertData() {
		Connection con = connect();
		try(con){
			PreparedStatement psm1 = con.prepareStatement(sqlQuery1);
			IO.println("Inserting employee data");
			
			String id = IO.readln("Enter employee id");
			String name = IO.readln("Enter employee full name");
			int salary = Integer.parseInt(IO.readln("Enter employee salary"));
			String fname = IO.readln("Enter employee first name");
			String lname = IO.readln("Enter employee last name");
			String mail = IO.readln("Enter employee mail id");
			long phone = Long.parseLong(IO.readln("Enter employee phone number"));
			
			psm1.setString(1, id);
			psm1.setString(2, name);
			psm1.setInt(3, salary);
			psm1.setString(4, fname);
			psm1.setString(5, lname);
			psm1.setString(6, mail);
			psm1.setLong(7, phone);
			
			int rowCount1 = psm1.executeUpdate();
			if(rowCount1<=0) {
				IO.println("Data not inserted");
			}
			else {
				IO.println("Data inserted successfully");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void logIn() {
		Connection con = connect();
		try(con){
			PreparedStatement psm2 = con.prepareStatement(sqlQuery2,1004,1007);
			IO.println("Logging in...");
			String id = IO.readln("Enter employee id");
			String name = IO.readln("Enter employee full name");
			ResultSet rs = psm2.executeQuery();
			boolean flag = false;
			while(rs.next()) {
			if( rs.getString(1).equalsIgnoreCase(id) && rs.getString(2).equalsIgnoreCase(name)) {
				IO.println("Login successfull");
				flag=true;
			     
				rs.beforeFirst();
				String choice = IO.readln("Do you want to see all employee details ? [yes/no]");
				if(choice.equalsIgnoreCase("yes")) {
					while(rs.next()) {
						IO.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getLong(7));
					}
				}else {
					IO.println("Your wish...");
				}
				
				String choice2 = IO.readln("Do you want to update mailid / phone ? [yes/no]");
				if(choice2.equalsIgnoreCase("yes")) {
					PreparedStatement psm3 = con.prepareStatement(sqlQuery3);
					
					String id2 = IO.readln("Enter employee id to be updated");
					
							String mail = IO.readln("Enter new employee mail id");
							long phone = Long.parseLong(IO.readln("Enter new employee phone number"));
							
							psm3.setString(1, mail);
							psm3.setLong(2, phone);
							psm3.setString(3, id2);
							
							int rowCount2 = psm3.executeUpdate();
							if(rowCount2<=0) {
								IO.println("Data with id "+id+" not found");
							}
							else {
								IO.println("Data updated");
							}
												
				}
			
				else {
					IO.println("Your wish...");
				}
				
				
				String choice3 = IO.readln("Do you want to delete employee record ? [yes/no]");
				if(choice3.equalsIgnoreCase("yes")) {
					PreparedStatement psm4 = con.prepareStatement(sqlQuery4);
					int rowCount3 = psm4.executeUpdate();
					if(rowCount3<=0) {
						IO.println("Data not deleted");
					}
					else {
						IO.println("Data deleted");
					}
				}
				else {
					IO.println("Your wish");
				}
				
				String choice4 = IO.readln("Do you want to increase employee salary ? [yes/no]");
				if(choice4.equalsIgnoreCase("yes")) {
					PreparedStatement psm5 = con.prepareStatement(sqlQuery5);
					int rowCount4 = psm5.executeUpdate();
					
					if(rowCount4<=0) {
						IO.println("salary not increased");
					}
					else {
						IO.println("salary increased");
					}
				}
				else {
					IO.println("Your wish");
				}
			}			
			}
			
			if(!flag) {
				IO.println("Invalid process");
			}
			}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
  void main() {
	  EmployeeLogIn e = new EmployeeLogIn();
	  int size = Integer.parseInt(IO.readln("how many employee record do you want to insert"));
	  for(int i=0;i<size;i++) {
	  e.insertData();
	  }
	  e.logIn();
  }
}
