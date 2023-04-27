<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Auto Bid Page</title>
        <link rel="stylesheet" href="./style_login.css">
        <link rel="stylesheet" href="./titlebar.css">
    </head>

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
            <form action="AutoBid" method="post">
                <table>
                    <h2>
                        Place your auto bid
                    </h2>

                    <br />
                    Put your hidden upperlimit here:
                    <tr>
                        <input type="number" name="upperlimit">
                    </tr>

                    <br />

                    <tr>
                        <input type="submit" value="Place Bid">
                    </tr>
                </table>
            </form>
            <div class="drops">
                <div class="drop drop-1"></div>
                <div class="drop drop-2"></div>
                <div class="drop drop-3"></div>
                <div class="drop drop-4"></div>
                <div class="drop drop-5"></div>
            </div>
        </div>
    </body>

    </html>