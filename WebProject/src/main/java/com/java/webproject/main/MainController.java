package com.java.webproject.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.webproject.Const;
import com.java.webproject.common.PageUtils;
import com.java.webproject.model.MatZipEntity;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MainService service;
	
	@Autowired
	private PageUtils pUtils;
	
	
	//맛집리스트 출력
	@GetMapping("/home")
	public void home(Model model) {
		List<MatZipEntity> list = service.matZipList();
		model.addAttribute(Const.KEY_LIST, list);
		
	}
	
	//맛집리스트 출력
	@GetMapping("/listPage")
	public void home(Model model , @RequestParam("pageNum") int pageNum){
		System.out.println();
		int num = (pageNum*20)-20;
		List<MatZipEntity> list = service.matZipListPaging(num);
		list.get(0).getM_img2();
		list.get(0).getM_title();
		model.addAttribute(Const.KEY_LIST, list);
		
	}
	
	@GetMapping("/map")
	public void map(){
		
		
	}
	

	
}
