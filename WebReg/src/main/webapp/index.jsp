<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Register Page</title>
		<link rel="stylesheet" href="./style.css">
	</head>

	<meta charset="UTF-8">
	<title>Register Page</title>

	<script>
		function validateNameLength() {
			var nameInput = document.getElementById('name_inputField');
			var nameError = document.getElementById("name_error");
			if (nameInput.value.length > 16) {
				nameError.textContent = "Shorter than 16 characters!";
			} else {
				nameError.textContent = "";
			}
		}
	</script>

	<script>
		function validatePasswordLength() {
			var passwordInput = document.getElementById("password_inputField");
			var passwordError = document.getElementById("password_error");
			if (passwordInput.value.length < 6 && passwordInput.value.length > 0) {
				passwordError.textContent = "Longer than 6 characters!";
			} else {
				passwordError.textContent = "";
			}
		}
	</script>

	</head>

	<body>
		<div class="container">
			<form action="Register" method="post">
				<h2>
					Welcome To Auction System
				</h2>

				<table>
					<tr>
						<div id="name_error" style="color: #ff0000;"> </div>

						<input type="text" id="name_inputField" name="name" placeholder="Name"
							oninput="validateNameLength()">
					</tr>

					<br>

					<tr>
						<div id="password_error" style="color: red;"></div>

						<input type="password" id="password_inputField" name="password" placeholder="Password"
							oninput="validatePasswordLength()">

					</tr>

					<br>

					<tr>
						<input type="email" name="email" placeholder="Email">
					</tr>


					<br>

					<tr>
						<input type="submit" value="Register">
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