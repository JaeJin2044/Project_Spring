<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="container">
	
	<h1>좋아요 리스트 페이지 </h1>
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
					</div>
					<a href="/main/delLike?l_pk=${item.l_pk}"><button>삭제</button></a>
				</div>		
				
	</c:forEach>
	
	
	


</div>

    
   