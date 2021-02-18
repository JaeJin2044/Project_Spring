<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.err == -1}">
		<script>
			alert('중복된 이메일이 있습니다.');
			history.back();
		</script>
	</c:if>
	<c:if test="${param.err == 0}">
		<script>
			alert('중복된 연락처가 있습니다.');
			history.back();
		</script>
	</c:if>
	

</body>
</html>