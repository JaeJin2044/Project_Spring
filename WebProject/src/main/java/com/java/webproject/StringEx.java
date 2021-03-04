package com.java.webproject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class StringEx {

	public static void main(String[] args) throws Exception {
		
//		String URL = "https://fatc.club/2017/02/28/60";
//		Document doc = Jsoup.connect(URL).get();
//		Elements elem = doc.select("section"); 
//		String str = elem.text(); 
//		System.out.println("하이");
//		System.out.println(str);
		
		//망고 플레이트 1페이지 
		String connUrl = "https://www.mangoplate.com/search/%EB%8C%80%EA%B5%AC%20%EB%A7%9B%EC%A7%91?keyword=%EB%8C%80%EA%B5%AC%20%EB%A7%9B%EC%A7%91&page=1";
		// 2. HTML 가져오기
		Document doc = Jsoup.connect(connUrl).get(); 
		// 3. 가져온 HTML 
		System.out.println(doc.toString());
		
		

		

		
	}

}
