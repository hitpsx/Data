package com.action;

import java.util.Vector;

import com.model.Cs;
import com.model.Lendin;
import com.model.User;
import com.sql.MySQL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.*;
public class LendFunction {
	private int userid;
	private User user;
	int page;
	private Vector<Lendin> lend;
	private Cs Cp;
	private int EquNumber;
	private String EquName;
	private int LendNumber;
	private String unitlend;
	private String maintext;
	private String application;
	private String ApplicationDate1;
	private String ApplicationDate2;
	private String Applicant;
	private String UnitLend;
	
	public String getUnitLend() {
		return UnitLend;
	}
	
	public void setUnitLend(String UnitLend) {
		this.UnitLend=UnitLend;
	}
	public  String getApplicant() {
		return Applicant;
	}
	public  void setApplicant(String Applicant) {
		this.Applicant=Applicant;
	}
	
	public  String getApplicationDate1() {
		return ApplicationDate1;
	}
	public void setApplicationDate1(String ApplicationDate1) {
		this.ApplicationDate1=ApplicationDate1;
	}
	public  String getApplicationDate2() {
		return ApplicationDate2;
	}
	public void setApplicationDate2(String ApplicationDate2) {
		this.ApplicationDate2=ApplicationDate2;
	}
	public int getLendNumber() {
		return LendNumber;
	}
	public void setLendNumber(int LendNumber) {
		this.LendNumber=LendNumber;
	}
	public String getUnitlend() {
		return unitlend;
	}
	public void setUnitlend(String unitlend) {
		this.unitlend=unitlend;
	}
	public String getEquName() {
		return EquName;
	}
	
	public void setEquName(String EquName) {
		this.EquName=EquName;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page=page;
	}
	public Vector<Lendin> getLend() {
		return lend;
	}
	public void setLend(Vector<Lendin> lend) {
		this.lend=lend;
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
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application=application;
	}
	
	
	public String getMaintext() {
		return  maintext;
	}
	public void setMaintext(String maintext) {
		this.maintext=maintext;
	}
	
	public String HomeLend() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		String unit=sql.userUnit(userid);
		lend=sql.getlendins(unit,page);
		sql.close();
		return "success";
	}
	public String LendButton() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Cp=sql.selectEquNumber(EquNumber);
		sql.close();
		return "success";
	}
	
	public String LendManage() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);	
		Lendin lend=new Lendin();
		String LendUnit=sql.userUnit(userid);
		System.out.println(unitlend);
		sql.updateCsSta("待确认借出",LendNumber);
		
		String b="";
	 	String p[]=ApplicationDate1.split("/");
	 	b=p[2]+"-"+p[0]+"-"+p[1];
	 	ApplicationDate1=b;
	 	
	 	b="";
	 	String p2[]=ApplicationDate2.split("/");
	 	b=p2[2]+"-"+p2[0]+"-"+p2[1];
	 	ApplicationDate2=b;
	 	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Date date=new Date();


	    Date date2=null;
	    try {  
	        date2=format.parse(ApplicationDate2);  
	     } catch (ParseException e) {  
	    	e.printStackTrace();  
	     }
		long difference =  Math.abs((date.getTime()-date2.getTime())/86400000);
		String Countdown=String.valueOf(difference)+"天";
		       
		lend.set(LendNumber,EquName,LendUnit,maintext,application,unitlend,"待确认借出",ApplicationDate1,ApplicationDate2,Applicant,"",Countdown);
		sql.insertLend(lend);
		System.out.println(lend.getEquName());
		sql.close();
		return "success";
	}
	
}
