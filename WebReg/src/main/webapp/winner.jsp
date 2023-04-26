<%--
  Created by IntelliJ IDEA.
  User: qipanxu
  Date: 4/24/23
  Time: 12:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auction Winner</title>
    <script src="https://cdn.jsdelivr.net/npm/ag-grid-community/dist/ag-grid-community.min.js"></script>
    <link rel="stylesheet" href="./style_history.css">
</head>
<body>
    <div class="container">
        <h2>
            The Auction Winner
        </h2>
        <nav class="nav-container">
            <ul>
                <li class="nav-item"><a class="nav-link" href="/webreg/Explore">Home</a></li>
            </ul>
        </nav>
    </div>
    <div class="container_2">

        <div id="myGrid" style="width: 100%; height: 78vh; " class="ag-theme-alpine"></div>

        <script>
            var columnDefs = [
            { headerName: "idItem", field: "a", sortable: true, flex: 1 },
            { headerName: "ItemName", field: "b", sortable: true, flex: 1 },
            { headerName: "User", field: "c", sortable: true, flex: 1 },
        ];

        // Data
        // Get the tableItemsJson attribute from the request object
        var tableItemsJson = '<%= request.getAttribute("winnerJson") %>';
        // console.log(historyJson);

        // Parse the JSON string into a JavaScript object
        var tableItems = JSON.parse(tableItemsJson) || [];
        console.log(tableItems);
        // Convert the tableItems object to the format expected by rowData
        var rowData = tableItems.map(function (item) {
            return {
                a: item.idItem,
                b: item.itemName,
                c: item.userName,
            };
        });

        var gridOptions = {
            columnDefs: columnDefs,
            rowData: rowData,
            defaultColDef: {
                resizable: false,
                filter: false,
                autoHeight: true, // Enable auto height for rows
                wrapText: true, // Enable text wrapping
                cellStyle: { 'white-space': 'normal' } // Allow text to wrap to next line
            },
            suppressMovableColumns: true,
            enableCellTextSelection: true
        };

        new agGrid.Grid(document.getElementById("myGrid"), gridOptions);
    </script>
</div>
</body>
</html>
