package com.java.webproject.main;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webproject.model.MatZipEntity;

@Service
public class MainService {

	@Autowired
	private MainMapper mapper;
	
	//맛집 리스트 출력 
	public List<MatZipEntity> matZipList(){
		return mapper.matZipList();
		
	}
	
	//
	public List<MatZipEntity> matZipListPaging(int num){
		
		return mapper.matZipListPaging(num);
	}
	
	
	
	
	
	
}
