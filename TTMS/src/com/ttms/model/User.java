package com.ttms.model;

public class User {
	
	/**
	 * 权限若为0 为售票员
	 * 权限若为1为系统管理员
	 * 权限若为2为经理
	 */
	private int userId;//用户Id 
	private String userName;//用户名称
	private String userPassword;//用户密码
	private int userPower;//用户权限
	private String userDesc="";//用户备注
	
	public User()
	{
		super();
	}
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public User(String userName, String userPassword, int userPower, String userDesc) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPower = userPower;
		this.userDesc = userDesc;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserPower() {
		return userPower;
	}
	public void setUserPower(int userPower) {
		this.userPower = userPower;
	}
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	
	
}
