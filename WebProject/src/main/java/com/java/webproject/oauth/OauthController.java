package com.java.webproject.oauth;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	
	@GetMapping("/naver")
	public String naver(Model model, @RequestParam(required=false) String code, @RequestParam(required=false) String state,
			HttpSession session) throws Exception{
		
		System.out.println("여기는 Navercallback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		
		UserEntity param = oUtils.getNaverUser(oauthToken);

		int result = service.loginCheck(param);
		
		
		//중복된 이메일
		if(result == -1 ) {
			model.addAttribute("err",-1);
			return "redirect:/user/err";
		}else if(result == 0) { // 중복된 연락처 
			model.addAttribute("err",0);
			return "redirect: /user/err";
		}
		
		session.setAttribute(Const.KEY_LOGINUSER, param);
		
		return "redirect:/main/home";
	}
	
	
	
	
	
	
	
}
