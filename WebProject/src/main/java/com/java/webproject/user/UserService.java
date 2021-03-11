package com.java.webproject.user;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webproject.Const;
import com.java.webproject.common.MailUtils;
import com.java.webproject.common.SecurityUtils;
import com.java.webproject.model.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private SecurityUtils sUtils;

	@Autowired
	private MailUtils mUtils;

	// 로그인체크(1:로그인 성공, 2:아이디 없음, 3:비밀번호가 틀림)
	public int loginCheck(UserEntity param, HttpSession hs) {
		UserEntity dbData = mapper.idCheck(param);

		// 아이디 확인
		if (dbData == null) {
			return 2;
		}

		String salt = dbData.getU_salt();
		if (salt == null) {
			return 3;
		}

		String tempPw = sUtils.getHashPw(param.getU_pass(), salt);

		// 비밀번호 확인
		if (!tempPw.equals(dbData.getU_pass())) {

			return 3;
		}

		hs.setAttribute(Const.KEY_LOGINUSER, dbData);
		return 1;
	}

	// 중복아이디체크 (중복된아이디가 없으면 1 , 있으면 0)
	public int idCheck(UserEntity param) {
		UserEntity check = mapper.idCheck(param);

		// 아이디없음
		if (check == null) {
			return 1;
		}
		// 아이디 있음
		return 0;
	}

	// 회원가입 성공시 return값 : 1 , 실패 : 이메일 존재시 2 , 연락처 존재 시 3
	public int join(UserEntity param) {
		String u_Salt = sUtils.getSalt();
		String HashPass = sUtils.getHashPw(param.getU_pass(), u_Salt);

		param.setU_salt(u_Salt);
		param.setU_pass(HashPass);

		UserEntity dbData = mapper.joinCheck(param);

		if (dbData == null) {
			return mapper.insUser(param);
		} else if (dbData.getU_mail().equals(param.getU_mail())) {
			return 2;
		} else {
			return 3;
		}

	}

	// 아이디 찾기 (정보가 틀리면 : 0 , 정확히 입력하면 1)
	public UserEntity findId(UserEntity param) {

		UserEntity dbData = mapper.findId(param);

		if (dbData == null) {
			return null;
		}
		
		return dbData;
	}

	// 비밀번호 찾기(등록되지 않은 아이디 -1, 등록되지 않은 이메일 0 ,정상적으로 메일발송 1)
	public int findPw(UserEntity param) {
		UserEntity ck = mapper.idCheck(param);

		if (ck == null) {
			System.out.println("등록되지 않은 아이디입니다.");
			return -1;
		} else if (!ck.getU_mail().equals(param.getU_mail())) {
			System.out.println("등록되지 않은 이메일 입니다.");
			return 0;
		}

		// 난수 생성 (임시비밀번호)
		String code = sUtils.getPrivateCode(10);

		// 비밀번호 변경(솔트값사용해서 임시비밀번호를 암호화)
		String salt = ck.getU_salt();
		String tempPw = sUtils.getHashPw(code, salt);
		ck.setU_pass(tempPw);
		mapper.changePw(ck);

		// 유저가 보는 임시비밀번호로 설정후 해당 이메일 발송
		ck.setU_pass(code);
		mUtils.sendMail(ck);

		return 1;
	}

	// 비밀번호 변경
	public int passChange(UserEntity param) {
		UserEntity data = new UserEntity();

		String u_Salt = sUtils.getSalt();
		String HashPass = sUtils.getHashPw(param.getU_pass(), u_Salt);

		data.setU_salt(u_Salt);
		data.setU_pass(HashPass);
		data.setU_id(param.getU_id());

		System.out.println(data.getU_pass());
		System.out.println(data.getU_id());

		int result = mapper.changePw(data);

		return result;
	}

	// 회원 정보 수정 (중복된 이메일 =2, 연락처 =3 , 완료 =1 ,수정할값미입력 = 4)
	public int editUser(UserEntity param) {
		UserEntity dbData = mapper.selUser(param);
		int mailck = mapper.mailCheck(param);
		int phoneck = mapper.phoneCheck(param);
		int result = 0;
		
		boolean ckmail = param.getU_mail().equals("");
		boolean ckphone = param.getU_phone().equals("");

		if (ckmail) {
			param.setU_mail(dbData.getU_mail());
		}

		if (ckphone) {
			param.setU_phone(dbData.getU_phone());
		}

		if (mailck != 0) {
			result = 2;
		} else if (phoneck != 0) {
			result = 3;
		} else if (ckmail && ckphone) {
			result = 4;
		} else {
			result = mapper.editUser(param);
		}

		return result;
	}

}
