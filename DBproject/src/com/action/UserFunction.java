package com.action;

import com.model.*;

import com.sql.MySQL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class UserFunction {
	
	private int userid;

	private String username;
	private String password;
	private String password1;
	private String password2;
	private String email;
	private int unitID;
	private String invite;
	private String sex;
	private String Phone;
	private String IDcard;
	private Vector<User> Us;
	private int deleteuser;
	private String unit;
	private int educationID;
	private int workID;
	private int inviteID;
	
	//model 类
	private Lab lab;
	private User user;
	private Vector<Education> edu;
	private Vector<Work> work;
	
	public Vector<Work> getWork() {
		return work;
	}
	public void setWork(Vector<Work> work) {
		this.work = work;
	}
	public Vector<Education> getEdu() {
		return edu;
	}
	public void setEdu(Vector<Education> edu) {
		this.edu = edu;
	}

	public void setUnitID(int unitID) {
		this.unitID=unitID;
	}
	public int  getUnitID() {
		return unitID;
	}
	public Lab getLab() {
		return lab;
	}
	public void setLab(Lab lab) {
		this.lab=lab;
	}
	public int getDeleteuser() {
		return deleteuser;
	}
	public void setDeleteuser(int deleteuser) {
		this.deleteuser=deleteuser;
	}
	public Vector<User> getUs() {
		return Us;
	}
	public void setUs(Vector<User> Us) {
		this.Us=Us;
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
		this.userid = userid;
	}

	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getEducationID() {
		return educationID;
	}
	public void setEducationID(int educationID) {
		this.educationID = educationID;
	}
	public int getWorkID() {
		return workID;
	}
	public void setWorkID(int workID) {
		this.workID = workID;
	}
	public int getInviteID() {
		return inviteID;
	}
	public void setInviteID(int inviteID) {
		this.inviteID = inviteID;
	}
	public String getInvite() {
		return invite;
	}
	public void setInvite(String invite) {
		this.invite = invite;
	}

	public int returnUnitID(String unit) {
		switch(unit)
		{
		case "CS":return 0;
		case "BigData":return 1;
		case "Welding":return 2;
		case "AI":return 3;
		default:return -1;
		}
	}
	
	/*
	 * 	用户注册
	 */
	public String UserRegis() {
		MySQL sql = new MySQL();
		int id=sql.Number();
		User user=new User();
		System.out.println(invite);
		inviteID=sql.getType(invite);
		unitID=returnUnitID(unit);
		
		user.setInviteID(inviteID);
		user.setUnitID(unitID);
		System.out.println(inviteID+"  "+unitID);
		user.set(username,unit,id,unitID,password1, sex, email,IDcard,Phone, -1, -1, inviteID);
		sql.insertUser(user);
		sql.close();
		return "success";
	}

	 /*
	  * 用户登陆
	  */
	 public String UserLogin() {
		MySQL sql=new MySQL();
		user=sql.Account(username, password);
		sql.close();;
		if(user==null)
			return "error";
		return "success";
	}
	
	 /*
	  * 返回主界面
	  */
	public String Home() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.close();
		return "success";
	}
	
	/*
	 *  查询个人信息
	 */
	public String Profile() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.close();
		return "success";
	}
	
	/*
	 *  查询实验室信息
	 */
	public String unitInfor() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		lab=sql.userSelectInfor(userid);
		return "success";
	}
	
	/*
	 *  查询教育经历
	 */
	public String userEdu() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		edu=sql.userSelectEdcation(userid);
		return "success";
	}
	
	/*
	 * 查询工作经历
	 */
	public String userWork() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		work=sql.userSelectWork(userid);
		return "success";
	}
//	public String UserManage() {
//		MySQL sql=new MySQL();
//		user=sql.userInfor(userid);
//		if(user.getType().equals("1"))
//		{
//			Us=sql.selectUser(user.getUnit(),0);
//			sql.close();
//			return "success";
//		}
//		else if(user.getType().equals("2"))
//		{
//			Us=sql.selectUser("",1);
//			sql.close();
//			return "success";
//		}
//		
//		return "error";
//	}
//	public String DeleteUser() {
//		MySQL sql=new MySQL();
//		user=sql.userInfor(userid);
//		User user2=sql.userInfor(deleteuser);
//		if(user2.getType().equals("0") && user.getType().equals("1"))
//		{
//	        sql.DeleteUser(user2.getUserid());
//	        Us=sql.selectUser(user.getUnit(), 0);
//	        return "success";
//		}
//		else if(user.getType().equals("2"))
//		{
//			sql.DeleteUser(user2.getUserid());
//			Us=sql.selectUser("", 1);
//	        return "success";
//		}
//		userid=user.getUserid();
//		return "success";
//	}
//	
//	public String graph() {
//		MySQL sql=new MySQL();
//		user=sql.userInfor(userid);
//		return "success";
//	}


}
