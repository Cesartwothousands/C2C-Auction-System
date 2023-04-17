<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Search Page</title>
        <link rel="stylesheet" href="./style_explore.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="https://cdn.jsdelivr.net/npm/ag-grid-community/dist/ag-grid-community.min.js"></script>


    </head>


    <body>
        <div class="container">
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

        <div class="container_2">

            <div id="myGrid" style="width: 100%; height: 78vh; " class="ag-theme-alpine"></div>

            <script>
                // Table

                var columnDefs = [
                    { headerName: "Name", field: "a", sortable: true, flex: 1.5 },
                    { headerName: "End date", field: "b", sortable: true, flex: 1.5 },
                    { headerName: "Initial Price", field: "c", sortable: true, flex: 1 },
                    { headerName: "Current Price", field: "d", sortable: true, flex: 1 },
                    { headerName: "Increment", field: "e", sortable: true, flex: 1 },
                    //{ headerName: "Bids", field: "f", sortable: true, flex: 1 },
                    { headerName: "Type", field: "g", sortable: true, flex: 1.5 },
                    { headerName: "Seller", field: "h", sortable: true, flex: 1.5 },
                    { headerName: "Description", field: "i", sortable: false, flex: 2 }
                ];

                // Data
                // Get the tableItemsJson attribute from the request object
                var tableItemsJson = '<%= request.getAttribute("SearchTable") %>';
                //console.log(tableItemsJson);

                // Parse the JSON string into a JavaScript object
                var tableItems = JSON.parse(tableItemsJson) || [];

                // Convert the tableItems object to the format expected by rowData
                var rowData = tableItems.map(function (item) {
                    return {
                        a: item.name,
                        b: item.endDate,
                        c: item.initialPrice,
                        d: item.currentPrice,
                        e: item.increment,
                        f: item.bidnumber,
                        g: item.type,
                        h: item.seller,
                        i: item.description
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