<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<div class="cnt">
					<span class="view_cnt"><i class="fas fa-eye"></i>조회수</span>
					<span class="review_cnt"><i class="fas fa-pen"></i>리뷰수</span>
					<span class="like_cnt"><i class="fas fa-star"></i>좋아요수</span>
				</div>
			</div>
		</div>
	</section>
	
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
