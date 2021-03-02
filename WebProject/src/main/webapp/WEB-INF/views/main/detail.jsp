<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD

<div id="container">
	<div class="nav">
		<div class="nav-left">
			<div class="logo">logo</div>
		</div>
		<form class="search-bar">
			<span class="search-bar__icon"><i class="fas fa-search"></i></span>
			<input class="search-bar__item" type="text" placeholder="search" />
			<input class="search-bar__btn" type="submit" value="검색" />
		</form>
		<div class="nav-right">
			<div class="nav-right__item"><a href="#">link1</a></div>
			<div class="nav-right__item"><a href="#">link2</a></div>
			<img class="profile_img" src="thunder.png" alt="프로필이미지" />
		</div>
	</div>
	<section>
		<div class="top_img">
			<img src="./image/01.jpg" alt="" />
			<img src="./image/01.jpg" alt="" />
			<img src="./image/01.jpg" alt="" />
			<img src="./image/01.jpg" alt="" />
			<img src="./image/01.jpg" alt="" />
		</div>
		<div class="title-wrap">
			<div class="detail_title">
				패스트리부티크
				<span class="rating">4.6</span>
				<div class="detail_description">서울신라호텔</div>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="container">
	<section>
		<div class="top_img">
			<img src="${detail_item.m_img1}" alt="" />
			<img src="${detail_item.m_img2}" alt="" />
			<img src="${detail_item.m_img3}" alt="" />
			<img src="${detail_item.m_img4}" alt="" />
		</div>
		<div class="title-wrap">
			<div class="detail_title" >
			<div id="data" data-loginuserpk="${sessionScope.loginUser.u_Pk}" data-pk="${requestScope.detail_item.m_pk}"></div>
				${detail_item.m_title}
				<span class="rating">${detail_item.m_title}</span>
				<div class="detail_description"></div>
>>>>>>> jaejin
				<div class="cnt">
					<span class="view_cnt"><i class="fas fa-eye"></i>조회수</span>
					<span class="review_cnt"><i class="fas fa-pen"></i>리뷰수</span>
					<span class="like_cnt"><i class="fas fa-star"></i>좋아요수</span>
				</div>
			</div>
		</div>
	</section>
<<<<<<< HEAD
</div>
=======
	
</div>



<h2>여기서부터 댓글리스트 </h2>
	<hr />	
	<div id="cmtList">
	
	</div>
	
	
	<c:if test="${sessionScope.loginUser != null}">
		<h4>리뷰작성</h4>
		<div>
			<form id="cmtFrm">
				<div><input type="text" name="c_content" ></div>
				<div><input type="button" name="cmtWriteBtn" value="리뷰등록"></div>
			</form>
		</div>
		
		<div id="modal" class="hide">
			<div class="modal-content">
				<span id="modClose">X</span>
				<input type="text" id="modCtnt">
				<input type="button" id="modBtn" value="수정">
			</div>
		</div>
	</c:if>
>>>>>>> jaejin
