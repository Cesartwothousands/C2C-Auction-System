<%--
  Created by IntelliJ IDEA.
  User: qipanxu
  Date: 4/13/23
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auction Page</title>
    <script src="https://cdn.jsdelivr.net/npm/ag-grid-community/dist/ag-grid-community.min.js"></script>
    <link rel="stylesheet" href="../style_bargain.css">
    <link rel="stylesheet" href="../CSS/titlebar.css">
</head>
<body>
    <div class="container">
        <form action="Bargain" method="post">
            <table>
                <tr>
                    <input type="text" id="bargain_price" name="bidPrice" placeholder="please input your bid">
                </tr>
                <tr>
                    <input type="submit" value="Place Bid">
                </tr>
            </table>
        </form>

        <nav class="nav-container">
            <ul>
                <li class="nav-item"><a class="nav-link" href="/webreg/Explore">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="/webreg/Sell">Sell</a></li>
                <li class="nav-item"><a class="nav-link" href="/webreg/User">User</a></li>
                <li class="nav-item"><a class="nav-link" href="/webreg/Report">Issues</a></li>
                <li class="nav-item"><a class="nav-link" href="/webreg">Register/Login</a></li>
            </ul>
        </nav>
    </div>
    <div class="seperator"></div>
    <div class="container_2">

        <div id="myGrid" style="width: 100%; height: 78vh; " class="ag-theme-alpine"></div>

        <script>
            function NameCellRenderer() { }

            NameCellRenderer.prototype.init = function (params) {
                this.eGui = document.createElement('div');
                var link = document.createElement('a');
                var itemId = params.node.data.id;
                link.href = 'http://localhost:8080/webreg/History/' + itemId;
                link.innerText = params.value;
                this.eGui.appendChild(link);
            };

            NameCellRenderer.prototype.getGui = function () {
                return this.eGui;
            };

            function NameCellRenderer2() { }

            NameCellRenderer2.prototype.init = function (params) {
                this.eGui = document.createElement('div');
                var link = document.createElement('a');
                var itemId = params.node.data.id;
                link.href = 'http://localhost:8080/webreg/AutoBid/' + itemId;
                link.innerText = params.value;
                this.eGui.appendChild(link);
            };

            NameCellRenderer2.prototype.getGui = function () {
                return this.eGui;
            };

            var columnDefs = [
                { headerName: "Name", field: "a", sortable: true, flex: 1, cellRenderer: NameCellRenderer },
                { headerName: "Initial Price", field: "b", sortable: true, flex: 1 },
                { headerName: "Increment", field: "c", sortable: true, flex: 1 },
                { headerName: "Current Price", field: "d", sortable: true, flex: 1 },
                { headerName: "End date", field: "e", sortable: true, flex: 1 },
                { headerName: "Description", field: "f", sortable: true, flex: 1 },
                { headerName: "Seller", field: "g", sortable: true, flex: 1 },
                { headerName: "Type", field: "h", sortable: true, flex: 1 },
                { headerName: "Property", field: "i", sortable: true, flex: 1 },
                { headerName: "AutoBid", field: "j", sortable: true, flex: 1, cellRenderer: NameCellRenderer2 }
            ];

            // Data
            // Get the tableItemsJson attribute from the request object
            var tableItemsJson = '<%= request.getAttribute("tableItemsJson") %>';

            // Parse the JSON string into a JavaScript object
            var tableItems = JSON.parse(tableItemsJson) || [];

            // Convert the tableItems object to the format expected by rowData
            var rowData = tableItems.map(function (item) {
                return {
                    id: item.id,
                    a: item.name + "\n" + "show bid history",
                    b: item.initialPrice,
                    c:item.increment,
                    d: item.currentPrice,
                    e: item.endDate,
                    f: item.description,
                    g:item.seller,
                    h:item.type,
                    i:item.property,
                    j:"AutoBid Entry"
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
