<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
								<a href="./detail.html">${item.m_title}</a>
							</h1>
							<h3 class="text_description">${item.m_viewDetail}</h3>
							<div class="rating__score">
								${item.m_starPoint}
								<i class="fas fa-star"></i>
							</div>
						</div>
						<div class="more_info">
							<a href="./detail.html">더보기 </a>
							<a href="./detail.html"><i class="fas fa-chevron-right"></i></a>
						</div>
					</div>
				
				</div>
			</c:forEach>
		</div>
		
		<div style="height: 40px; text-align: center">
			<c:forEach begin="1" end="10" var="i">
				<span style="font-size: 40px">${i}</span>
			</c:forEach>
		</div>
	</div>
</main>