<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<link rel="stylesheet" href="./CSS/admin.css">
<title>Hello <%= ((Member)request.getAttribute("member")).getUname() %></title>
</head>
<body>
<body>
    <div class="header">
            <!-- Navigation -->
            <div class="Brand-Search">

                <button class="ad-search-button">
                    <a href="/webreg/Explore">
                        <h1>
                            C2C Auction System!
                        </h1>
                    </a>
                </button>

                <form class="search-form" action="/webreg/Search" method="GET">
                    <input class="search-input" type="search" name="query" placeholder="Search Everything You Want"
                        aria-label="Search">
                    <button class="search-button" type="submit">Search</button>
                </form>

                <button class="ad-search-button">
                    <a href="/webreg/AdvancedSearch">Advanced</a>
                </button>
            </div>
            <nav class="nav-container">
                <ul>
                    <li class="nav-item"><a class="nav-link" href="/webreg/Explore">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="/webreg/">Watch List</a></li>
                    <li class="nav-item"><a class="nav-link" href="/webreg/">Sell Items</a></li>
                    <li class="nav-item"><a class="nav-link" href="/webreg/">Settings</a></li>
                    <li class="nav-item"><a class="nav-link" href="/webreg">Register/Login</a></li>
                </ul>
            </nav>
        </div>
    <div class="seperator"></div>
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
    <form action="User" method="post">
    <input type="text" name="itemName" />
    <input type="submit" value="Create" />
    </form>
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
          <td><a href="<%=bid.getItem().getLink()%>">Click here to Item</a></td>
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
              <td><a href="<%=autoBid.getItem().getLink()%>">Click here to Item</a></td>
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
          <td><a href="<%=item.getLink()%>">Click here to Item</a></td>
        </tr>
        <%
        }
        %>
    </table>
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
              <td><a href="<%=item.getLink()%>">Click here to Item</a></td>
            </tr>
            <%
            }
            %>
        </table>
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
              <td><a href="<%=item.getLink()%>">Click here to Item</a></td>
            </tr>
            <%
            }
            %>
        </table>
    <h3>Your winning items</h3>
        <table>
            <%
            List<Winner> winners= (List<Winner>) request.getAttribute("winners");
            for(Winner winner:winners)
            {
            %>
            <tr>
              <td><%=winner.getItemName()%></td>
            </tr>
            <%
            }
            %>
        </table>
    <a href="Logout">Click here to logout</a>
</div>
</body>
</html>