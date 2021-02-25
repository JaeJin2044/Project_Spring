<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<h1>이건 헤더 </h1>
	<span>한식</span>
	<span>일식</span>
	<span>중식</span>
	<span>야식</span>
	<span>분식</span>
	<span>카페&디저트</span>
	
	<c:if test="${loginUser!=null}">
		${loginUser.u_Nm}님 안녕하세요
		<a href="/user/logout">로그아웃</a>
	</c:if>
	
	<c:if test="${loginUser == null}">
		<a href="/user/login">로그인 하러가기</a>
	</c:if>
	
</header>