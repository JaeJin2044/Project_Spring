package com.java.webproject.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("UserEntity")
public class UserEntity {
	private int u_pk;
	private String u_nm;
	private String u_id;
	private String u_pass;
	private String u_salt;
	private String u_gender;
	private String u_phone;
	private String u_mail;
	private Date u_regDate;
	private String u_logType;
	private String u_profile;
	
	public int getU_pk() {
		return u_pk;
	}
	public void setU_pk(int u_pk) {
		this.u_pk = u_pk;
	}
	public String getU_nm() {
		return u_nm;
	}
	public void setU_nm(String u_nm) {
		this.u_nm = u_nm;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pass() {
		return u_pass;
	}
	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}
	public String getU_salt() {
		return u_salt;
	}
	public void setU_salt(String u_salt) {
		this.u_salt = u_salt;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_mail() {
		return u_mail;
	}
	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}
	public Date getU_regDate() {
		return u_regDate;
	}
	public void setU_regDate(Date u_regDate) {
		this.u_regDate = u_regDate;
	}
	public String getU_logType() {
		return u_logType;
	}
	public void setU_logType(String u_logType) {
		this.u_logType = u_logType;
	}
	public String getU_profile() {
		return u_profile;
	}
	public void setU_profile(String u_profile) {
		this.u_profile = u_profile;
	}

	
	
	
	
	
	
}
