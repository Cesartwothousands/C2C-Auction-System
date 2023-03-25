<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>

<script>
function updateOutput(){
    var name = document.getElementById('name_inputField').value;
    var password = document.getElementById('password_inputField').value;

    if (name.length > 16) {
        document.getElementById('name_outputField').innerHTML = "Please register as required";
    }
    if (password.length < 6 && password.length >0 ) {
        document.getElementById('password_outputField').innerHTML = "Please register as required";
    }

}
</script>

</head>
<body>
	<form action="Register" method="post">
		<table>
			<tr>
				<td for="inputField">User Name</td>
				<td><input type="text" id="name_inputField" name="name" oninput="updateOutput()"></td>
			</tr>
			<tr>
			    <td></td>
			    <td>
            <div id="name_outputField" >Limited in 16 characters</div>
                </td>
            </tr>
			<tr>
				<td for="inputField">Password</td>
				<td><input type="password" id="password_inputField" name="password" oninput="updateOutput()"></td>
			</tr>
			<tr>
			    <td></td>
			    <td>
            <div id="password_outputField" >Longer than 6 characters</div>
                </td>
            </tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email"></td>
			</tr>
			<!--<tr>
				<td>Phone</td>
				<td><input type="text" name="phone"></td>
			</tr>-->
			<tr>
                <td colspan="2">
                    <div style="text-align: center;">
                        <input type="submit" value="register">
                    </div>
                </td>
			</tr>
		</table>
	</form>
</body>
</html>
