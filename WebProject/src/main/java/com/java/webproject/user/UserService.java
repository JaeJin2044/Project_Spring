package com.java.webproject.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webproject.Const;
import com.java.webproject.common.SecurityUtils;
import com.java.webproject.model.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private SecurityUtils sUtils;
	
	
	//로그인체크(1:로그인 성공, 2:아이디 없음, 3:비밀번호가 틀림)
	public int loginCheck(UserEntity param, HttpSession hs) {
		UserEntity dbData = mapper.idCheck(param);
		
		
		if(dbData == null) {
			return 2;
		}
		String salt = dbData.getU_Salt();
		String tempPw = sUtils.getHashPw(param.getU_Pass(), salt);
	
		if(!tempPw.equals(dbData.getU_Pass())) {
			return 3; 
		}
		
		
		hs.setAttribute(Const.KEY_LOGINUSER,dbData);
		return 1;
	}
	
	
	//중복아이디체크 (중복된아이디가 없으면 1 , 있으면 0)
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
	
	//아이디 찾기 (정보가 틀리면 : 0 , 정확히 입력하면 1)
	public UserEntity findId(UserEntity param) {
		
		UserEntity dbData = mapper.findId(param);
		
		if(dbData == null) {
			return null;
		}
		return dbData;
	}
	
	//비밀번호 찾기(등록되지 않은 아이디 -1, 등록되지 않은 이메일 0 ,정상적으로 메일발송 1)
	public int findPw(UserEntity param) {
		UserEntity ck = mapper.idCheck(param);
		
		if(ck == null) {
			System.out.println("등록되지 않은 아이디입니다.");
			return -1;
		}else if(!ck.getU_Mail().equals(param.getU_Mail())) {
			System.out.println("등록되지 않은 이메일 입니다.");
			return 0;
		}
		
		String email = ck.getU_Mail();
		System.out.println("당신의 이메일? "+email);
		
		//난수 생성 (임시비밀번호)
		String code = sUtils.getPrivateCode(10);
		
		//임시비밀번호로 비밀번호 변경 
		param.setU_Pass(code);
		mapper.changePw(param);
		
		//임시비밀번호를 해당 이메일에 발송 
		
		return 1;
	}
	
	
	
	
	
	
	
}
