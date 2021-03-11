<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div id="container" class="conteiner">
	<div class="myProfile">
		<div class="slider-wrapper"></div>
		<div class="profile-title">My Profile</div>
	</div>
	<div class="frm-wrapper">
		<form action="" class="img-profile-frm">
			<c:choose>
				<c:when test="${loginUser.u_profile == null}">
					<c:set var="src" value="profile.jpg" />
				</c:when>
				<c:otherwise>
					<c:set var="src"
						value="user/${loginUser.u_pk}/${loginUser.u_profile}" />
				</c:otherwise>
			</c:choose>
			<div class="frm-img-wrap">
				<h2>profile image</h2>
				<div class="frm-img">
					<label for="profileImg"> <img src="/resources/image/${src}"
						alt="프로필 이미지" />
					</label>
				</div>
			</div>
			<div class="uploadImg">
				<div class="upload-item">
					<label for="profileImg">파일선택</label> <input type="file"
						accept="image/*" id="profileImg" />
				</div>
				<div class="upload-btn">
					<input type="button" value="업로드" onclick="profileUpload()" />
				</div>
			</div>
		</form>
		<div class="mod-profile-frm">
			<h2>Edit profile</h2>
			<div class="frm-data">
				<input type="hidden" name="u_pk" id="u_Pk" value="${loginUser.u_pk}">
				<input type="text" name="u_nm" id="name" value="${loginUser.u_nm}"
					readonly /> <input type="text" name="u_phone" id="phone"
					placeholder="${loginUser.u_phone eq null ? '전화번호' : loginUser.u_phone}"
					autocomplete="off"> <input type="email" name="u_mail"
					id="mail"
					placeholder="${loginUser.u_mail eq null ? '이메일' : loginUser.u_mail}"
					autocomplete="off">
			</div>
			<div class="frm-data-submit">
				<input type="button" id="editUserBtn" value="수정" />
			</div>
		</div>
	</div>

	<div class="frm-data-outBtn">
		<button class="openBtn">PW변경</button>
		<input type="button" onclick="delUserBtn(${loginUser.u_pk})"
			value="회원탈퇴" />
	</div>
</div>
<div class="modal hidden">
	<div class="bg"></div>
	<div class="modalBox">
		<div class="modalBox-wrap">
			<p>* 비밀번호를 정확히 입력하고 [변경]을 눌러주세요 *</p>
			<div class="modalBox-input">
				<div id="data" data-loginusernm="${sessionScope.loginUser.u_id}"></div>
				<input type="password" placeholder="신규 비밀번호" id="pass"> <input
					type="password" placeholder="비밀번호 재확인" id="passCheck">

			</div>
			<button class="chgBtn" id="passChangeBtn">변경</button>
		</div>
	</div>
</div>

