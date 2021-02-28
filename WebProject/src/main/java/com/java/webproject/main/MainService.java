package com.java.webproject.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webproject.model.MatZipEntity;

@Service
public class MainService {

	@Autowired
	private MainMapper mapper;
	
	public List<MatZipEntity> matZipList(){
		return mapper.matZipList();
	}
}
