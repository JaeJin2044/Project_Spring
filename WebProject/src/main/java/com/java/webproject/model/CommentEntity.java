package com.java.webproject.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias("CommentEntity")
public class CommentEntity {
	private int c_pk;
	private int u_pk;
	private int m_pk;
	private int c_seq;
	private String c_content;
	private Date c_regDate;
	
	public int getC_pk() {
		return c_pk;
	}
	public void setC_pk(int c_pk) {
		this.c_pk = c_pk;
	}
	public int getU_pk() {
		return u_pk;
	}
	public void setU_pk(int u_pk) {
		this.u_pk = u_pk;
	}
	public int getM_pk() {
		return m_pk;
	}
	public void setM_pk(int m_pk) {
		this.m_pk = m_pk;
	}
	
	public int getC_seq() {
		return c_seq;
	}
	public void setC_seq(int c_seq) {
		this.c_seq = c_seq;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public Date getC_regDate() {
		return c_regDate;
	}
	public void setC_regDate(Date c_regDate) {
		this.c_regDate = c_regDate;
	}
	
	
}
