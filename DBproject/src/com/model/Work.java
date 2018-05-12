package com.model;

public class Work {
	
	private  int id;
	private String company;
	private String position;
	private String entryday;
	private String outday;
	private int workID;
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getWorkID() {
		return workID;
	}
	public void setWorkID(int workID) {
		this.workID = workID;
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


	public String getOutday() {
		return outday;
	}
	public void setOutday(String outday) {
		this.outday = outday;
	}

	
	public void set (int id,
					 int workID,
					 String company,
					 String entryday,
					 String outday,
					 String position) {
		this.id=id;
		this.workID=workID;
		this.company=company;
		this.entryday=entryday;
		this.outday=outday;
		this.position=position;
	}

}

