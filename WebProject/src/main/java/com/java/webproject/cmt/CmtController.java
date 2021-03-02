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
	
	@GetMapping
	public List<CommentDomain> list(CommentDomain p){
		List<CommentDomain> data = service.selCmtList(p);
		System.out.println(data.get(0).getC_regDate());
		return data;
	}
	
	@PostMapping
	public int ins(@RequestBody CommentEntity p , HttpSession hs) {
		p.setU_pk(sUtils.getLoginUserPk(hs));
		return service.insCmt(p);
	}
	
	@PutMapping
	public int upd(@RequestBody CommentEntity p, HttpSession hs) {
		System.out.println("m_pk : " + p.getM_pk());
		System.out.println("c_seq : " + p.getC_seq());		
		System.out.println("c_content : " + p.getC_content());
		p.setU_pk(sUtils.getLoginUserPk(hs));
		return service.updCmt(p);
	}
	@DeleteMapping
	public int del(CommentEntity p, HttpSession hs) {
		System.out.println("m_pk : " + p.getM_pk());
		System.out.println("c_seq : " + p.getC_seq());		
		p.setU_pk(sUtils.getLoginUserPk(hs));
		return service.delCmt(p);
	}
	
	
	
	
	
	
}
