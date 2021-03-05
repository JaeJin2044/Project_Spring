package com.java.webproject.cmt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.webproject.model.CommentDomain;
import com.java.webproject.model.CommentEntity;

@Mapper
public interface CmtMapper {
	int insCmt(CommentEntity p);
	List<CommentDomain> selCmtList(CommentDomain p);
	int updCmt(CommentEntity p);
	int delCmt(CommentEntity p);
	int inscomCount(CommentEntity p);
	int mincomCount(CommentEntity p);
}
