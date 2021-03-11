package com.java.webproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String indexPage() {
		return "redirect:/user/login";
	}
	
	@GetMapping("/")
	public String indexPage_() {
		return "redirect:/user/login";
	}

}
