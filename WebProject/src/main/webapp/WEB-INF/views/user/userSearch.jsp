<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script defer type="text/javascript" src="/resources/javascript/userSearch.js"></script>
</head>
<body>
	<div id="container">
		<h3>아이디 비밀번호 찾기 </h3>
		<p>인증된 메일만 정보를 찾을수 있어용~~!</p>
		<a href="/user/login">로그인 하러가기</a>
		<div>
			<input type="radio" id="search_1" name="search_total" onclick="search_check(1)" checked="checked">
			<label 	for="search_1">아이디 찾기</label>
		</div>
		<div>
			<input type="radio" id="search_2" name="search_total" onclick="search_check(2)"> 
			<label for="search_2">비밀번호 찾기</label>
		</div>
		
		<!-- 아이디 찾기 폼 -->
		<div id="searchId">
			<div>
				<label for="Name">이름</label>
				<div>
					<input type="text" id="Name" name="u_Nm" placeholder="ex) 김철수" autocomplete="off">
				</div>
			</div>
			
			<div>
				<label for="Phone">휴대폰번호</label>
				<div>
					<input type="text" id="Phone" name="u_Phone" placeholder="ex) 01077779999" autocomplete="off">
				</div>
			</div>
			
			<div>
				<button id="searchBtn1" type="button" onclick="idSearch_click()" >확인</button>
			<a href="${pageContext.request.contextPath}"><button type="button">취소</button></a>
			</div>
			<div id="msg">여기가 찾은 아이디 나오는부분(깔끔하게 모달창으로 바꿀예정)</div>
		</div>
		
		<!-- 비밀번호 찾기 폼 -->
		<div id="searchPw" style="display: none;">
			<div>
				<label for="id">아이디</label>
				<div>
					<input type="text" id="id" name="u_Id" placeholder="ex) godmisu">
				</div>
			</div>
			
			<div>
				<label for="email">이메일</label>
				<div>
					<input type="email" id="email"	name="u_Mail" placeholder="ex) E-mail@gmail.com">
				</div>
			</div>
			
			<div>
				<button id="searchBtn2" type="button" onclick="pwSearch_click()" >확인</button>
			<a href="${pageContext.request.contextPath}"><button type="button">취소</button></a>
			</div>
			
			
		</div>
	</div>

</body>
</html>