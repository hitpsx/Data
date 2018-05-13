package com.action;


import com.model.*;

import com.sql.MySQL;
import java.util.Vector;

public class selectFunction {
	private int userid;
	private Vector<Cs> Cp;
	private User user;
	private int page;
	private String Aim;
	
	
	public String getAim() {
		return Aim;
	}
	public void setAim(String Aim) {
		this.Aim=Aim;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page=page;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Vector<Cs> getCp() {
		return Cp;
	}

	public void setCp(Vector<Cs> Cp) {
		this.Cp = Cp;
	}
	public String  SelectHome() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		String unit=user.getUnit();
		Cp=sql.selectEqu(page, unit, 0);
		sql.close();
		return "success";
	}
	
	public String CsSelect() {
		MySQL sql=new MySQL();
		System.out.println(Aim);
		user=sql.userInfor(userid);
		Cp=sql.selectCsAll(Aim, user.getUnit(), page);
		System.out.println(Cp.size());
		sql.close();
		return "success";
	}

}
