<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Auto Bid Page</title>
		<link rel="stylesheet" href="./style_login.css">
	</head>

	<body>
		<div class="container">
			<form action="AutoBid" method="post">
				<table>
					<h2>
						Place your auto bid
					</h2>

					<br/>
                    Put your hidden upperlimit here:
					<tr>
						<input type="number" name="upperlimit">
					</tr>

					<br/>

					<tr>
						<input type="submit" value="Place Bid">
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