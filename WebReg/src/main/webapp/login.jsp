<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="./style_login.css">
</head>
<body>
<div class="container">
	<form action="Login" method="post">
		<table>
			<p>Welcome To Auction System</p>
			<tr>
				<!--td for="inputField" style="color: white;">User Email</td-->
				<input type="text" id="email_inputField" name="email" placeholder="email">
			</tr>
			<tr>
				<!--td for="inputField">Password</td-->
				<input type="password" id="password_inputField" name="password" placeholder="password">
			</tr>
			<tr>
				<input type="submit" value="login">
			</tr>
		</table>
	</form>
	</div>
</body>
</html>