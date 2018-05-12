package com.model;

public class Education {
	private  int id;
	private String degree;
	private String schcool;
	private String entryday;
	private String outday;
	private int educationID;
	
	
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEntryday() {
		return entryday;
	}
	public void setEntryday(String entryday) {
		this.entryday = entryday;
	}
	public String getSchcool() {
		return schcool;
	}
	public void setSchcool(String schcool) {
		this.schcool = schcool;
	}

	public String getOutday() {
		return outday;
	}
	public void setOutday(String outday) {
		this.outday = outday;
	}
	public int getEducationID() {
		return educationID;
	}
	public void setEducationID(int educationID) {
		this.educationID = educationID;
	}
	
	public void set (int id,
					 int educationID,
					 String schcool,
					 String entryday,
					 String outday,
					 String degreee) {
		this.id=id;
		this.educationID=educationID;
		this.schcool=schcool;
		this.entryday=entryday;
		this.outday=outday;
		this.degree=degree;
	}

}
