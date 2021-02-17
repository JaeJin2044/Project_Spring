package com.java.webproject.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.webproject.model.UserEntity;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	@GetMapping("/userSearch")
	public void userSearch() {
		
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
	
	
	
	
	
}
