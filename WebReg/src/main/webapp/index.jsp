<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>My register Form</title>
	<link rel="stylesheet" href="./style.css">

</head>
<head>
<meta charset="UTF-8">
<title>Register Page</title>

<script>
function updateOutput(){
    var name = document.getElementById('name_inputField').value;
    var password = document.getElementById('password_inputField').value;

    if (name.length > 16) {
        //document.getElementById('name_outputField').innerHTML = "Please register as required";
		alert("Your name shouldn't exceed 16 characters!");
    }
    if (password.length < 6 && password.length >0 ) {
        //document.getElementById('password_outputField').innerHTML = "Please register as required";
		alert("Your password should longer than 6 characters!");
    }

}
</script>

</head>
<body>
<div class="container">
	<form action="Register" method="post">
		<p>Welcome To Auction System</p>
		<input type="text" id="name_inputField" name="name" placeholder="Name" oninput="updateOutput()">
		<!--div id="name_outputField" >Limited in 16 characters</div-->
		<input type="password" id="password_inputField" name="password" placeholder="Password" oninput="updateOutput()">
		<!--<div id="password_outputField" >Longer than 6 characters</div>-->
		<input type="email" name="email" placeholder="Email">
			<!--<tr>
				<td>Phone</td>
				<td><input type="text" name="phone"></td>
			</tr>-->
		<input type="button" value="register">
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
