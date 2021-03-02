package com.java.webproject.model;

import org.apache.ibatis.type.Alias;

@Alias("CommentDomain")
public class CommentDomain extends CommentEntity {

	private String writerNm;

	public String getWriterNm() {
		return writerNm;
	}

	public void setWriterNm(String writerNm) {
		this.writerNm = writerNm;
	}
	
	
	
	
}
