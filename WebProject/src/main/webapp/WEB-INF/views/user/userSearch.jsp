<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script defer type="text/javascript" src="/resources/javascript/userSearch.js"></script>
<link rel="stylesheet" href="/resources/css/userSearch.css">
</head>
<body>
	 <div id="container">
			<form id="frm">
				<h3>Find Id Pw</h3>
				<div>
					<label class="search_label" for="search_1">
					<input type="radio" id="search_1" name="search_total" onclick="search_check(1)" checked="checked"><span>Find ID</span>
					</label>

					<label class="search_label" for="search_2">
					<input type="radio" id="search_2" name="search_total" onclick="search_check(2)"><span>Find PW</span>
					</label>
				</div>
				<p>* 인증된 메일만 찾기 가능 *</p>
				<!-- 아이디 찾기 폼 -->
				<div id="searchId" class="search-input">
					<div>
						<!-- <label for="Name">이름</label> -->
						<input type="text" id="Name" name="u_Nm" placeholder="이름" autocomplete="off" />
					</div>
					<div>
						<!-- <label for="Phone">휴대폰번호</label> -->
						<input type="text" id="Phone" name="u_Phone" placeholder="휴대폰번호" autocomplete="off" />
					</div>

					<div id="btn">
						<button id="searchBtn1" type="button" onclick="idSearch_click()">확인</button>
						<a href="${pageContext.request.contextPath}"><button type="button">취소</button></a>
					</div>
					<div id="msg"></div>
				</div>

				<!-- 비밀번호 찾기 폼 -->
				<div id="searchPw" class="search-input" style="display: none">
					<div>
						<!-- <label for="id">아이디</label> -->
						<input type="text" id="id" name="u_Id" placeholder="아이디" />
					</div>
					<div>
						<!-- <label for="email">이메일</label> -->
						<input type="email" id="email" name="u_Mail" placeholder="이메일" />
					</div>
					<div id="btn">
						<button id="searchBtn2" type="button" onclick="pwSearch_click()">확인</button>
						<a href="${pageContext.request.contextPath}"><button type="button">취소</button></a>
					</div>
				</div>
				<div class="login-btn">
					<a href="/user/login">Login</a>
				</div>
			</form>
		</div>

</body>
</html>