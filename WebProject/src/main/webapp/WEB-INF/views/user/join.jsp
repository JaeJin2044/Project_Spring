<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script defer type="text/javascript" src="/resources/javascript/join.js"></script>
</head>

<body>
	<div id="container">
		<form id="frm">
			<div>
				<div><label for="id">아이디</label></div>
					<input type="text" name="u_Id" id="id" placeholder="id">
					<input type="button" id="idCheck" value="아이디 중복확인">
					<div id="msg">아이디를 확인해주세요</div>
				<label for="name">이름</label>
					<div><input type="text" name="u_Nm" id="name" placeholder="name"></div>
				<label for="pass">비밀번호</label>
					<div><input type="password" name="u_Pass" id="pass"></div>
				<label for="passRe">비밀번호 확인</label>
					<div><input type="password" name="u_PassRe" id="passRe"></div>	
				<div>
					<label for="addr">주소</label>
					<div><input type="text" name="u_Addr" id="addr" placeholder="address"></div>
				</div>
				<div>
					<label for="phone">휴대폰</label>
					<div><input type="text" name="u_Phone" id="phone" placeholder="phone"></div>
				</div>
				<div>
					<label for="mail">이메일</label>
					<div><input type="email" name="u_Mail" id="mail" placeholder="mail"></div>
				</div>
				<div>Gender : 
					<label>man<input type="radio" name="u_Gender" value="man" checked></label>
					<label>woman<input type="radio" name="u_Gender" value="woman"></label>
				</div>
				<div>
					<input type="button" id="joinBtn" disabled="disabled" value="JOIN">
				</div>
			</div>
			
		</form>
	
	</div>
</body>
</html>