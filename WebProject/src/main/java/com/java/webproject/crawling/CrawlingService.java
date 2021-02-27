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
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★여기 service페이지 ");
	
		System.out.println("넘어온 list 사이즈 = "+list.size());
//		
//		System.out.println(list.get(0).getM_parking());
//		System.out.println(list.get(9).getM_parking());
//		System.out.println(list.get(11).getM_parking());
//		System.out.println(list.get(19).getM_parking());
//		
//		System.out.println(list.get(19).getM_title());
//		
//		System.out.println("===================");
//		System.out.println(list.get(0).getM_workingTime());
//		System.out.println(list.get(9).getM_workingTime());
//		System.out.println(list.get(15).getM_workingTime());
//		System.out.println(list.get(11).getM_workingTime());
//		System.out.println(list.get(12).getM_workingTime());
//		System.out.println(list.get(14).getM_workingTime());
//		System.out.println(list.get(19).getM_img3());
		mapper.insMatzipList(list);
		
	}
	
}
