package com.java.webproject.cmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webproject.model.CommentDomain;
import com.java.webproject.model.CommentEntity;

@Service
public class CmtService {

	@Autowired
	public CmtMapper mapper;
	
	public List<CommentDomain> selCmtList(CommentDomain p) {
		return mapper.selCmtList(p);
	}
	
	public int insCmt(CommentEntity p) {
		return mapper.insCmt(p);
	}
	
	public int updCmt(CommentEntity p) {
		return mapper.updCmt(p);
	}
	
	public int delCmt(CommentEntity p) {
		return mapper.delCmt(p);
	}
	
	
	
	
}
