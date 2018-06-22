package com.demo.UserInfo.Entity;

public class User {
	public String UserName;
	public String PassWord;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		this.PassWord = passWord;
	}

	public User(String userName, String passWord) {
		super();
		this.UserName = userName;
		this.PassWord = passWord;
	}

	public User() {		
	}

	@Override
	public String toString() {
		return "User [UserName=" + UserName + ", PassWord=" + PassWord + "]";
	}
 
}
