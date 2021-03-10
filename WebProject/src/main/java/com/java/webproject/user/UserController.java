package com.java.webproject.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.webproject.model.UserEntity;
import com.java.webproject.oauth.KakaoApi;
import com.java.webproject.oauth.NaverLoginBO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// ---- 네이버 로그인 관련 ---
	@Autowired
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	// 카카오 로그인 api
	@Autowired
	private KakaoApi kakaoLoginApi;
	
	@Autowired
	private UserService service;
	
	@Autowired
	private HttpSession session;
	
	
	
	@GetMapping("/login")
	public void login(Model model, HttpSession session) {
		System.out.println("여기는 loginController getMapping");
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		//네이버
		model.addAttribute("url", naverAuthUrl);
		session.setAttribute("url", naverAuthUrl);
		
		//카카오
		String kakaoAuthUrl = kakaoLoginApi.getAuthorizationUrl(session);
		System.out.println("카카오url:"+kakaoAuthUrl);
		model.addAttribute("kakao_url",kakaoAuthUrl);
		session.setAttribute("kakao_url", kakaoAuthUrl);
	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	@GetMapping("/userSearch")
	public void userSearch() {
		
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/user/login";
	}
	
	//로그인 Ajax By재진 
	@ResponseBody
	@PostMapping("/login")
	public Map<String ,Object> login(@RequestBody UserEntity param,HttpSession hs){
		Map<String,Object> returnValue = new HashMap<String, Object>();
		returnValue.put("result",service.loginCheck(param,hs));
		
		return returnValue;
	}

	//아이디 중복확인 By재진
	@ResponseBody
	@GetMapping("/chkId/{u_Id}")
	public Map<String,Object> chkId(UserEntity param){
		System.out.println("아이디 확인 : "+param.getU_Id());
		Map<String,Object> returnValue = new HashMap<String, Object>();
		returnValue.put("result", service.idCheck(param));
		
		return returnValue;
	}
	
	//회원가입 Ajax By재진
	@ResponseBody
	@PostMapping("/join")
	public Map<String,Object> join(@RequestBody UserEntity param){
		Map<String,Object> returnValue = new HashMap<String, Object>();
		
		returnValue.put("result", service.join(param)); 
		return returnValue;
	}
	
	
	//아이디 찾기 Ajax By재진
	@ResponseBody
	@PostMapping("/findId")
	public Map<String ,Object> findId(@RequestBody UserEntity param){
		Map<String,Object> returnValue = new HashMap<String, Object>();
		returnValue.put("result",service.findId(param));
		
		return returnValue;
	}
	
	//비밀번호 찾기 
	@ResponseBody
	@PostMapping("/findPw")
	public Map<String,Object> findPw(@RequestBody UserEntity param){
		
		Map<String, Object> returnValue = new HashMap<String, Object>();
		returnValue.put("result",service.findPw(param));
		return returnValue;
	}
	
	//비밀번호 변경
	@ResponseBody
	@PostMapping("/passChange")
	public Map<String,Object> passChange(@RequestBody UserEntity param){
		System.out.println("비밀번호 변경 method u_Id ="+param.getU_Id());
		System.out.println("비밀번호 변경 method u_Pass ="+param.getU_Pass());
		Map<String, Object> returnValue = new HashMap<String, Object>();
		returnValue.put("result", service.passChange(param));
		return returnValue;
	}
	
	
	//프로필 수정 
	@ResponseBody
	@PostMapping("/editUser")
	public Map<String,Object> editUser(@RequestBody UserEntity param){
		System.out.println("받은 유저 pk = "+param.getU_Pk());
		System.out.println("받은 휴대폰 번호 ="+param.getU_Phone());
		System.out.println("받은 메일  ="+param.getU_Mail());
		Map<String, Object> returnValue = new HashMap<String, Object>();
		returnValue.put("result", service.editUser(param));
		
		return returnValue;
	
	}
	
}
