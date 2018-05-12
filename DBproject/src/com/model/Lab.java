package com.model;

public class Lab {
	private int id;
	private String labname;
	private String labpeople;
	private String email;
	private String phone;
	private String number;
	public String getLabname() {
		return labname;
	}
	public void setLabname(String labname) {
		this.labname = labname;
	}
	public String getLabpeople() {
		return labpeople;
	}
	public void setLabpeople(String labpeople) {
		this.labpeople = labpeople;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void set(int id,
				   String labname,
				   String labpeople,
				   String phone,
				   String email,
				   String number) {
		this.id=id;
		this.labname=labname;
		this.labpeople=labpeople;
		this.email=email;
		this.number=number;
	}


}
