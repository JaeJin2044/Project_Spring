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
	
	//댓글 리스트 
	public List<CommentDomain> selCmtList(CommentDomain p) {
		return mapper.selCmtList(p);
	}
	
	//댓글 추가 
	public int insCmt(CommentEntity p) {
		
		if(mapper.insCmt(p)==1) {
			inscomCount(p);
			return 1;
		}else {
			return 0;
		}
		
	}
	
	//댓글 수정
	public int updCmt(CommentEntity p) {
		return mapper.updCmt(p);
	}
	
	//댓글 삭제 
	public int delCmt(CommentEntity p) {
		if(mapper.delCmt(p)==1) {
			mapper.mincomCount(p);
			return 1 ;
		}else {
			return 0 ;
		}
	}
	
	//조회수 상승 
	public int inscomCount(CommentEntity p) {
		return mapper.inscomCount(p);
	}
	
	
	
	
}
