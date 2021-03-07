<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="nav">
	<div class="nav-left">
		<a href="/main/home" style="text-decoration: none">
			<div class="logo">logo</div>
		</a>
	</div>
	<form class="search-bar" action="/main/home?&searchText=${searchText}&page=${page}" method="get">
		<span class="search-bar__icon"><i class="fas fa-search"></i></span> <input
			class="search-bar__item" id="searchText" name = "searchText" type="text" placeholder="search"  value = "${searchText}"/> <input
			class="search-bar__btn" id = "searchBtn" type="submit" value="검색" />
	</form>
	
	<div class="nav-right">
		<div class="nav-right__item">
			<a href="/main/home">Resturant</a>
		</div>
		<div class="nav-right__item">
			<a href="#">Chatt</a>
		</div>
		<div class="action">
			<div class="profile" onclick="toggleMenu()">
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
			<div class="menu">
				<h3>
					${loginUser.u_Nm}<br />
				</h3>
				<ul>
					<li><i class="fas fa-user-alt"></i><a href="/main/profileEdit">My profile</a></li>
					<li><i class="far fa-edit"></i><a href="">Edit profile</a></li>
					<li><i class="fas fa-cog"></i><a href="/main/likeList">Like</a></li>
					<c:if test="${loginUser == null }">
						<li><i class="fas fa-sign-out-alt"></i><a href="/user/login">login</a></li>
					</c:if>
					<c:if test="${loginUser != null }">
						<li><i class="fas fa-sign-out-alt"></i><a href="/user/logout">Logout</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</header>

