package com.java.webproject.model;

import java.util.Date;

public class ReviewEntity {
	private int r_Pk;
	private int u_Pk;
	private int m_Pk;
	private int r_Seq;
	private String r_Title;
	private String r_Content;
	private Date r_RegDate;
	
	public int getR_Pk() {
		return r_Pk;
	}
	public void setR_Pk(int r_Pk) {
		this.r_Pk = r_Pk;
	}
	public int getU_Pk() {
		return u_Pk;
	}
	public void setU_Pk(int u_Pk) {
		this.u_Pk = u_Pk;
	}
	public int getM_Pk() {
		return m_Pk;
	}
	public void setM_Pk(int m_Pk) {
		this.m_Pk = m_Pk;
	}
	public int getR_Seq() {
		return r_Seq;
	}
	public void setR_Seq(int r_Seq) {
		this.r_Seq = r_Seq;
	}
	public String getR_Title() {
		return r_Title;
	}
	public void setR_Title(String r_Title) {
		this.r_Title = r_Title;
	}
	public String getR_Content() {
		return r_Content;
	}
	public void setR_Content(String r_Content) {
		this.r_Content = r_Content;
	}
	public Date getR_RegDate() {
		return r_RegDate;
	}
	public void setR_RegDate(Date r_RegDate) {
		this.r_RegDate = r_RegDate;
	}
	
	
	
	
	
	
}
