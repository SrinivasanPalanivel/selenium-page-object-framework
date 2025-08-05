package com.ui.pojo;

public class User {

	private String username;
	private String password;
	private String accountName;
	
	public User(String username, String password, String accountName) {
		super();
		this.username = username;
		this.password = password;
		this.accountName = accountName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", accountName=" + accountName + "]";
	}
	
	
	
}
