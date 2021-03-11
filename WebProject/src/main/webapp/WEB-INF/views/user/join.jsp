<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script defer type="text/javascript"
	src="/resources/javascript/join.js?ver=2"></script>
<link rel="stylesheet" href="/resources/css/join.css">
</head>
<body>
	<div id="container">
		<form id="frm" autocomplete="off">
			<div class="title">
				<h2>Join us</h2>
				<div class="join">
					<input type="button" id="joinBtn" disabled="disabled" value="JOIN">
					<a href="/user/login">Login</a>
				</div>
			</div>
			<div class="frm-input">
				<div class="id-input">
					<input type="text" name="u_id" id="id" placeholder="id"
						autocomplete="off"> <input type="button"
						style="width: 50pt; height: 30pt;" id="idCheck" value="Check">
				</div>
				<div id="msg">아이디를 확인해주세요</div>
				<div>
					<input type="text" name="u_nm" id="name" placeholder="name"
						autocomplete="off">
				</div>

				<div>
					<input type="password" name="u_pass" id="pass" placeholder="pw"
						autocomplete="off">
				</div>

				<div>
					<input type="password" name="u_PassRe" id="passRe"
						placeholder="pwcheck" autocomplete="off">
				</div>
				<div>
					<input type="text" name="u_phone" id="phone" autocomplete="off"
						placeholder="phone">
				</div>
				<div>
					<input type="email" name="u_mail" id="mail" placeholder="mail"
						autocomplete="off">
				</div>
				<div>
					<label for="gender1" class="gender_label"> <input
						type="radio" id="gender1" name="u_gender" value="M"><span>man</span>
					</label> <label for="gender2" class="gender_label"> <input
						type="radio" id="gender2" name="u_gender" value="W"><span>woman</span>
					</label>
				</div>

			</div>
		</form>
	</div>
</body>
</html>