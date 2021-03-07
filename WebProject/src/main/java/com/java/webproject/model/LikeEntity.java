package com.java.webproject.model;

import org.apache.ibatis.type.Alias;

@Alias("LikeEntity")
public class LikeEntity {
	private int l_pk;
	private int m_pk;
	private int u_pk;
	private String m_img1;
	private String m_viewDetail;
	private float m_starPoint;
	private int m_viewCount;
	private int m_commentCount;
	private String m_title;
	
	
	
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public int getL_pk() {
		return l_pk;
	}
	public void setL_pk(int l_pk) {
		this.l_pk = l_pk;
	}
	public int getM_pk() {
		return m_pk;
	}
	public void setM_pk(int m_pk) {
		this.m_pk = m_pk;
	}
	public int getU_pk() {
		return u_pk;
	}
	public void setU_pk(int u_pk) {
		this.u_pk = u_pk;
	}
	public String getM_img1() {
		return m_img1;
	}
	public void setM_img1(String m_img1) {
		this.m_img1 = m_img1;
	}
	public String getM_viewDetail() {
		return m_viewDetail;
	}
	public void setM_viewDetail(String m_viewDetail) {
		this.m_viewDetail = m_viewDetail;
	}
	public float getM_starPoint() {
		return m_starPoint;
	}
	public void setM_starPoint(float m_starPoint) {
		this.m_starPoint = m_starPoint;
	}
	public int getM_viewCount() {
		return m_viewCount;
	}
	public void setM_viewCount(int m_viewCount) {
		this.m_viewCount = m_viewCount;
	}
	public int getM_commentCount() {
		return m_commentCount;
	}
	public void setM_commentCount(int m_commentCount) {
		this.m_commentCount = m_commentCount;
	}
	
	
	
}
