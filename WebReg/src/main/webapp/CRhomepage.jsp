<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Explore Page</title>
        <link rel="stylesheet" href="./style_CRhomepage.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="https://cdn.jsdelivr.net/npm/ag-grid-community/dist/ag-grid-community.min.js"></script>
    </head>


    <body>

        <div class="container">
            <!-- Navigation -->
            <div class="Brand-Search">
                <table width="100%">
                    <tr>
                        <td width="50%">
                            <h1>Customer Representative Service</h1>
                        </td>
                        <td width="50%">
                            <a href="/webreg/Register" style=' color:black'>Customer
                                Register</a><br>
                            <a href="/webreg/Login" style=' color:black'>Customer Login</a><br>
                            <a href="/webreg/Logout" style=' color:black'>Logout</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>

        <div class="container_2">

            <a href="/webreg/Reply" style='text-decoration:none; color:black'>
                <h1>Go to Reply Issues</h1>
            </a>

            <div class="form_group">
                <div style=" display: flex; justify-content: center;">
                    <div style="width: 30%; padding: 10px;">
                        <h3>Update User Information</h3>
                        <form action="CRHomepage" method="post">
                            <label for="idUser1">User ID:</label>
                            <input type="number" id="idUser1" name="idUser1" required><br>
                            <label for="newname">New Name:</label>
                            <input type="text" id="newname" name="newname"><br>
                            <label for="newpassword">New Password:</label>
                            <input type="password" id="newpassword" name="newpassword"><br>
                            <input type="hidden" name="action" value="updateUser">
                            <input type="submit" value="Update User">
                        </form>
                    </div>

                    <div style="width: 30%; padding: 10px;">
                        <h3>Delete Bids</h3>
                        <form action="CRHomepage" method="post">
                            <label for="idItem">Item ID:</label>
                            <input type="number" id="idItem" name="idItem" required><br>
                            <label for="idUser2">User ID:</label>
                            <input type="number" id="idUser2" name="idUser2" required><br>
                            <label for="price">Price:</label>
                            <input type="number" step="0.01" id="price" name="price" required><br>
                            <input type="hidden" name="action" value="deleteBids">
                            <input type="submit" value="Delete Bids">
                        </form>
                    </div>

                    <div style="width: 30%; padding: 10px;">
                        <h3>Delete Auction</h3>
                        <form action="CRHomepage" method="post">
                            <label for="idItem2">Item ID:</label>
                            <input type="number" id="idItem2" name="idItem2" required><br>
                            <input type="hidden" name="action" value="deleteAuction">
                            <input type="submit" value="Delete Auction">
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </body>

    </html>