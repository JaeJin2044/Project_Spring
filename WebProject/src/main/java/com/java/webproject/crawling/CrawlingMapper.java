package com.java.webproject.crawling;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.webproject.model.MatZipEntity;

@Mapper
public interface CrawlingMapper {

	void insMatzipList(List<MatZipEntity> list);
	void test(String name);
	
}
