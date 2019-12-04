<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link rel="stylesheet" type="text/css" href="css/joinCss.css">
</head>
<body>
<form action="JoinProcess.do" method="post">
	<h1>회원가입</h1>
	<hr>
	<b>아이디</b>
		<input type="text" name="id" placeholder="ENTER ID" required>
	<b>비밀번호</b>
		<input type="text" name="password" placeholder="ENTER PASSWORD" required>
	<b>이름</b>
		<input type="text" name="name" placeholder="ENTER NAME" required>
	<b>나이</b>
		<input type="text" name="age" placeholder="ENTER AGE" required>
	<b>성별</b>
	<div>
		<input type="radio" name="gender" value="남" checked><span>남자</span>
		<input type="radio" name="gender" value="여"><span>여자</span>
	</div>
	<br>
	<b>이메일</b>
		<input type="text" name="email" placeholder="ENTER EMAIL" required>
	<div>
		<button type="submit" class="submitbtn">회원가입</button>
		<button type="reset" class="cancelbtn">취소</button>
	</div>
</form>
</body>
</html>