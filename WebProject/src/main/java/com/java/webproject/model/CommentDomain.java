package com.java.webproject.model;

import org.apache.ibatis.type.Alias;

@Alias("CommentDomain")
public class CommentDomain extends CommentEntity {

	private String writerNm;
	private int listCount;
	private String u_profile;
	
	public String getU_profile() {
		return u_profile;
	}
	public void setU_profile(String u_profile) {
		this.u_profile = u_profile;
	}

	public String getWriterNm() {
		return writerNm;
	}

	public void setWriterNm(String writerNm) {
		this.writerNm = writerNm;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	
	
	
	
}
