package com.java.webproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/err")
public class ErrorController {
	
	@GetMapping("/insLikeError")
	public void insLikeError() {
		System.out.println("err insLike");
	}
	
	@GetMapping("/userDel")
	public void userDel() {
		
	}
	@GetMapping("/failDelUser")
	public void failDelUser() {
		
	}
	@GetMapping("/wantLogin")
	public void wantLogin() {
		
	}
	@GetMapping("/sameEmail")
	public void sameEmail() {
		System.out.println("sameEamil");
		
	}
	@GetMapping("/samePhone")
	public void samePhone() {
		
	}
	
	
		
	
	

}
