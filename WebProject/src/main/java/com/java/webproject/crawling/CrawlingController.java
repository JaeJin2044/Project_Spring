package com.java.webproject.crawling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crawling")
public class CrawlingController {

	@Autowired
	CrawlingService service;
	
	//데이터 값을 넣기 위한 URL
//	@GetMapping("/insList")
//	public String insList() {
//		System.out.println("ㅎㅇ");
//		try {
//			service.insMatzipList(CrawlingUtils.insMatzipList());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return "redirect:/user/join";
//	}
}
