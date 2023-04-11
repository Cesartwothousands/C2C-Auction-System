<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello <%= request.getAttribute("name"). %></title>
</head>
<body>
<div class="container">
    <h3>Your Alert </h3>
    <table>
      <c:forEach items="${alerts}" var="alert">
        <tr>
          <td><c:out value="${alert.getId()}" /></td>
          <td><c:out value="${alert.propString()}" /></td>
        </tr>
      </c:forEach>
    </table>
    <h3> Your Bid </h3>
    <table>
      <c:forEach items="${bids}" var="bid">
        <tr>
          <td><c:out value="${bid.getItem().getName()}" /></td>
          <td><c:out value="${bid.toString()}" /></td>
        </tr>
      </c:forEach>
    <h3> Your Auto Bid </h3>
    <table>
      <c:forEach items="${autoBids}" var="autoBid">
        <tr>
          <td><c:out value="${autoBid.getItem().getName()}" /></td>
          <td><c:out value="${autoBid.toString()}" /></td>
        </tr>
      </c:forEach>
</div>
</body>
</html>