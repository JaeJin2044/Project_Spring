package com.java.webproject.crawling;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.java.webproject.model.MatZipEntity;

@Component
public class CrawlingUtils {
	
	
	//디테일창으로 가는 쿼리스트링 String이중배열로 넘어감
	public static String[][] getDetailString() throws Exception {
		
		//망고플레이트 페이지 수(i의값 20페이지) 
		final String URL = "https://www.mangoplate.com/search/"
				+ "%EB%8C%80%EA%B5%AC%EB%A7%9B%EC%A7%91?keyword=%EB%8C%80%EA%B5%AC%EB%A7%9B%EC%A7%91&page=";
		String[][] matZipString = new String[10][20];

		for (int i = 1; i <= 10; i++) {

			Document doc = Jsoup.connect(URL + i).get();

			Elements list = doc.select("div.info a");
			int j = 0;
			for (Element e : list) {
				matZipString[i - 1][j] = e.attr("href").substring(13);
				j++;
			}
		}
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 20; j++) {

			}
		}
		return matZipString;		
	}
	
	
	
	public static List<MatZipEntity> insMatzipList() throws Exception{

		//페이지 URL 
		String PageUrl = "https://www.mangoplate.com/search/%EB%8C%80%EA%B5%AC%EB%A7%9B%EC%A7%91?keyword=%EB%8C%80%EA%B5%AC%EB%A7%9B%EC%A7%91&page=";
		String detailUrl = "https://www.mangoplate.com/restaurants/";
		//리턴할 맛집리스트(top200)
		List<MatZipEntity> matzipList = new ArrayList<>();
		
		String[][] matZipString = getDetailString();
		
		
		for (int i = 1; i <= 10; i++) {
			
			
			//페이지에 i값을 더해줌(10페이지)
			Document PageDoc = Jsoup.connect(PageUrl+i).get();
			System.out.println("에러페이지= "+i);
			
		
			
			for (int j = 0; j < 20; j++) {
				//객체 생성 
				MatZipEntity matzipEntity = new MatZipEntity();
				
				Elements parseTitle = PageDoc.select("h2.title");
				Elements parseCategory = PageDoc.select("p.etc");
				Elements parseStarPoint = PageDoc.select("strong");
				
				
				String title = parseTitle.get(j).text();
				String viewDetail =parseCategory.get(j).text();
				String starPoint = parseStarPoint.get(j).text();
				String location_ = viewDetail.substring(3);
				
				String location = "";
				
				int index_num = location_.indexOf("구");
				
				if(index_num == 1 ) {
					location = location_.substring(0,index_num);
				}
				location = location_.substring(0,index_num+1);
				
				
				matzipEntity.setM_title(title);
				matzipEntity.setM_viewDetail(viewDetail);
				
				if(starPoint != null && starPoint.length() > 0) {
					matzipEntity.setM_starPoint(Float.parseFloat(starPoint));
				}else {
					matzipEntity.setM_starPoint(0);
				}
				
				matzipEntity.setM_location(location);
				matzipEntity.setM_category("한식");	
				
				System.out.println("title ="+title);
				System.out.println("viewDetail ="+viewDetail);
				System.out.println("starPoint ="+starPoint);
				System.out.println("location ="+location);
				System.out.println("category ="+"한식");
			
				System.out.println("=============================");
				System.out.println("이제부터 디테일 확인 ");
				System.out.println("===============================");
				
				
				
				//디테일 url추출
				Document detailDoc = Jsoup.connect(detailUrl+matZipString[i-1][j]).get();
				
				
				//디테일 이미지 추출
				Elements parseDetailImg = detailDoc.select("img.center-croping[src]");
				matzipEntity.setM_img1(parseDetailImg.get(0).attr("src"));
				matzipEntity.setM_img2(parseDetailImg.get(1).attr("src"));
				matzipEntity.setM_img3(parseDetailImg.get(2).attr("src"));
				matzipEntity.setM_img4(parseDetailImg.get(3).attr("src"));
				
				System.out.println("img1 ="+parseDetailImg.get(0).attr("src"));
				System.out.println("img2 ="+parseDetailImg.get(1).attr("src"));
				System.out.println("img3 ="+parseDetailImg.get(2).attr("src"));
				System.out.println("img4 ="+parseDetailImg.get(3).attr("src"));
				
				
				
				//디테일 정보 추출 
				Elements parseDetailInfo = detailDoc.select("tbody td");
				String addrTotal;
				String addrRoad;
				String addrJibun;
				String phone;
				String foodType;
				String price;
				String parking;
				String workingTime;
				
				if(title.equals("베이크드인스테인")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("운봉선")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("뉴살라딘")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("괜스레")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("라르고카페")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("노스텔지아커피")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("뉴살라딘 (동성로점)")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("인천상륙작전조개구이")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("오이시민")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("Iwlt")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("비움")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("이자카야 제이비")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("대장부 (송현점)")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("버건디")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("살와레스토랑")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("수성이야 쭈꾸미")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("88꼼")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("게스트")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("호롱커피")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("스노우피")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("아워아워스")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("하우웰")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("노킹온헤븐스도어")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("고운곰탕")) {
					matzipList.add(matzipEntity);
					continue;
				}else if(title.equals("퇴근길생고기")) {
					matzipList.add(matzipEntity);
					continue;
				}
				
				addrTotal = parseDetailInfo.get(0).text();
				int int1 = addrTotal.indexOf("지번");
				addrRoad = addrTotal.substring(0,int1-1);
				addrJibun = addrTotal.substring(int1+3, addrTotal.length());
		
				phone = parseDetailInfo.get(1).text();
				foodType  = parseDetailInfo.get(2).text();
				
				price = parseDetailInfo.get(3).text();
				parking = parseDetailInfo.get(4).text();
				workingTime = parseDetailInfo.get(5).text();
				
				matzipEntity.setM_addrJibun(addrJibun);
				matzipEntity.setM_addrRoad(addrRoad);
				matzipEntity.setM_phone(phone);
				matzipEntity.setM_foodType(foodType);
				matzipEntity.setM_price(price);
				matzipEntity.setM_parking(parking);
				matzipEntity.setM_workingTime(workingTime);
				
				
				System.out.println("도로명 ="+addrRoad);
				System.out.println("지번 ="+addrJibun);
				System.out.println("phone="+phone);
				System.out.println("foodType="+foodType);
				System.out.println("price="+price);
				System.out.println("parking="+parking);
				System.out.println("workingTime="+workingTime);
				
				System.out.println("=================디테일 끝 ======================  페이지="+i+" 가게="+j);
			
				matzipList.add(matzipEntity);
		
			}
			
			
		}
//		CrawlingService service = new CrawlingService();
//		service.insMatzipList(matzipList);
		return matzipList;
	}
	

}
