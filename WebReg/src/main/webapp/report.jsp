<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Report Page</title>

        <link rel="stylesheet" href="./style_report.css">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="./CSS/titlebar.css">
        <style>
            .custom-bootstrap * {
                box-sizing: border-box;
            }

            .custom-bootstrap .issue-card {
                width: 25%;
                min-width: 300px;
            }

            .card-container {
                max-height: 600px;
                overflow: auto;
                overflow-y: auto;
            }

            .search-form {
                display: flex;
                justify-content: center;
                margin-bottom: 2rem;
            }

            .search-input {
                width: 50%;
                padding: 0.5rem;
                border-radius: 0.25rem 0 0 0.25rem;
                border: 1px solid #ced4da;
            }

            .search-button {
                background-color: #007bff;
                color: white;
                padding: 0.5rem 1rem;
                border-radius: 0 0.25rem 0.25rem 0;
                border: none;
                cursor: pointer;
            }

            .search-button:hover {
                background-color: #0056b3;
            }

            .issue-card {
                border: 1px solid #ced4da;
                border-radius: 0.25rem;
            }

            .issue-card .card-header {
                background-color: #f8f9fa;
                border-bottom: 1px solid #ced4da;
            }

            .issue-card .btn-link {
                color: #007bff;
                font-size: 0.9rem;
            }

            .issue-card .btn-link:hover {
                color: #0056b3;
            }
        </style>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


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
            <!-- Collapsible toggle for the form -->
            <div class="card mt-3">
                <div class="card-header">
                    <h5 class="mb-0">
                        <button class="btn btn-link" type="button" data-bs-toggle="collapse"
                            data-bs-target="#addQuestionCollapse" aria-expanded="false"
                            aria-controls="addQuestionCollapse">
                            Add a new question
                        </button>
                    </h5>
                </div>

                <div id="addQuestionCollapse" class="collapse">
                    <div class="card-body">
                        <!-- Form for submitting new questions -->
                        <form id="addQuestionForm" method="POST" action="/webreg/Report"
                            onsubmit="return submitQuestion();">
                            <div class="mb-3">
                                <label for="questionTitle" class="form-label">Issue Title</label>
                                <input type="text" class="form-control" name="questionTitle" id="questionTitle"
                                    required>
                            </div>
                            <div class="mb-3">
                                <label for="questionContent" class="form-label">Issue Content</label>
                                <textarea class="form-control" name="questionContent" id="questionContent" rows="4"
                                    required></textarea>
                            </div>
                            <!-- Set the value according to the current user -->
                            <button type="submit" class="btn btn-primary">Submit Question</button>
                        </form>
                    </div>
                </div>

                <script>
                    async function submitQuestion() {
                        const questionTitle = document.getElementById("questionTitle").value;
                        const questionContent = document.getElementById("questionContent").value;

                        const formData = new FormData();
                        formData.append("questionTitle", questionTitle);
                        formData.append("questionContent", questionContent);

                        const response = await fetch("/webreg/Report", {
                            method: "POST",
                            body: formData
                        });

                        const resultJson = await '<%= request.getAttribute("resultJson") %>';
                        const resultObj = JSON.parse(resultJson);

                        if (resultJson) {

                            alert(resultObj.message);
                        }

                        return false;
                    }
                </script>

            </div>


            <!-- Search bar -->
            <h2>Search Issues You Meet</h2>

            <form class="search-form" action="/webreg/Report" method="GET">
                <input class="search-input" type="search" name="query" placeholder="Search Everything You Want"
                    aria-label="Search">
                <button class="search-button" type="submit">Search</button>
            </form>

            <div class="row" id="card-container"></div>

            <script>
                const rawData = '<%= request.getAttribute("QuestionTable") %>';
                const data = JSON.parse(rawData);

                console.log(data);

                function createCard(data) {
                    const uniqueId = data.idquestion;
                    const hasAnswerProvided = data.answer && data.answer.trim().length > 0;
                    const hasAnswered = hasAnswerProvided ? 'Answered' : 'Not Answered';

                    return `
                        <div class="card issue-card">
                            <div class="card-header d-flex justify-content-between" id="questionHeading${uniqueId}">
                                <div>
                                    <h5 class="card-title d-inline mb-0" id="uniqueId${uniqueId}"> Issue[${uniqueId}]: ${data.questionTitle}</h5>
                                    <span class="badge ${hasAnswerProvided ? 'bg-success' : 'bg-danger'} ms-2">${hasAnswered}</span>
                                </div>
                                <button class="btn btn-link text-decoration-none" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#questionContent${uniqueId}" aria-expanded="true" aria-controls="questionContent${uniqueId}">
                                    View
                                </button>
                            </div>
                            <div id="questionContent${uniqueId}" class="collapse">
                                <div class="card-body">
                                    <p class="card-text mb-2">Author: ${data.username}</p>
                                    
                                    <p class="card-text mb-2">${data.question}</p>

                                    <h4 class="mt-4 mb-2">
                                        ${hasAnswerProvided ? 'Answered:' : ''}   
                                    </h4>
                                    <p class="card-text">${hasAnswerProvided ? data.answer : 'No answer provided yet.'}</p>
                                </div>
                            </div>
                        </div>
                    `;
                }

                function displayData(data) {
                    const cardContainer = document.getElementById("card-container");
                    let cards = "";

                    data.forEach(item => {
                        cards += createCard(item);
                    });

                    cardContainer.innerHTML = cards;
                }

                displayData(data);
            </script>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
        <script src="https://cdn.polyfill.io/v3/polyfill.min.js?features=fetch"></script>

    </body>

    </html>