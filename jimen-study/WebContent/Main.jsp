<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/form.js"></script>
</head>
<body>


	<form action="CoronaInsert.do" method="post" name="frm">
		<table>
		<tr>
			<td><label for="identity">신분</label></td>
			<td>
				<input type="radio" name="identity" value="student" checked="checked" onclick="student_professor()"> 학생
				<input type="radio" name="identity" value="professor" onclick="student_professor()"> 교수
				<input type="radio" name="identity" value="etc" onclick="etc()"> 기타
		</tr>
		<tr>
			<td>
			<label for="name">이름</label>
			</td>
			<td>
			<input type="text" id="name" name="name" size="10" placeholder="이름">
			</td>
		</tr>	
		<tr>
			<td>
			<label for="stn">학번/사번</label>
			</td>
			<td>
			<input type="text" id="stn" name="stn" size="10" placeholder="학번/사번">
			</td>
		</tr>
		<tr>
			<td>
			<label for="department">소속</label>
			</td>
			<td>
			<input type="text" id="department" name="department" size="10" placeholder="소속" style="background:#666666;" readonly>
			</td>
		</tr>
		<tr>
			<td>
			<label for="phone">전화번호</label>
			</td>
			<td>
			<input type="text" id="phone" name="phone" size="10" placeholder="전화번호" style="background:#666666;" readonly>
			</td>
		</tr>
		<tr>
			<td>
				<label for="location">위치</label>
			</td>
			<td>
				<input type="text" id="location" name="location" size="10" placeholder="위치">
			</td>
		</tr>
	
		<tr>
		<td><label for="purpose">목적</label></td>
		
		<td>
			<input type="radio" name="purpose" value="방문">방문
			<input type="radio" name="purpose" value="공부">공부
			<input type="radio" name="purpose" value="청소">청소
			<input type="radio" name="purpose" value="행사">행사
		</td>
		<tr>
			<td><label for="EE">입/출</label></td>
			<td>
				<input type="radio" name="EE" value="1" checked="checked">입장
				<input type="radio" name="EE" value="2">퇴장
				<input type="hidden" name="command" value="input">
			</td>
		</tr>
		
		</tr>
		<tr>
			<td><input type="submit" value="제출" onclick="return formcheck()"></td>
			<td><input type="reset" value="취소"></td>
		</tr>
		</table>
	</form>
	 ${message}

</body>
</html>