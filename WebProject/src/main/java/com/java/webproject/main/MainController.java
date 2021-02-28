package com.java.webproject.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.webproject.Const;
import com.java.webproject.model.MatZipEntity;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping("/home")
	public void home(Model model) {
		List<MatZipEntity> list = service.matZipList();
		
		model.addAttribute(Const.KEY_LIST, list);
	}
	

	
	
	
	
}
