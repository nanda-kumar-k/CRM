package com.model;

public interface EmployeeRemote {

	public int writeData(String username,String password,String email,String phone);
	public int loginData(String username,String password);
}
