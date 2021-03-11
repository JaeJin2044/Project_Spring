<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script defer type="text/javascript"
	src="/resources/javascript/login.js?ver=1"></script>
<link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
	<div id="container">
		<form id="frm">
			<h2>Daegu Plate</h2>
			<div class="frm-input">
				<div>
					<input type="text" name="u_id" placeholder="id" autocomplete="off">
				</div>
				<div>
					<input type="password" name="u_pass" placeholder="password">
				</div>
			</div>

			<div id="btn">
				<input type="button" value="로그인" id="loginBtn"> <a
					href="/user/join"><button type="button">회원가입</button></a> <a
					href="/user/userSearch"><button type="button">ID/PW 찾기</button></a>
				<div id="errMsg"></div>
			</div>
			<div class="frm-output">
				<!-- 네이버 로그인 창으로 이동 -->
				<a href="${url}"> <img width="60"
					src="/resources/image/naver_icon.png" />
				</a>

				<!--카카오 로그인창 -->
				<a href="${kakao_url}"> <img width="60"
					src="/resources/image/kakao.png" />
				</a>
			</div>
		</form>
	</div>
</body>
</html>