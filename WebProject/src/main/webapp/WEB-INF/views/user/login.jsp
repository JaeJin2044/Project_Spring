<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script defer type="text/javascript" src="/resources/javascript/login.js?ver=1"></script>
</head>
<body>
	<h1>로그인 페이지 </h1>
	<div id="container">
		<form id="frm">
			<div><input type="text" name="u_Id" placeholder="id" autocomplete="off"></div>
			<div><input type="password" name="u_Pass" placeholder="password"></div>
			<a href="/user/userSearch"><button type="button">ID/PW 찾기</button></a>
			<a href="/user/join"><button type="button">회원가입</button></a>
			<span><input type="button" value="로그인" id="loginBtn"></span>
			<div id="errMsg"></div>
		</form>
		
		
		<!-- 네이버 로그인 창으로 이동 -->
		<div id="naver_id_login" style="text-align:left;"><a href="${url}">
		<img width="150" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/></a></div>
		<br>		
	</div>

</body>
</html>