<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="join.js"></script>
</head>
<body>
	<form method=get action="JoinServlet" name="list">
		<label for="name">이름</label>
		<input type="text" id="name" name="name"><br>
		<label for="P_code">주민등록번호</label>
		<input type="text" id="P_code" name="codeFirst">-<input type="password" id="P_code2" name="codeLast"><br>
		<label for="id">아이디</label>
		<input type="text" id="id" name="id"><br>
		<label for="password">비밀번호</label>
		<input type="password" id="password" name="pwd"><br>
		<label for="passwordconfirm">비밀번호확인</label>
		<input type="password" id="passwordconfirm" name="pwdconfirm"><br>
		<label for="email">이메일</label>
		<input type="text" id="email" name="emailFirst"> @ <input type="text" id="email2" name="emailLast">
			<select id="selectEmail" size="1" onclick="emailSelect()">
				<option value="">직접 선택</option>
				<option value="nate.com">nate.com</option>
				<option value="naver.com">naver.com</option>
				<option value="google.com">google.com</option>
				<option value="daum.com">daum.com</option>
			</select><br>
		<label for="postnumber">우편번호</label>
		<input type="text" id="postnumber" name="postnumber"><br>
		<label for="address">주소</label>
		<input type="text" id="address" name="addressFirst"> <input type="text" id="address2" name="addressLast"> <br>
		<label for="phonenumber">휴대폰번호</label>
		<input type="text" id="phonenumber" name="phonenumber"><br>
		<label for="job">직업</label>
		<select id="job" name="job" size="4">
			<option value="학생">학생</option>
			<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
			<option value="언론">언론</option>
			<option value="공무원">공무원</option>
			<option value="군인">군인</option>
			<option value="서비스업">서비스업</option>
			<option value="교육">교육</option>
		</select><br>
		<label for="chk_mail">메일/SMS 정보 수신</label>
		<input type="radio" name="chk_mail" id="chk_mail" value="수신" checked>수신
		<input type="radio" name="chk_mail" id="chk_mail" value="거부">거부
		<br>
		<label for="interest">관심분야</label>
		<input type="checkbox" name="interest" id="interest" value="생두">생두
		<input type="checkbox" name="interest" id="interest" value="원두">원두
		<input type="checkbox" name="interest" id="interest" value="로스팅">로스팅
		<input type="checkbox" name="interest" id="interest" value="핸드드립">핸드드립
		<input type="checkbox" name="interest" id="interest" value="에스프레소">에스프레스
		<input type="checkbox" name="interest" id="interest" value="창업">창업<br>
		<input type="submit" value="제출" onclick="return checkinglist()">
	</form>
</body>
</html>