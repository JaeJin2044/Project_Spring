package com.java.webproject.model;

import org.apache.ibatis.type.Alias;

@Alias("MatZipDomain")
public class MatZipDomain extends MatZipEntity {

	private String c_content;

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	
	
}
