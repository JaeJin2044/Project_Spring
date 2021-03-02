package com.java.webproject.common;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.java.webproject.Const;
import com.java.webproject.model.UserEntity;

@Component
public class SecurityUtils {
	
	public int getLoginUserPk(HttpSession hs) {
		UserEntity loginUser = getLoginUser(hs);
		return loginUser == null ? 0 : loginUser.getU_Pk();
	}
	
	public UserEntity getLoginUser(HttpSession hs) {
		return (UserEntity)hs.getAttribute(Const.KEY_LOGINUSER);
	}
	
	
	public String getSalt() {
		return BCrypt.gensalt();
	}
	
	public String getHashPw(String pw, String salt) {		
		return BCrypt.hashpw(pw, salt);
	}
	
	public static String getPrivateCode(int len) {
		String str = "";
		for (int i = 0; i < len; i++) {
			str += (int)(Math.random() * 10);
		}
		return str;
		
	}
	
	
}
