package com.java.webproject.main;

import java.util.HashMap;
import java.util.List;

import com.java.webproject.model.MatZipEntity;

public interface MainMapper {

	//메인페이지 맛집리스트 
	List<MatZipEntity> matZipList();
	//맛집리스트 페이징 
	List<MatZipEntity> matZipListPaging (int num);
<<<<<<< HEAD
<<<<<<< HEAD
	
=======
	//디테일창
	MatZipEntity viewDetail(int m_pk);
>>>>>>> jaejin
=======
	
	//디테일창
	MatZipEntity viewDetail(int m_pk);
	
	//조회수 상승 
	void insViewCount(int m_pk);
>>>>>>> jaejin
}
