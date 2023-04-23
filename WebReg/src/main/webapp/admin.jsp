<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page import="model.*" %>
<%@ page import="java.util.HashMap" %>
<link rel="stylesheet" href="./CSS/admin.css">
<title>Admin </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<div class="container">
<h2>Admin Page</h2>
<h3>Item Earnings </h3>
    <table>
    <%
    HashMap<String, Double> itemEarnings= (HashMap<String, Double>) request.getAttribute("itemEarnings");
    for(String item:itemEarnings.keySet())
    {
    %>
    <tr>
      <td><%=item%></td>
      <td><%=itemEarnings.get(item)%></td>
    </tr>
    <%
    }
    %>
    </table>
    <h3>Type Earnings </h3>
        <table>
    <%
    HashMap<String, Double> typeEarnings= (HashMap<String, Double>) request.getAttribute("typeEarnings");
    for(String type:typeEarnings.keySet())
    {
    %>
    <tr>
      <td><%=type%></td>
      <td><%=typeEarnings.get(type)%></td>
    </tr>
    <%
    }
    %>
        </table>
    <h3>Seller Earnings </h3>
        <table>
    <%
    HashMap<String, Double> sellerEarnings= (HashMap<String, Double>) request.getAttribute("sellerEarnings");
    for(String seller:sellerEarnings.keySet())
    {
    %>
    <tr>
      <td><%=seller%></td>
      <td><%=sellerEarnings.get(seller)%></td>
    </tr>
    <%
    }
    %>
        </table>
    <h3>Total Earnings </h3>
        <%=(Double)request.getAttribute("totalEarnings")==null?0:(Double)request.getAttribute("totalEarnings") %>
    <h3>Best selling item </h3>
        Name: <%=(Item)request.getAttribute("item")==null?"":((Item)request.getAttribute("item")).getName()%>
        <br/>
        Price: <%=(Item)request.getAttribute("item")==null?0:((Item)request.getAttribute("item")).getCurrentPrice()%>
    <h3>Best Buyer </h3>
        Name: <%=(Member)request.getAttribute("bestBuyer")==null?"":((Member)request.getAttribute("bestBuyer")).getUname()%>
        <br/>
        Total Spent: <%=(Double)request.getAttribute("bestBuyerSpending")%>
        <br/>
        <h3>Create Customer Representative</h3>
        <form action="Admin" method="post">

    <table>
                        <tr>
                            <input type="text" id="name_inputField" name="name" placeholder="Name">
                        </tr>
                        <br>

                        <tr>
                            <input type="password" id="password_inputField" name="password" placeholder="Password">
                        </tr>

                        <br>

                        <tr>
                            <input type="email" name="email" placeholder="Email">
                        </tr>

                        <br>
                        <tr>
                            <input type="submit" value="create">
                        </tr>

                    </table>
     </form>
</div>
</body>