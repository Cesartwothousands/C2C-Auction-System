<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Login Page</title>
		<link rel="stylesheet" href="./style_login.css">
	</head>

	<body>
		<div class="container">
			<form action="AdminLogin" method="post">
				<table>
					<h2>
						Admin: Welcome To Auction System
					</h2>

					<tr>
						<input type="text" id="email_inputField" name="email" placeholder="Email">
					</tr>

					<br>

					<tr>
						<input type="password" id="password_inputField" name="password" placeholder="Password">
					</tr>

					<br>

					<tr>
						<input type="submit" value="Login">
					</tr>
				</table>
			</form>
			<div class="drops">
				<div class="drop drop-1"></div>
				<div class="drop drop-2"></div>
				<div class="drop drop-3"></div>
				<div class="drop drop-4"></div>
				<div class="drop drop-5"></div>
			</div>
		</div>
	</body>
	</html>