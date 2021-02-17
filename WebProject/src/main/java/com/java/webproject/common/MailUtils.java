package com.java.webproject.common;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Component;

import com.java.webproject.model.UserEntity;

@Component
public class MailUtils {

	
	public void sendMail(UserEntity param) {
		System.out.println("여기 sendMail메서드 : "+param.getU_Id());
		System.out.println("여기 sendMail메서드 : "+param.getU_Mail());
		System.out.println("여기 sendMail메서드 : "+param.getU_Pass());
		
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com"; //네이버 이용시 smtp.naver.com/gmail이용시 stmp.gmail.com
		String hostSMTPid = "shzhem764@naver.com";   //서버이메일(보내는사람이메일주소)
		String hostSMTPpwd = "tntlfh1!2@3#";  //서버이메일 비번(보내는 사람 비번)
		
		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "shzhem764@naver.com"; //보내는 사람 이메일주소(받는 사람 이메일에 표시됨)
		String fromName = "이재진";
		String subject = "";
		String msg = "";
		
		
		subject = "임시비밀번호입니다";
		
		
		msg += "안녕하세요 귀하의 임시 비밀 번호는"+param.getU_Pass();
		

		
		String mail = param.getU_Mail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587); //네이버 이용시 587 / 465(혹시몰라서)

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
			System.out.println("메일 전송 완료");
		} catch (Exception e) {
			System.out.println("메일 전송 실패 ");
			e.printStackTrace();
		}
		
		
		
	}
}
