<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="<tiles:getAsString name="categoryCss"/>">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20d48b705551f225a9a64f8d0d66c274&libraries=services"></script>
<script defer src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script defer src="/resources/javascript/header.js"></script>
<script defer src="<tiles:getAsString name="categoryJs"/>"></script>
<script defer src="https://kit.fontawesome.com/93cf0078c1.js" crossorigin="anonymous"></script>
</head>
<body>
	<tiles:insertAttribute name="header"/>
		<section>		
			<tiles:insertAttribute name="content"/>	
		</section>
		<footer>
			<tiles:insertAttribute name="footer"/>
		</footer>

</body>
</html>