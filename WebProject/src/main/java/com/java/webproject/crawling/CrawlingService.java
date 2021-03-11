package com.java.webproject.crawling;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.tomcat.dbcp.dbcp2.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webproject.model.MatZipEntity;

@Service
public class CrawlingService {
	
	@Autowired
	private CrawlingMapper mapper;
	
	
	public void insMatzipList(List<MatZipEntity> list) {
		mapper.insMatzipList(list);
		
	}
	
}
