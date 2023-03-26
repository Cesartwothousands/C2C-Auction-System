<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
<div class="container">
	<form action="Logout" method="post">
	<h2>Hello <%= request.getAttribute("email") %></h2>
	<input type="submit" value="logout">
	</form>
	</div>
</body>
</html>