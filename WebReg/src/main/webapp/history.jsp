<%--
  Created by IntelliJ IDEA.
  User: qipanxu
  Date: 4/19/23
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History Record Page</title>
    <script src="https://cdn.jsdelivr.net/npm/ag-grid-community/dist/ag-grid-community.min.js"></script>
    <link rel="stylesheet" href="./style_history.css">
</head>
<body>
    <div class = "container">
        <h2>
            Your History Record
        </h2>
        <form action="History" method="GET">
            <table>
                <tr>
                    <input type="text" id="type_search" name="type" placeholder="search your type here">
                </tr>
                <tr>
                    <input type="submit" value="Type Search">
                </tr>
            </table>
        </form>
    </div>

    <div class="container_2">

        <div id="myGrid" style="width: 100%; height: 78vh; " class="ag-theme-alpine"></div>

        <script>
            var columnDefs = [
                { headerName: "UserName", field: "a", sortable: true, flex: 1 },
                { headerName: "ItemName", field: "b", sortable: true, flex: 1 },
                { headerName: "Type", field: "c", sortable: true, flex: 1 },
                { headerName: "Bid Price", field: "d", sortable: true, flex: 1 },
                { headerName: "End date", field: "e", sortable: true, flex: 1 },
                { headerName: "Seller", field: "f", sortable: true, flex: 1 },
            ];

            // Data
            // Get the tableItemsJson attribute from the request object
            var tableItemsJson = '<%= request.getAttribute("historyJson") %>';
            // console.log(historyJson);

            // Parse the JSON string into a JavaScript object
            var tableItems = JSON.parse(tableItemsJson) || [];
            console.log(tableItems);
            // Convert the tableItems object to the format expected by rowData
            var rowData = tableItems.map(function (item) {
                return {
                    a: item.userName,
                    b: item.itemName,
                    c: item.itemType,
                    d: item.bid_price,
                    e: item.end_date,
                    f: item.seller,
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
