package com.java.webproject.cmt;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.webproject.common.SecurityUtils;
import com.java.webproject.model.CommentDomain;
import com.java.webproject.model.CommentEntity;

@RestController
@RequestMapping("/cmt")
public class CmtController {
	
	@Autowired
	private CmtService service;
	
	@Autowired
	private SecurityUtils sUtils;
	
	//댓글 리스트
	@GetMapping
	public List<CommentDomain> list(CommentDomain p, @RequestParam("listCount") int listCount){
		p.setListCount(listCount);
		List<CommentDomain> data = service.selCmtList(p);
		return data;
	}
	
	//댓글 작성
	@PostMapping
	public int ins(@RequestBody CommentEntity p , HttpSession hs) {
		p.setU_pk(sUtils.getLoginUserPk(hs));
	
		return service.insCmt(p);
	}
	
	//댓글 수정
	@PutMapping
	public int upd(@RequestBody CommentEntity p, HttpSession hs) {
		p.setU_pk(sUtils.getLoginUserPk(hs));
		return service.updCmt(p);
	}
	
	//댓글 삭제 
	@DeleteMapping
	public int del(CommentEntity p, HttpSession hs) {	
		p.setU_pk(sUtils.getLoginUserPk(hs));
		return service.delCmt(p);
	}
	
	
	
	
	
	
}
