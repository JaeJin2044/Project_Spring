package com.java.webproject.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.webproject.Const;
import com.java.webproject.common.SecurityUtils;
import com.java.webproject.model.CommentDomain;
import com.java.webproject.model.LikeEntity;
import com.java.webproject.model.PageVO;
import com.java.webproject.model.MatZipDomain;
import com.java.webproject.model.MatZipEntity;
import com.java.webproject.model.UserEntity;


@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MainService service;

	@Autowired
	private SecurityUtils sUtils;

	@Autowired
	private HttpSession hs;

	// 맛집리스트 출력
	@GetMapping("/home")
	public void getList(Model model,
			@RequestParam(value = "searchText", required = false, defaultValue = "") String searchText,
			@RequestParam(value = "page", defaultValue = "1", required = false) String page,
			@RequestParam(value = "m_category", defaultValue = "0", required = false) int m_category) {
		if (page == null) {
			page = "1";
		}
		
		PageVO p = new PageVO(searchText, Integer.parseInt(page), 10, m_category);
		p.setMaxPageNum(service.selMaxPageNum(p));
		
		p.dataCalc();
		

		List<MatZipDomain> list = service.matZipSearch(p);
		model.addAttribute("page", p);
		model.addAttribute(Const.KEY_LIST, list);
	}

	//디테일 페이지 리스트
	@GetMapping("/detail")
	public void detail(Model model, @RequestParam("m_pk") int m_pk) {
		MatZipEntity detail_item = service.viewDetail(m_pk);
		model.addAttribute("detail_item", detail_item);

	}
	
	
	//프로필창 로그인유저 체크 
	@GetMapping("/checkProfile")
	public String checkProfile() {	
		if(sUtils.getLoginUserPk(hs)==0) {
			return "redirect:/err/wantLogin";
		}else {
			return "redirect:/main/profileEdit";
		}
	}
	

	//프로필 수정창
	@GetMapping("/profileEdit")
	public void profileEdit(Model model) throws IOException {
		UserEntity param = service.selUser();
		model.addAttribute(Const.KEY_LOGINUSER, param);

	}

	//프로필 이미지 
	@ResponseBody
	@PostMapping("/profileEdit")
	public int profileEdit(MultipartFile profileImg, HttpSession hs) {
		return service.uploadProfile(profileImg, hs);
	}

	
	//좋아요 리스트(로그인 유저 구분) 
	@GetMapping("/checkUser")
	public String checkLike() {
		
		if(sUtils.getLoginUserPk(hs)==0) {
			return "redirect:/err/wantLogin";
		}else {
			return "redirect:/main/likeList";
		}
	}
	
	
	@GetMapping("/likeList")
	public void likeList() {}
	
	@ResponseBody
	@GetMapping
	public List<LikeEntity> list(Model model, HttpSession hs, @RequestParam("listCount") int listCount){
		List<LikeEntity> returnValue = service.likeList(hs,listCount);	
		return returnValue;
	} 
	
	
	//회원 삭제 
	@GetMapping("/delUser")
	public String profileEdit(UserEntity p) {
		int result = service.delUser(p);
		if(result == 1) {
			hs.invalidate();
			return "redirect: /err/userDel";
		}else {
			return "redirect: /err/failDelUser";
		}	
	}
	

	@GetMapping("/insLike")
	public String insLike(MatZipDomain p, HttpServletResponse response) throws IOException {

		if(sUtils.getLoginUserPk(hs)==0) {
			return "redirect:/err/wantLogin";
		}

		int result = service.insLike(p);
		if (result == 1) {
			return "redirect:/main/likeList";
		} else {
			return "redirect:/err/insLikeError";
		}

	}

	@GetMapping("/delLike")
	public String delLike(LikeEntity p) {

		int result = service.delLike(p);

		if (result == 1) {
			return "redirect:/main/likeList";
		} else {
			return "redirect:/main/home";
		}

	}

	@GetMapping("/insLikeError")
	public void insLikeError() {

	}
	
	//비밀번호 변경
	@GetMapping("/passChange")
	public void passChange() {
		
	}
	
	
	

}
