package com.java.webproject.model;

import org.apache.ibatis.type.Alias;

@Alias("MatZipDomain")
public class MatZipDomain extends MatZipEntity {

	private String c_content;
	private String u_profile;
	private String u_nm;
	private String c_regDate;
	private int u_pk;
	
	
	public int getU_pk() {
		return u_pk;
	}

	public void setU_pk(int u_pk) {
		this.u_pk = u_pk;
	}

	public String getU_profile() {
		return u_profile;
	}

	public void setU_profile(String u_profile) {
		this.u_profile = u_profile;
	}

	public String getU_nm() {
		return u_nm;
	}

	public void setU_nm(String u_nm) {
		this.u_nm = u_nm;
	}

	public String getC_regDate() {
		return c_regDate;
	}

	public void setC_regDate(String c_regDate) {
		this.c_regDate = c_regDate;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	
	
}
