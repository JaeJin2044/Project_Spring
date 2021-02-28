package com.java.webproject.main;

import java.util.List;

import com.java.webproject.model.MatZipEntity;

public interface MainMapper {

	//메인페이지 맛집리스트 
	List<MatZipEntity> matZipList();
}
