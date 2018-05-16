package com.action;
import com.model.*;

import com.sql.MySQL;
import java.util.Vector;
public class RetireFunction {
	private int userid;
	private User user;
	private Vector<Retirement> Re;
	int page;
	
	private Cs Cp;
	private int EquNumber;

	private String EquName;
	private String application;
	private String ApplicationDate;
	private String Applicant;
	
	public  String getApplicant() {
		return Applicant;
	}
	public  void setApplicant(String Applicant) {
		this.Applicant=Applicant;
	}
	
	public  String getApplicationDate() {
		return ApplicationDate;
	}
	public void setApplicationDate(String ApplicationDate) {
		this.ApplicationDate=ApplicationDate;
	}	

	public String getEquName() {
		return EquName;
	}
	
	public void setEquName(String EquName) {
		this.EquName=EquName;
	}
	
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application=application;
	}
	public int getEquNumber() {
		return EquNumber;
	}
	public void setEquNumber(int EquNumber) {
		this.EquNumber = EquNumber;
	}
	
	public Cs getCp() {
		return Cp;
	}
	public void setCp(Cs Cp) {
		this.Cp = Cp;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page=page;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Vector<Retirement> getRe() {
		return Re;
	}
	public void setCp(Vector<Retirement> Re) {
		this.Re= Re;
		
	}
	
	
	public String RetirButton() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		System.out.println(EquNumber);
		Cp=sql.selectEquNumber(EquNumber);
		sql.close();
		return "success";
	}
	
	public String RetireManage() {
		System.out.println(EquNumber);
		MySQL sql=new MySQL();
		Retirement re=new Retirement();
		user=sql.userInfor(userid);
		Cs cp=new Cs();
		
		String b="";
	 	String p[]=ApplicationDate.split("/");
	 	b=p[2]+"-"+p[0]+"-"+p[1];
	 	ApplicationDate=b;

		String unit=sql.userUnit(userid);
		sql.updateCsSta("´ý±¨·ÏÈ·ÈÏ", EquNumber);
	    cp=sql.selectEquNumber(EquNumber);
		re.set(cp.getEquNumber(),cp.getEquName(),cp.getEquDate(),ApplicationDate,Applicant," ","",unit,cp.getEquClass(),cp.getInventoryPosition(),cp.getUnitPrice()
				,cp.getHandler(),cp.getEquSta(),application);
		sql.insertRetire(re);
		sql.close();
		return "success";
	}
	
	public String HomeRetire() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		String unit=sql.userUnit(userid);
		Re=sql.selectRetir(unit,page);
		sql.close();
		return "success";
	}
	

}
