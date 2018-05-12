package com.model;

public class User {
	private String username;
	private String password;
	private String unit;
	private String email;
	private int unitID;
	private String sex;
	private int userid;
	private String Phone;
	private String IDcard;
	private int educationID;
	private int workID;
	private int inviteID;
	
	
	public int getUnitID() {
		return unitID;
	}
	public void setUnitID(int unitID) {
		this.unitID=unitID;
	}
	public int getEducationID() {
		return educationID;
	}
	public void setEducationID(int educationID) {
		this.educationID=educationID;
	}
	public int getWorkID() {
		return workID;
	}
	public void setWorkID(int workID) {
		this.workID=workID;
	}
	public int getInviteID() {
		return inviteID;
	}
	public void setInviteID(int inviteID) {
		this.inviteID=inviteID;
	}
	public String getIDcard() {
		return IDcard;
	}
	public void setIDcard(String IDcard) {
		this.IDcard=IDcard;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone=Phone;
	}
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid=userid;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public void set(
			String username,
			String unit,
			int userid,
			int unitID,
			String password,
			String sex,
			String email,
			String IDcard,
			String Phone,
			int educationID,
			int workID,
			int inviteID) {
		this.username= username;
		this.unit=unit;
		this.userid=userid;
		this.unitID=unitID;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.IDcard=IDcard;
		this.Phone=Phone;
		this.educationID=educationID;
		this.workID=workID;
		this.inviteID=inviteID;
	}
}