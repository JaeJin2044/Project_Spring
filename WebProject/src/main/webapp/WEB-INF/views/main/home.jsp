<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.java.webproject.model.MatZipDTO" %>

<main>
	<div class="container">
		<div class="slider-wrapper">
		</div>
		<div class="content-category">
			<div class="content-category__item"><a href="/main/home?m_category=1">한식</a></div>
			<div class="content-category__item"><a href="/main/home?m_category=2">양식</a></div>
			<div class="content-category__item"><a href="/main/home?m_category=3">중식</a></div>
			<div class="content-category__item"><a href="/main/home?m_category=4">일식</a></div>
			<div class="content-category__item"><a href="/main/home?m_category=5">분식</a></div>
			<div class="content-category__item"><a href="/main/home?m_category=6">카페/디저트</a></div>
		</div>
		<div class="content">
			<c:forEach var="item" items="${list}">
				<div class="content-list">
					<img class="content-list__img" src="${item.m_img1}" alt="" />
					<div class="text_wrap">
						<div class="content-list__text">
							<h1 class="text_title">
								<a href="/main/detail?m_pk=${item.m_pk}">${item.m_title}</a>
								<div class="rating__score">
									${item.m_starPoint}
									<i class="fas fa-star"></i>
								</div>
								<!-- 찜하기버튼 추가 -->
								<div class="mian-like-btn">
									<a class="like-btn" href="/main/insLike?m_pk=${item.m_pk}">
										<i class="fas fa-shopping-basket"></i>
										<div>찜하기</div>
									</a>
								</div>
							</h1>
							<h3 class="text_description">${item.m_viewDetail}</h3>
							<div class="content-list__cnt">
								<span class="view_cnt"><i class="fas fa-eye"></i>${item.m_viewCount}</span>
								<span class="review_cnt"><i class="fas fa-pen"></i>${item.m_commentCount}</span>
							</div>
					</div>
						<li class="main-review-item">
							<div class="main-review-item__items">
								<div class="main-review-user">
								<c:choose>
									<c:when test="${item.u_profile == null}">
										<c:set var="src" value="profile.jpg"/>
									</c:when>		
									<c:otherwise>
										<c:set var="src" value="user/${item.u_pk}/${item.u_profile}"/>
									</c:otherwise>
								</c:choose>
								
								<c:if test='${item.u_nm != null}'>
									<img src="/resources/image/${src}" alt="" />
									<div>${item.u_nm}</div>								
								</div>
									<div class="main-review-content">
										<div class="regdate">${item.c_regDate}</div>
										<p>
											${item.c_content}
										</p>
									</div>
								</c:if>
					
							</div>
							<div class="more_info">
								<div class="more_info__wrap">
									<a href="/main/detail?m_pk=${item.m_pk}">더보기</a>
									<a href="/main/detail?m_pk=${item.m_pk}"><i class="fas fa-chevron-right"></i></a>
								</div>
							</div>
						</li>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="paging">
			<div class="paging-wrapper">
				<c:if test="${page.startPage != 1 && page.startPage > 0}">
					<a href="/main/home?&searchText=${page.searchText}&page=${page.startPage-1}&m_category=${page.m_category}">
						<i class="fas fa-chevron-left"></i>
					</a>
				</c:if>
				<c:if test="${page.endPage !=0}">
					<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
						<c:choose>
							<c:when test="${i == page.page}">
								<a style="color:blue;">${i}</a>
							</c:when>
							<c:when test="${i != page.page }">
								<a href="/main/home?&searchText=${page.searchText}&page=${i}&m_category=${page.m_category}">${i}</a>
							</c:when>
						</c:choose>
					</c:forEach>
				</c:if>
				<c:if test="${page.endPage != page.lastPage}">
					<a href="/main/home?&searchText=${page.searchText}&page=${page.endPage+1}&m_category=${page.m_category}">
						<i class="fas fa-chevron-right"></i>
					</a>
				</c:if>
				<%-- 		       <c:if test="${page.prev}">
	            	<a href="/main/home?&searchText=${page.searchText}&page=${page.startPage-1}">
	            		<i class="fas fa-chevron-left"></i>
	            	</a>
	         	</c:if>
		        <c:if test="${page.endPage !=0}">
		           <c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
		              <c:choose>
		                 <c:when test="${i == page.page}">
		                    <a class="currentNum">${i}</a>
		                 </c:when>
		                 <c:when test="${i != page.page }">
		                    <a href="/main/home?&searchText=${page.searchText}&page=${i}">${i}</a>
		                 </c:when>
		              </c:choose>
		           </c:forEach>
		        </c:if>
	         <c:if test="${page.next}">
	            <a href="/main/home?&searchText=${page.searchText}&page=${page.endPage+1}">
	            	<i class="fas fa-chevron-right"></i>
	            </a>
	         </c:if> --%>
		</div>
	</div>
</main>