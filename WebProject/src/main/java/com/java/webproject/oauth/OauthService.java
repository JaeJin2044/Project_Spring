package com.java.webproject.oauth;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webproject.Const;
import com.java.webproject.model.UserEntity;

@Service
public class OauthService {

	@Autowired
	OauthMapper mapper;
	@Autowired
	HttpSession session;
	
	//네이버 로그인 체크 (로그인 ok:2 , 회원가입성공 1)
	public int loginCheck(UserEntity param) {
		int result = 0;
		
		UserEntity dbData = mapper.loginCheck(param);
		
		//회원가입
		if(dbData ==null) {
			return insUser(param);
		}
		
		return 2;
	}
	
	
	
	
	//네이버유저 회원가입 &중복 이메일,연락처 체크  (중복된 이메일 : -1 , 중복된 연락처 : 0 , 회원가입 성공 :1)
	public int insUser(UserEntity param) {
		int result = 0 ;
		UserEntity mail = mapper.mailCheck(param);
		UserEntity phone = mapper.phoneCheck(param);
		
		if(mail != null) {
			return -1;
		}else if(phone !=null) {
			return 0;
		}
		
		return mapper.insUser(param);
	}
	
	
	
	
	
}
