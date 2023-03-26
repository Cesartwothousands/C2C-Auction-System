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
			<form action="Login" method="post">
				<table>
					<h2>
						Welcome To Auction System
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
		</div>
	</body>

	</html>