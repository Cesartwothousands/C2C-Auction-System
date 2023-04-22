<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<title>Hello <%= ((Member)request.getAttribute("member")).getUname() %></title>
</head>
<body>
<div class="container">
    <h3>Your Alert </h3>
    <table>
    <%
    List<Alert> alerts= (List<Alert>) request.getAttribute("alerts");
    for(Alert alert:alerts)
    {
    %>
    <tr>
      <td><%=alert.getUser().getUname()%></td>
      <td><%=alert.getItemName()%></td>
    </tr>
    <%
    }
    %>
    </table>
    Create a new alert:
    <form action="UserProfile" method="post">
    <input type="text" name="itemName" />
    <input type="submit" value="Create" />
    <h3> Your Bid </h3>
    <table>
        <%
        List<Bid> bids= (List<Bid>) request.getAttribute("bids");
        for(Bid bid:bids)
        {
        %>
        <tr>
          <td><%=bid.getItem().getName()%></td>
          <td><%=bid.toString()%></td>
        </tr>
        <%
        }
        %>
    </table>
    <h3> Your Auto Bid </h3>
        <table>
            <%
            List<AutoBid> autoBids= (List<AutoBid>) request.getAttribute("autoBids");
            for(AutoBid autoBid:autoBids)
            {
            %>
            <tr>
              <td><%=autoBid.getItem().getName()%></td>
              <td><%=autoBid.toString()%></td>
            </tr>
            <%
            }
            %>
        </table>
    <h3> Items in your Alert</h3>
    <table>
        <%
        List<Item> items= (List<Item>) request.getAttribute("activeItems");
        for(Item item:items)
        {
        %>
        <tr>
          <td><%=item.getName()%></td>
          <td><%=item.toString()%></td>
        </tr>
        <%
        }
        %>
    <h3>item that a higher bid has been placed</h3>
        <table>
            <%
            List<Item> badBids= (List<Item>) request.getAttribute("badBids");
            for(Item item:badBids)
            {
            %>
            <tr>
              <td><%=item.getName()%></td>
              <td><%=item.toString()%></td>
            </tr>
            <%
            }
            %>
    <h3>someone bids more than your auto bid upper limit</h3>
        <table>
            <%
            List<Item> badAutoBids= (List<Item>) request.getAttribute("badAutoBids");
            for(Item item:badAutoBids)
            {
            %>
            <tr>
              <td><%=item.getName()%></td>
              <td><%=item.toString()%></td>
            </tr>
            <%
            }
            %>
</div>
</body>
</html>