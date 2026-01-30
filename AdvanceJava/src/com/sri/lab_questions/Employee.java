package com.sri.lab_questions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Employee {
	int id;
	String name;
	int age;
	double salary;
	
	String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uName = "sritam";
	String pwd = "wolf";
	String query = "select * from employeejdbc";	
	
	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;		
	}
	
	public Employee() {
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	void main() {

		List<Employee>list = new ArrayList<>();
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uName, pwd);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()){
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				double salary = rs.getDouble(4);
				
				Employee e = new Employee(id,name,age,salary);
				list.add(e);
			}
			
			for(Employee e:list) {
				if(e.age>25) {
					IO.println(e);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
