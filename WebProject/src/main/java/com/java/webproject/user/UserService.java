package com.java.webproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webproject.SecurityUtils;
import com.java.webproject.model.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private SecurityUtils sUtils;
	
	//아이디체크 (중복된아이디가 없으면 1 , 있으면 0)
	public int idCheck(UserEntity param) {
		UserEntity check = mapper.idCheck(param);
		
		//아이디없음
		if(check ==null) {
			return 1;
		}
		//아이디 있음 
		return 0;
		
	}
	
	
	//회원가입 성공시 return값 : 1 , 실패시 0
	public int join(UserEntity param) {
		String u_Salt = sUtils.getSalt(); 
		String HashPass = sUtils.getHashPw(param.getU_Pass(), u_Salt);
		
		param.setU_Salt(u_Salt);
		param.setU_Pass(HashPass);

		return mapper.insUser(param);
	}
}
