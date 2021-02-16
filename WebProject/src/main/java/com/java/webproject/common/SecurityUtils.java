package com.java.webproject.common;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {
	
	
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
