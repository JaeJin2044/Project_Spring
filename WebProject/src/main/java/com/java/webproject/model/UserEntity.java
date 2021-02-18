package com.java.webproject.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("UserEntity")
public class UserEntity {
	private int u_Pk;
	private String u_Nm;
	private String u_Id;
	private String u_Pass;
	private String u_Salt;
	private String u_Gender;
	private String u_Phone;
	private String u_Addr;
	private String u_Mail;
	private Date u_regDate;
	private String u_LogType;
	
	public String getU_LogType() {
		return u_LogType;
	}
	public void setU_LogType(String u_LogType) {
		this.u_LogType = u_LogType;
	}
	public int getU_Pk() {
		return u_Pk;
	}
	public void setU_Pk(int u_Pk) {
		this.u_Pk = u_Pk;
	}
	public String getU_Nm() {
		return u_Nm;
	}
	public void setU_Nm(String u_Nm) {
		this.u_Nm = u_Nm;
	}
	public String getU_Id() {
		return u_Id;
	}
	public void setU_Id(String u_Id) {
		this.u_Id = u_Id;
	}
	public String getU_Pass() {
		return u_Pass;
	}
	public void setU_Pass(String u_Pass) {
		this.u_Pass = u_Pass;
	}
	public String getU_Gender() {
		return u_Gender;
	}
	public void setU_Gender(String u_Gender) {
		this.u_Gender = u_Gender;
	}
	
	public String getU_Phone() {
		return u_Phone;
	}
	public void setU_Phone(String u_Phone) {
		this.u_Phone = u_Phone;
	}
	
	public Date getU_regDate() {
		return u_regDate;
	}
	public void setU_regDate(Date u_regDate) {
		this.u_regDate = u_regDate;
	}
	public String getU_Salt() {
		return u_Salt;
	}
	public void setU_Salt(String u_Salt) {
		this.u_Salt = u_Salt;
	}
	public String getU_Addr() {
		return u_Addr;
	}
	public void setU_Addr(String u_Addr) {
		this.u_Addr = u_Addr;
	}
	public String getU_Mail() {
		return u_Mail;
	}
	public void setU_Mail(String u_Mail) {
		this.u_Mail = u_Mail;
	}
	
	
	
	
}
