package com.java.webproject.main;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.java.webproject.common.OauthUtils;
import com.java.webproject.model.UserEntity;
import com.java.webproject.oauth.NaverLoginBO;

@Controller
@RequestMapping("/main")
public class MainController {

	@GetMapping("/home")
	public void home() {
		
	}
	

	
	
	
	
}
