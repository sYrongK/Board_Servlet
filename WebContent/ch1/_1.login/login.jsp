<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://code.jquery.com/jquery-Latest.js"></script>
<link rel="stylesheet" type="text/css" href="css/loginCss.css">
</head>
<body>
<form name="loginForm" action="LoginProcess" method="post">
	<h1>로그인</h1>
		<hr>
		<b>아이디</b>
			<input type = "text" name = "id" placeholder = "Enter id" required>
			<b>Password</b>
			<input type = "text" name = "passwd" placeholder = "Enter password" required>
			<div class = "clearfix">
				<button type = "submit" class= "submitbtn">Submit</button>
				<button type = "reset" class= "cancelbtn">Cancel</button>
			</div>
</form>

</body>
</html>