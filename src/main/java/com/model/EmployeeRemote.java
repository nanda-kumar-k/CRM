package com.model;

public interface EmployeeRemote {

	public int writeData(String username,String password,String email,String phone,String name,String edu,String jobRole,String location);
	public int loginData(String username,String password);
	public int cwriteData(String username,String password,String email,String name,String location);
	public int cloginData(String username,String password);
}
