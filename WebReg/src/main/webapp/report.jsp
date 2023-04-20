<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Report Page</title>

        <link rel="stylesheet" href="./style_report.css">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .custom-bootstrap * {
                box-sizing: border-box;
            }

            .custom-bootstrap .issue-card {
                width: 25%;
                min-width: 300px;
            }
        </style>

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

            <div class="card issue-card">
                <div class="card-header d-flex justify-content-between" id="issueHeading">
                    <div>
                        <h5 class="card-title d-inline mb-0">Issue No. x</h5>
                        <span class="badge bg-danger ms-2">Not Resolved</span>
                        <!-- Use 'bg-success' class for resolved issues -->
                        <!-- <span class="badge bg-success">Resolved</span> -->
                    </div>
                    <button class="btn btn-link text-decoration-none" type="button" data-bs-toggle="collapse"
                        data-bs-target="#issueContent" aria-expanded="true" aria-controls="issueContent">
                        View
                    </button>
                </div>
                <div id="issueContent" class="collapse">
                    <div class="card-body">
                        <p class="card-text mb-2">Author: John Doe</p>
                        <h6 class="card-subtitle mb-2 text-muted">Issue content:</h6>
                        <p class="card-text mb-2">This is a description of the issue reported.</p>
                        <h6 class="mt-4 mb-2">Reply:</h6>
                        <p class="card-text">Reply content goes here. This is a response to the reported issue.</p>
                    </div>
                </div>
            </div>



        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>

    </body>

    </html>