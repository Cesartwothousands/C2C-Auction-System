<%--
  Created by IntelliJ IDEA.
  User: qipanxu
  Date: 4/26/23
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Redirecting...</title>
  <script type="text/javascript">
    function redirectToAnotherPage() {
      // Change the URL to the target page you want to redirect to
      window.location.href = "http://localhost:8080/webreg/Explore";
    }

    // Set the delay (5000 milliseconds = 5 seconds)
    setTimeout(redirectToAnotherPage, 5000);
  </script>
</head>
<body>
<h3><%= request.getAttribute("result")%>,  Redirecting to Explore in 5 seconds...</h3>
</body>
</html>

