package com.java.webproject.oauth;

import org.apache.ibatis.annotations.Mapper;

import com.java.webproject.model.UserEntity;

@Mapper
public interface OauthMapper {
	
	
	//네이버 아이디 로그인체크
	public UserEntity loginCheck(UserEntity param);
	
	//네이버 아이디 회원가입 
	public int insUser(UserEntity param);
	
	//기존 이메일 체크 
	public UserEntity mailCheck(UserEntity param);
	
	//기존 연락처 체크 
	public UserEntity phoneCheck(UserEntity param);
	
	//카카오 아이디 회원가입
	public int kakaoInsUser(UserEntity param);
	
}
