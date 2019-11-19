package com.ssafy.pms.dto;

public class UserInfo {
	private String id;
	private String pw;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pw=" + pw + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
