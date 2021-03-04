package com.java.webproject.model;

import org.apache.ibatis.type.Alias;

@Alias("CommentDomain")
public class CommentDomain extends CommentEntity {

	private String writerNm;
	private int listCount;

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
