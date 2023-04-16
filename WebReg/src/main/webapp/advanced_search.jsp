<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Search Page</title>
        <link rel="stylesheet" href="./style_advancedsearch.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="https://cdn.jsdelivr.net/npm/ag-grid-community/dist/ag-grid-community.min.js"></script>


    </head>


    <body>
        <div class="container">
            <!-- Navigation -->
            <div class="Brand-Search">
                <a class="navbar-brand" href="">
                    <h1>&nbsp;&nbsp;&nbsp;C2C Auction System!&nbsp;&nbsp;</h1>
                </a>

                <form action="/webreg/Search" method="GET">
                    <input class="search-input" type="search" name="query" placeholder="Search Everything You Want"
                        aria-label="Search">
                    <button class="search-button" type="submit">Search</button>
                </form>
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

        <div class="container_3">

        </div>

        <div class="container_2">

            <div id="myGrid" style="width: 100%; height: 78vh; " class="ag-theme-alpine"></div>

            <script>
                // Table

                var columnDefs = [
                    { headerName: "Name", field: "a", sortable: true, flex: 1 },
                    { headerName: "Initial Price", field: "b", sortable: true, flex: 1 },
                    { headerName: "Current Price", field: "c", sortable: true, flex: 1 },
                    { headerName: "End date", field: "d", sortable: true, flex: 1 },
                    { headerName: "Description", field: "e", sortable: true, flex: 1 },
                ];

                // Data
                // Get the searchResultsJson attribute from the request object
                var searchResultsJson = '<%= request.getAttribute("searchResultsJson") %>';
                var searchResults = JSON.parse(searchResultsJson) || [];

                // Convert the tableItems object to the format expected by rowData
                var rowData = searchResults.map(function (item) {
                    return {
                        a: item.name,
                        b: item.initialPrice,
                        c: item.initialPrice + item.increment,
                        d: item.endDate,
                        e: item.description
                    };
                });


                var gridOptions = {
                    columnDefs: columnDefs,
                    rowData: rowData,
                    defaultColDef: {
                        resizable: false,
                        filter: false
                    },
                    suppressMovableColumns: true,
                    enableCellTextSelection: true
                };

                new agGrid.Grid(document.getElementById("myGrid"), gridOptions);

            </script>
        </div>

    </body>

    </html>