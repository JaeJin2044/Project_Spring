package com.java.webproject.main;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.java.webproject.common.FileUtils;
import com.java.webproject.common.SecurityUtils;
import com.java.webproject.model.LikeEntity;
import com.java.webproject.model.MatZipDTO;
import com.java.webproject.model.MatZipDomain;
import com.java.webproject.model.MatZipEntity;
import com.java.webproject.model.UserEntity;

@Service
public class MainService {

	@Autowired
	private MainMapper mapper;
	@Autowired
	private HttpSession hs;
	@Autowired
	private SecurityUtils sUtils;
	@Autowired
	private FileUtils fUtils;
	
	
	//맛집 리스트 출력
	public int selMaxPageNum(MatZipDTO p) {
		return mapper.selMaxPageNum(p);
	}	
	public List<MatZipDomain> matZipSearch(MatZipDTO p){
		return mapper.matZipSearch(p);
	}
	
	
	
	//디테일창 리스트 
	public MatZipEntity viewDetail(int m_pk) {
		
		if(sUtils.getLoginUserPk(hs) > 0) {
			plusViewCount(m_pk);
		}
		return mapper.viewDetail(m_pk);
	}
	
	
	//조회수 상승
	public void plusViewCount(int m_pk) {
		mapper.insViewCount(m_pk);
	}
	
	//프로필 수정창 리스트
	public UserEntity selUser() {
		UserEntity userInfo = new UserEntity();
		userInfo.setU_Pk(sUtils.getLoginUserPk(hs));
		return mapper.selUser(userInfo);
	}
	
	//프로필 이미지 변경
	public int uploadProfile(MultipartFile mf, HttpSession hs) {
		int userPk = sUtils.getLoginUserPk(hs);
		if(userPk == 0 || mf == null) { //로그인이 안 되어 있는 경우, 파일이 없는 경우
			return 0;
		}
		String folder = "/resources/image/user/" + userPk;		
		System.out.println("folder name = "+folder);
		String profileImg = fUtils.transferTo(mf, folder);
		System.out.println("profileImg = "+profileImg);
		if(profileImg == null) { //파일 생성 실패
			return 0;
		}
		
		UserEntity p = new UserEntity();
		p.setU_Pk(userPk);
		
		//기존이미지가 존재했다면 이미지 삭제!
		UserEntity userInfo = mapper.selUser(p);
		if(userInfo.getU_profile() != null) {
			String basePath = fUtils.getBasePath(folder); 
			File file = new File(basePath, userInfo.getU_profile());
			System.out.println("basePath = "+basePath);
			System.out.println("file = "+file);
			if(file.exists()) {
				file.delete();
			}
		}
				
		System.out.println("set 과정 profileImg= "+profileImg);
		p.setU_profile(profileImg);
		return mapper.updUser(p);
	}
	
	//좋아요 리스트 
	public List<LikeEntity> likeList(HttpSession hs) {
		if(sUtils.getLoginUserPk(hs) == 0) {
			System.out.println("로그인이 필요합니다.");
			return null;
		}
		
		return mapper.likeList(sUtils.getLoginUserPk(hs));
	}
	
	public int insLike(MatZipDomain p) {

		MatZipDomain data = mapper.selMatzip(p);
		
		data.setU_pk(sUtils.getLoginUserPk(hs));
		
		LikeEntity tempData = mapper.selLike(data);
	
		if(tempData != null) {
			System.out.println("중복된 데이터가 있습니다.");
			return 0 ;
		}
		return mapper.insLike(data);
		
	}
	
	// 좋아요 목록 삭제 
	
	public int delLike(LikeEntity p ) {
		
		int result = mapper.delLike(p);
		
		if(result == 1 ) {
			System.out.println("삭제 성공");
			return 1;
		}else {
			System.out.println("삭제 실패 ");
			return 0;
		}
	}
	
	
	
	
	
}
