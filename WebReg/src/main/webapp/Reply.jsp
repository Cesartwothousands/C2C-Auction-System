<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Explore Page</title>
        <link rel="stylesheet" href="./style_CRhomepage.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="https://cdn.jsdelivr.net/npm/ag-grid-community/dist/ag-grid-community.min.js"></script>

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
                <table width="100%">
                    <tr>
                        <td width="50%">
                            <h3>Customer Representative Service</h3>
                        </td>
                        <td width="50%">
                            <a href="/webreg/Register">Customer Register</a><br>
                            <a href="/webreg/Login">Customer Login</a><br>
                            <a href="/webreg/Logout">Logout</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>

        <div class="seperator"></div>

        <div class="container_2">

            <a href="/webreg/CRhomepage.jsp">
                <h2>Customer Representative Homepage</h2>
            </a><br>

            <div class="card mt-3">
                <div class="card-header">
                    <h5 class="mb-0">
                        <button class="btn btn-link" type="button" data-bs-toggle="collapse"
                            data-bs-target="#addQuestionCollapse" aria-expanded="false"
                            aria-controls="addQuestionCollapse">
                            Add reply
                        </button>
                    </h5>
                </div>

                <div id="addQuestionCollapse" class="collapse">
                    <div class="card-body">
                        <!-- Form for submitting new replies -->
                        <form id="addReplyForm" method="POST" action="/webreg/Reply" onsubmit="return submitReply();">
                            <div class="mb-3">
                                <label for="questionId" class="form-label">Question ID</label>
                                <input type="number" class="form-control" name="questionId" id="questionId" required>
                            </div>
                            <div class="mb-3">
                                <label for="answerTitle" class="form-label">Answer Title</label>
                                <input type="text" class="form-control" name="answerTitle" id="answerTitle" required>
                            </div>
                            <div class="mb-3">
                                <label for="answerContent" class="form-label">Answer Content</label>
                                <textarea class="form-control" name="answerContent" id="answerContent" rows="4"
                                    required></textarea>
                            </div>
                            <!-- Set the value according to the current user -->
                            <button type="submit" class="btn btn-primary">Submit Reply</button>
                        </form>
                    </div>
                </div>

                <script>
                    async function submitReply() {
                        const questionId = document.getElementById("questionId").value;
                        const answerTitle = document.getElementById("answerTitle").value;
                        const answerContent = document.getElementById("answerContent").value;

                        if (!questionId || !answerTitle || !answerContent) {
                            alert("All fields are required!");
                            return false;
                        }

                        const formData = new FormData();
                        formData.append("questionId", questionId);
                        formData.append("answerTitle", answerTitle);
                        formData.append("answerContent", answerContent);
                        console.log(formData);
                        const response = await fetch("/webreg/Reply", {
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

            <br>

            <!-- Search bar -->
            <form class="search-form" action="/webreg/Reply" method="GET">
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
                                    <h5 class="card-title d-inline mb-0" id="uniqueId${uniqueId}"> Question[${uniqueId}]: ${data.questionTitle}</h5>
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