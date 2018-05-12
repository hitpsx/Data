package com.action;

import com.model.User;

import com.sql.MySQL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class UserFunction {
	private int userid;
	private String username;
	private String password;
	private User user;
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

	
	 public String UserLogin() {
		MySQL sql=new MySQL();
		user=sql.Account(username, password);
		sql.close();;
		if(user==null)
			return "error";
		return "success";
	}
	
//	public String Home() {
//		MySQL sql=new MySQL();
//		user=sql.userInfor(userid);
//		sql.close();
//		
//		if(user.getType().equals("2") || user.getType().equals("1"))  //超级管理员
//			return "admin";
//		else if(user.getType().equals("0")) //成员用户
//			return "success";
//		else if(user.getType().equals("3"))
//			return "Repair";
//		return "error";
//	}
//	
//	
	public String Profile() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.close();
		System.out.println(user.getUnitID());
		System.out.println(user.getEducationID());
		System.out.println(user.getWorkID());
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
