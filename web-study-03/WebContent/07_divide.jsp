<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%-- jsp 페이지에서 에러가 발생했을때보여줄 에러 페이지로 error.jsp설정 --%>
<%@ page errorpage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
0으로 나누는것은 불능입니다
<%--강제 에러 발생 --%>
<%= 2/0 %>
</body>
</html>