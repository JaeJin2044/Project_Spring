package com.java.webproject.oauth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.java.webproject.Const;
import com.java.webproject.common.OauthUtils;
import com.java.webproject.model.UserEntity;

@Controller
@RequestMapping("/oauth")
public class OauthController {
	
	@Autowired
	private NaverLoginBO naverLoginBO;
	
	@Autowired
	private OauthUtils oUtils;
	
	@Autowired
	private OauthService service;
	
	
	@GetMapping("/kakao")
	public String kakao(@RequestParam("code") String code, HttpServletRequest request,
			HttpSession session,Model model,HttpServletResponse response) throws Exception {
		System.out.println("kakao맵핑");
		//결과 값을 node에 담아준다.
		JsonNode node = KakaoApi.getAccessToken(code);
		//accessToken에 사용자 로그인 정보가 존재함
		JsonNode accessToken = node.get("access_token");
		
		//사용자 정보
		JsonNode userInfo = KakaoApi.getKakaoUserInfo(accessToken);
		System.out.println(userInfo);
		
		String kemail = null;
		String kname = null;
		String kgender = null;
		String kbirthday = null;
		String kage = null;
		String kimage = null;
		
		JsonNode properties = userInfo.path("properties");
		JsonNode kakao_account = userInfo.path("kakao_account");
	
		JsonNode kId = userInfo.path("id");
		String kid = kId.asText();
		
		System.out.println("kid = "+kid);
		kemail = kakao_account.path("email").asText();
		kname = properties.path("nickname").asText();
		kimage = properties.path("profile_image").asText();
		kgender = kakao_account.path("gender").asText();
		kbirthday = kakao_account.path("birthday").asText();
		kage = kakao_account.path("age_range").asText();
		
		UserEntity param = new UserEntity();
		param.setU_id(kid);
		param.setU_nm(kname);
		param.setU_logType("kakao");
		
		int result = service.loginCheck(param,session); 
		
		return "redirect:/main/home";
	}
	
	
	@GetMapping("/naver")
	public String naver(Model model, @RequestParam(required=false) String code, @RequestParam(required=false) String state,
			HttpSession session) throws Exception{
		
		System.out.println("여기는 Navercallback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		
		UserEntity param = oUtils.getNaverUser(oauthToken);
		int result = service.loginCheck(param,session);

		//중복된 이메일
		if(result == -1 ) {
			return "redirect:/err/sameEmail";
		}else if(result == 0) { // 중복된 연락처 
			
			return "redirect: /err/samePhone";
		}
		
		return "redirect:/main/home";
	}
	
	
	
	
	
	
	
}
