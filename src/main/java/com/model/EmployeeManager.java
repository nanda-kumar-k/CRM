package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
	String url = "jdbc:mysql://localhost:3306/Employee";
	String dbuser = "root";
	String dbpwd = "Teja@123";

	Connection con = null;
	PreparedStatement ps = null;

	public int writeData(String username,String password,String email,String phone){
		try {
			con = DriverManager.getConnection(url, dbuser, dbpwd);
			ps = con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2,password);
			ps.setString(4,phone);
			ps.setString(3,email);
			int f = ps.executeUpdate();
	       if(f>0) {
		        return 1;
	       }
	       con.close();
		}
		catch(Exception e) {
			
		}
		return 0;
	}

	public int loginData(String username,String password) {
		
		try {
			con = DriverManager.getConnection(url, dbuser, dbpwd);
			ps = con.prepareStatement("select * from employee where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
	       if(rs.next()) {
		        return 1;
	       }
	       con.close();
		}
		catch(Exception e) {
			
		}
		return 0;
	}

}
