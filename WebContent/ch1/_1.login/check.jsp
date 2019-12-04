<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	request¿« id = <%=(String) request.getAttribute("id") %>
	request¿« pwd = <%=(String) request.getAttribute("pwd") %>
<span>${id}</span>
<span>${pwd }</span>
</body>
</html>