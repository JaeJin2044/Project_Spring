package com.java.webproject.main;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.webproject.model.LikeEntity;
import com.java.webproject.model.PageVO;
import com.java.webproject.model.MatZipDomain;
import com.java.webproject.model.MatZipEntity;
import com.java.webproject.model.UserEntity;

public interface MainMapper {
	//맛집 검색
	List<MatZipDomain> matZipSearch(PageVO p);
	
	//게시물 총 개수 
	int selMaxPageNum(PageVO p);
	
	//디테일창
	MatZipEntity viewDetail(int m_pk);
	
	//조회수 상승 
	void insViewCount(int m_pk);
	
	//프로필 창 리스트 
	UserEntity selUser(UserEntity param);
	
	//프로필 이미지 등록 
	int updUser(UserEntity p);
	
	//좋아요 리스트
	List<LikeEntity> likeList(@Param("u_pk")int u_pk, @Param("listCount")int listCount);
	
	//좋아요 추가 
	int  insLike(MatZipDomain p);
	
	//맛집 1개찾기(좋아용)
	MatZipDomain selMatzip(MatZipDomain p);
	
	//좋아요 중복확인
	LikeEntity selLike(MatZipDomain p);
	
	//좋아요 리스트 삭제
	int delLike(LikeEntity p);
	
	//회원 탈퇴 
	int delUser(UserEntity p);
	
	
}
