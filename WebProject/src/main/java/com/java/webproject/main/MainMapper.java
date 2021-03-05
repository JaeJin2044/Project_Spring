package com.java.webproject.main;

import java.util.List;

import com.java.webproject.model.MatZipDTO;
import com.java.webproject.model.MatZipDomain;
import com.java.webproject.model.MatZipEntity;

public interface MainMapper {

	List<MatZipDomain> matZipSearch(MatZipDTO p);
	int selMaxPageNum(MatZipDTO p);
	
	//디테일창
	MatZipEntity viewDetail(int m_pk);
	//조회수 상승 
	void insViewCount(int m_pk);
	
	
}
