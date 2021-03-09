<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	
<main>
<div id="container">
	<form id="frm" autocomplete="off">
			<h2>My profile</h2>
		<div class="frm-input">
		<c:choose>
			<c:when test="${loginUser.u_profile == null}">
				<c:set var="src" value="profile.jpg"/>
			</c:when>		
			<c:otherwise>
				<c:set var="src" value="user/${loginUser.u_Pk}/${loginUser.u_profile}"/>
			</c:otherwise>
		</c:choose>
		<img src="/resources/image/${src}" alt="프로필 이미지">
		</div>
		<div>
			<div>프로필 이미지 업로드 : <input type="file" accept="image/*" id="profileImg"></div>
			<div><input type="button" value="업로드" onclick="profileUpload()"> </div>
		</div>
		<div class="id-input">
			<input type="text" name="u_Id" id="id" value= "${loginUser.u_Id}" autocomplete="off" readonly>
		</div>
		<div>
			<input type="text" name="u_Nm" id="name" placeholder="${loginUser.u_Nm}" autocomplete="off" >
		</div>

		<div>
			<input type="text" name="u_Phone" id="phone" placeholder="${loginUser.u_Phone}" placeholder="phone" >
		</div>
		
		<div>
			<input type="email" name="u_Mail" id="mail" placeholder="${loginUser.u_Mail}" autocomplete="off">
		</div>
		<div>
			<input type="button" id="joinBtn" disabled="disabled" value="수정">
		</div>
	</form>
</div>
</main>
<script src="/resources/javascript/profileEdit.js"></script>
