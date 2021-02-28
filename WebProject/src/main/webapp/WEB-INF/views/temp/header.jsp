<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<div class="nav">
		<div class="nav-left">
			<div class="logo">logo</div>
		</div>
		<div class="nav-right">
			<div class="nav-right__item">
				<a href="#">link1</a>
			</div>
			<div class="nav-right__item">
				<a href="#">link2</a>
			</div>
			<img class="profile_img" src="/resources/image/thunder.png" alt="프로필이미지" />
		</div>
	</div>
	<div class="search-bar__wrap">
		<form class="search-bar">
			<span class="search-bar__icon"><i class="fas fa-search"></i></span> <input
				class="search-bar__item" type="text" placeholder="search" /> <input
				class="search-bar__btn" type="submit" value="검색" />
		</form>
	</div>
</header>