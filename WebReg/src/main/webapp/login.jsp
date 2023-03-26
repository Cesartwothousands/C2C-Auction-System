<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
<div class="container">
	<form action="Login" method="post">
		<table>
			<tr>
				<td for="inputField">User Email</td>
				<td><input type="text" id="email_inputField" name="email" ></td>
			</tr>
			<tr>
				<td for="inputField">Password</td>
				<td><input type="password" id="password_inputField" name="password" ></td>
			</tr>
			<tr>
                <td colspan="2">
                    <div style="text-align: center;">
                        <input type="submit" value="login">
                    </div>
                </td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>