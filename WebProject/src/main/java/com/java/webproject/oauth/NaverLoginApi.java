package com.java.webproject.oauth;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverLoginApi extends DefaultApi20{

	//생성자 
	protected NaverLoginApi() {
	}
	
	//객체 하나만을 생성하기 위한 싱글톤 타입관련메서드
	private static class InstanceHolder{
		private static final NaverLoginApi INSTANCE = new NaverLoginApi();
	}
	
	//인스턴스 생성 메서드 
	public static NaverLoginApi instance() {
		return InstanceHolder.INSTANCE;
	}
	
	
	@Override
	public String getAccessTokenEndpoint() {
		return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		return "https://nid.naver.com/oauth2.0/authorize";
	}

}
