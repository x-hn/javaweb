package com.xhn.model;

public class userInfo {
	private int id;
	private String username;
	private String realname;
	private String email;
	private String password;
	private int role;
	private int maxNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	@Override
	public String toString() {
		return "userInfo [id=" + id + ", username=" + username + ", realname=" + realname + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", maxNumber=" + maxNumber + "]";
	}
	
	
}
