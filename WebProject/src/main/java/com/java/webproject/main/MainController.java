package com.java.webproject.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.examples.ListLinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.webproject.Const;
import com.java.webproject.common.PageUtils;
import com.java.webproject.common.SecurityUtils;
import com.java.webproject.model.LikeEntity;
import com.java.webproject.model.MatZipDTO;
import com.java.webproject.model.MatZipDomain;
import com.java.webproject.model.MatZipEntity;
import com.java.webproject.model.UserEntity;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MainService service;

	@Autowired
	private PageUtils pUtils;

	@Autowired
	private SecurityUtils sUtils;

	@Autowired
	private HttpSession hs;

	// 맛집리스트 출력
	@GetMapping("/home")
	public void getList(Model model,
			@RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page) {
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
		System.out.println("검색어 : " + p.getSearchText());
		System.out.println("결과값의총갯수:" + p.getMaxPageNum());
		model.addAttribute(Const.KEY_LIST, list);
	}

	@GetMapping("/detail")
	public void detail(Model model, @RequestParam("m_pk") int m_pk) {
		MatZipEntity detail_item = service.viewDetail(m_pk);
		model.addAttribute("detail_item", detail_item);

	}

	@GetMapping("/profileEdit")
	public void profileEdit(Model model) throws IOException {

//		if(sUtils.getLoginUserPk(hs) == 0 ) {
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('로그인이 필요한 서비스입니다')");
//			out.println("history.back();");
//			out.println("</script>");
//		}

		System.out.println(sUtils.getLoginUserPk(hs));
		UserEntity param = service.selUser();
		System.out.println("=========================");

		model.addAttribute(Const.KEY_LOGINUSER, param);

	}

	@ResponseBody
	@PostMapping("/profileEdit")
	public int profileEdit(MultipartFile profileImg, HttpSession hs) {
		System.out.println("여기는 프로필이미지 postMapping method");
		System.out.println("fileName : " + profileImg.getOriginalFilename());
		return service.uploadProfile(profileImg, hs);
	}

	@GetMapping("/likeList")
	public void likeList(Model model, HttpSession hs) {
		List<LikeEntity> data = service.likeList(hs);
		if (data != null) {
			model.addAttribute(Const.KEY_LIST, data);
		}
	}

	@GetMapping("/insLike")
	public String insLike(MatZipDomain p) {

		System.out.println("insLike 겟 매핑 ");

		int result = service.insLike(p);
		if (result == 1) {
			return "redirect:/main/likeList";
		} else {
			return "redirect:/main/home";
		}

	}
	
	@GetMapping("/delLike")
	public String delLike(LikeEntity p) {
		
		int result = service.delLike(p);
		
		if(result ==1) {
			return "redirect:/main/likeList";
		}else {
			return "redirect:/main/home";
		}
		
	}
	

}
