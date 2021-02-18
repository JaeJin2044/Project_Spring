package com.java.webproject.common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.java.webproject.model.UserEntity;
import com.java.webproject.oauth.NaverLoginBO;

@Component
public class OauthUtils {
	@Autowired
	NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	//네이버 
	public UserEntity getNaverUser(OAuth2AccessToken oauthToken) throws Exception  {
		System.out.println("getJsonObject");
		System.out.println(oauthToken);
		//1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); //String형식의 json데이터
		/** apiResult json 구조
		{"resultcode":"00",
		"message":"success",
		"response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		**/
		System.out.println(apiResult);
		
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		
		System.out.println("obj = "+obj);
		System.out.println("jsonObj= "+jsonObj);
		
		//3. 데이터 파싱 
		
		//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		//response의 nickname값 파싱
		String name = (String)response_obj.get("name");
		String id = (String)response_obj.get("id");
		String gender = (String)response_obj.get("gender");
		String mail = (String)response_obj.get("email");
		String LogType = mail.substring(mail.indexOf("@")+1, mail.indexOf("."));
		String tmp_mobile = (String)response_obj.get("mobile");
		String mobile = tmp_mobile.replace("-", "");
		
		
		System.out.println("response_obj"+response_obj);
		System.out.println("id ="+id);
		System.out.println("email ="+mail);
		System.out.println("name ="+name);
		System.out.println("mobile ="+mobile);
		System.out.println("gender ="+gender);
		System.out.println("LogType ="+LogType);
		
		UserEntity param = new UserEntity();
		param.setU_Id(id);
		param.setU_Mail(mail);
		param.setU_Nm(name);
		param.setU_Phone(mobile);
		param.setU_Gender(gender);
		param.setU_LogType(LogType);
		
		return param;
	}

}
