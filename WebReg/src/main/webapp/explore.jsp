<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Explore Page</title>
        <link rel="stylesheet" href="./style_explore.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="https://cdn.jsdelivr.net/npm/ag-grid-community/dist/ag-grid-community.min.js"></script>

        <link rel="stylesheet" href="./CSS/titlebar.css">

    </head>


    <body>
        <div class="container">
            <!-- Navigation -->
            <div class="Brand-Search">

                <button class="ad-search-button">
                    <a href="/webreg/Explore" style='text-decoration:none;'>
                        <h1>
                            C2C Auction System!
                        </h1>
                    </a>
                </button>

                <form class="search-form" action="/webreg/Search" method="GET">
                    <input class="search-input" type="search" name="query" placeholder="Search Everything You Want"
                        aria-label="Search">
                    <button class="search-button" type="submit">
                        <h3>Search</h3>
                    </button>
                </form>

                <button class="search-button">
                    <a href="/webreg/AdvancedSearch" style='text-decoration:none;'>
                        <h3>Advanced</h3>
                    </a>
                </button>
            </div>

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
                    link.href = 'http://localhost:8080/webreg/Bargain/' + itemId;
                    link.innerText = params.value;
                    this.eGui.appendChild(link);
                };

                NameCellRenderer.prototype.getGui = function () {
                    return this.eGui;
                };

                // Table
                var columnDefs = [
                    { headerName: "Name", field: "a", sortable: true, flex: 2, cellRenderer: NameCellRenderer },
                    { headerName: "End date", field: "b", sortable: true, flex: 1.5 },
                    { headerName: "Initial Price", field: "c", sortable: true, flex: 1 },
                    { headerName: "Current Price", field: "d", sortable: true, flex: 1 },
                    { headerName: "Increment", field: "e", sortable: true, flex: 1 },
                    { headerName: "Bids", field: "f", sortable: true, flex: 1 },
                    { headerName: "Type", field: "g", sortable: true, flex: 2 },
                    { headerName: "Seller", field: "h", sortable: true, flex: 2 },
                ];

                // Data
                // Get the tableItemsJson attribute from the request object
                var tableItemsJson = '<%= request.getAttribute("ExploreTable") %>';
                //console.log(tableItemsJson);

                // Parse the JSON string into a JavaScript object
                var tableItems = JSON.parse(tableItemsJson) || [];

                // Convert the tableItems object to the format expected by rowData
                var rowData = tableItems.map(function (item) {
                    return {
                        id: item.id,
                        a: item.name,
                        b: item.endDate,
                        c: item.initialPrice,
                        d: item.currentPrice,
                        e: item.increment,
                        f: item.bidnumber,
                        g: item.type,
                        h: item.seller
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