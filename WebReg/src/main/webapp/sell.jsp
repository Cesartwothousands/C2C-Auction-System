<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page import="model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<title>Sell </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="sell.js"></script>
</head>
<body>

<div class="container">
    <h3>This is the sell page </h3>
    <form action = "Sell" method = "POST">
    Select a Type:
    <select name="type" id="typeselect">
                     <%
                     List<Type> types= (List<Type>) request.getAttribute("types");
                     for(Type type: types)
                     {
                     %>
                     <option value="<%=type.getName()%>"><%=type.getName()%></option>
                     <%
                     }
                     %>
                 </select>
       <input type = "submit" name="submittype" value = "Submit" />
    </form>
    <form action = "Sell" method = "POST">
             Name: <input type = "text" name = "name">
             <br />
             End Date: <input type = "date" name = "end date" />
             <br />
             Initial Price: <input type = "number" name = "initial price" />
             <br />
             Increment: <input type = "number" name = "increment" />
             <br />
             Minimum Price (Can leave blank): <input type = "number" name = "minimum price" />
             <br />
             Description: <input type = "text" name = "description" />
             <br />
             Add A property:
             </div>
              <div class="jumbotron jumbotron-fluid" id="dataAdd">
                         <div class="container">
                             <div class="form-row">
                               <div class="form-group col-md-4">
                                 <label>Property</label>
                                 <select name="property" id="selectproperty1">
                                 <%
                                   List<String> properties= (List<String>) request.getAttribute("propertylist");
                                   if(properties!=null){
                                   for(String prop: properties){%>
                                   <option value="<%=prop%>"><%=prop%></option>
                                   <%}}%>
                                 </select>
                               </div>
                               <div class="form-group col-md-4">
                                 <label>Description</label>
                                 <input class="form-control" id="lastname1" type="text">
                               </div>
                     </div>
              </div>
             <button class="btn btn-success" type="button" id="addRow" >Add Property</button>
             <button class="btn btn-danger" type="button" id="deleteRow">Delete row</button>
             </div>
             <input type = "submit" name="submitform" value = "Submit" />
    </form>
</div>
<script>
function addRow(){
   console.log('adding row...');
    var len=$('#dataAdd .container .form-row').length+1;
    var type = document.getElementById("typeselect").value;
    // select properties based on type
    $("#dataAdd .container:last").append('<div class="form-row">'+
                                         '<div class="form-group col-md-4">'+
                                         '<label>Property</label>'+
                                 '<select name="property" id="selectproperty'+len+'">'+
                                 '<%properties= (List<String>) request.getAttribute("propertylist");if(properties!=null){for(String prop: properties){%>'+
                                   '<option value='+'"<%=prop%>"'+'>'+'<%=prop%>'+'</option>'+'<%}}%>'+
                                 '</select>'+
                                         '</div>'+
                                         '<div class="form-group col-md-4">'+
                                         '<label>Description</label>'+
                                         '<input class="form-control" id="description'+len+'" type="text">'+
                                         '</div>'+'</div>'    );
}
        var btn = document.getElementById("addRow");
        btn.onclick = addRow;
</script>
</body>
</html>