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
	private graph gh;
	
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
	public graph getGh() {
		return gh;
	}
	public void setGh(graph gh) {
		this.gh = gh;
	}
	public String  SelectHome() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		String unit=user.getUnit();
		Cp=sql.selectEqu(page, unit);
		sql.close();
		return "success";
	}
	
	public String CsSelect() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Cp=sql.selectCsAll(Aim, user.getUnit(), page);
		System.out.println(Cp.size());
		sql.close();
		return "success";
	}
	
	public String ViewSelect() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		String unit=user.getUnit();
		Cp=sql.selectCsView(page, unit);
		sql.close();
		return "success";
	}
	
	public String graph() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		int []tmp=sql.getGraph();
		gh=new graph();
		gh.set(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]);
		return "success";
	}


}
