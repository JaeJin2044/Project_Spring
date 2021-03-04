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
<<<<<<< HEAD
								<a href="./detail.html">${item.m_title}</a>
=======
								<a href="/main/detail?m_pk=${item.m_pk}">${item.m_title}</a>
<<<<<<< HEAD
>>>>>>> jaejin
=======
								<div class="rating__score">
									${item.m_starPoint}
									<i class="fas fa-star"></i>
								</div>
>>>>>>> jaejin
							</h1>
							<h3 class="text_description">${item.m_viewDetail}</h3>
							<div class="content-list__cnt">
								<span class="view_cnt"><i class="fas fa-eye"></i>${item.m_viewCount}</span>
								<span class="review_cnt"><i class="fas fa-pen"></i>${item.m_commentCount}</span>
							</div>
						</div>
<<<<<<< HEAD
						<div class="more_info">
<<<<<<< HEAD
							<a href="./detail.html">더보기 </a>
							<a href="./detail.html"><i class="fas fa-chevron-right"></i></a>
=======
							<a href="/main/detail?m_pk=${item.m_pk}">더보기 </a>
							<a href="/main/detail?m_pk=${item.m_pk}"><i class="fas fa-chevron-right"></i></a>
>>>>>>> jaejin
						</div>
=======
						<li class="main-review-item">
							<div class="main-review-item__items">
								<div class="main-review-user">
									<img src="./image/bg.jpeg" alt="" />
								</div>
								<div class="main-review-content">
									<div class="regdate">2021-03-03</div>
									<p>
										Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus ducimus illo beatae molestiae
										earum animi est, consequuntur sunt iusto culpa, ab facere, in excepturi molestias. Soluta illo
										ex dolorum corporis. Lorem ipsum dolor sit 
									</p>
								</div>
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
>>>>>>> jaejin
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div style="height: 40px; text-align: center">
			<c:forEach begin="1" end="10" var="i">
				<a href="/main/listPage?pageNum=${i}"><span style="font-size: 40px">${i}</span></a>
			</c:forEach>
		</div>
	</div>
</main>