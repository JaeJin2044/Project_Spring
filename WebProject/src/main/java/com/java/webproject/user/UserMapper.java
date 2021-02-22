package com.java.webproject.user;

import org.apache.ibatis.annotations.Mapper;

import com.java.webproject.model.UserEntity;

@Mapper
public interface UserMapper {
	//회원가입
	int insUser(UserEntity param);
	//회원가입(이메일,연락처 체크)
	UserEntity joinCheck(UserEntity param);
	
	//아이디 중복확인 &&로그인 체크 
	UserEntity idCheck(UserEntity param);
	
	//아이디 찾기 
	UserEntity findId(UserEntity param);
	//비밀번호 변경 
	int changePw(UserEntity param);
	

}
