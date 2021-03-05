<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.java.webproject.model.MatZipDTO" %>

<main>
	<div class="container">
		<div class="slider-wrapper">
			<ul class="sliders">
				<li><img src="/resources/image/01.jpg" alt="더미이미지" /></li>
				<li><img src="/resources/image/01.jpg" alt="더미이미지" /></li>
				<li><img src="/resources/image/01.jpg" alt="더미이미지" /></li>
				<li><img src="/resources/image/01.jpg" alt="더미이미지" /></li>
				<li><img src="/resources/image/01.jpg" alt="더미이미지" /></li>
				<li><img src="/resources/image/01.jpg" alt="더미이미지" /></li>
				<li><img src="/resources/image/01.jpg" alt="더미이미지" /></li>
				<li><img src="/resources/image/01.jpg" alt="더미이미지" /></li>
			</ul>
		</div>
		<div class="controls">
			<span class="prev"><i class="fas fa-chevron-left"></i></span>
			<span class="next"><i class="fas fa-chevron-right"></i></span>
		</div>

		<div class="content-category">
			<div class="content-category__item"><a href="#">한식</a></div>
			<div class="content-category__item"><a href="#">양식</a></div>
			<div class="content-category__item"><a href="#">중식</a></div>
			<div class="content-category__item"><a href="#">일식</a></div>
			<div class="content-category__item"><a href="#">분식</a></div>
			<div class="content-category__item"><a href="#">카페/디저트</a></div>
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
								<c:if test='${item.u_nm != null}'>
									<img src="${item.u_profile}" alt="" />
									<div>${item.u_nm}</div>								
								</div>
								<div class="main-review-content">
									<div class="regdate">${item.c_regDate}</div>
									<p>
										${item.c_content}
									</p>
								</div>
								</c:if>
								<div class="main-review-icon">
									<i class="far fa-laugh-squint"></i>
									<div>좋았다</div>
								</div>
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
		
		<div style="height: 40px; text-align: center">
			<c:forEach  var = "i" begin="1" end = "${page.totalPage}">
					<a href="/main/home?&searchText=${page.searchText}&page=${i}"><span style="font-size: 40px">${i}</span></a>
			</c:forEach>
		</div>
	</div>
</main>