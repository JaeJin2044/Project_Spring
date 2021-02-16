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
			<span><input type="button" value="로그인" id="loginBtn"></span>
			<div id="errMsg"></div>
		</form>
	</div>

</body>
</html>