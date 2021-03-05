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
import com.java.webproject.model.MatZipDTO;
import com.java.webproject.model.MatZipDomain;
import com.java.webproject.model.MatZipEntity;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MainService service;
	
	@Autowired
	private PageUtils pUtils;

	
	// 맛집리스트 출력
	@GetMapping("/home")
	public void getList(Model model, @RequestParam(value = "searchText", required = false, defaultValue="")String searchText 
			,@RequestParam(value = "page", defaultValue = "1", required = false)int page) {		
		MatZipDTO p = new MatZipDTO();
		
		p.setPage(page);		
		p.setRowCnt(10);
		int rowCnt = p.getRowCnt();
		p.setsIdx((page - 1) * rowCnt);
		p.setSearchText(searchText);
		p.setMaxPageNum(service.selMaxPageNum(p));
		p.setTotalPage(p.getMaxPageNum() / rowCnt);		
		int totalPage = p.getTotalPage();
		model.addAttribute("page", p);
		List<MatZipDomain> list = service.matZipSearch(p);		
		
		System.out.println("페이지수 : " + totalPage);
		System.out.println("검색어 : " +  p.getSearchText());
		System.out.println("결과값의총갯수:" + p.getMaxPageNum()); 
		model.addAttribute(Const.KEY_LIST, list);	
	}

	
	@GetMapping("/detail")
	public void detail(Model model,@RequestParam("m_pk") int m_pk) {
		MatZipEntity detail_item = service.viewDetail(m_pk);
		model.addAttribute("detail_item", detail_item);
		
	}
	
	

	
}
