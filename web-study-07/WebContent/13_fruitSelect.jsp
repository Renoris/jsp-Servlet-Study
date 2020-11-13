<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.fruit==1}">
		<span style="color: red;">사과</span>
	</c:when>
	<c:when test="${param.fruit==2}">
		<span style="color: green;">메론</span>
	</c:when>
	<c:otherwise>
		<span style="color: yellow;">바나나</span> <!-- 위에서 when이 하나도 실행되지 않았을때 실행 -->
	</c:otherwise>
</c:choose>
</body>
</html>