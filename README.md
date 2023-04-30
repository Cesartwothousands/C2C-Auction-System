# C2C-Auction-System

# Checklist

## How to Use

- Open source file from zip submission or github(https://github.com/Cesartwothousands/C2C-Auction-System).

- Run 3schema.sql with your local mysql database.

- Change the connection url and password in `WebReg\src\main\java\controller\DBConfig.java` to your url and password. 

- If you do not have maven installed in your computer, install maven. See https://maven.apache.org/install.html.

- Run the following code in command line with the project base directory:

  ```
  cd WebReg
  mvn compile
  mvn tomcat7:run
  ```

- visit the website at http://localhost:8080/webreg/

- administrative_stuff:
  - admin@example.com
  - adminPassword
-  representatives:
  - rep1@example.com, rep1_password
  - rep2@example.com, rep2_password
  - ...
- end_user:
  - johndoe@example.com, password123
  - janesmith@example.com, password456
  - ...

## 0. Accounts

- [x] Create accounts of users;
- http://localhost:8080/webreg/
- [x] Login, logout.
- http://localhost:8080/webreg/Login
- http://localhost:8080/webreg/Logout

## 1. Auctions

- [x] seller creates auctions and posts items for sale
  - [x] set all the characteristics of the item
  - [x] set closing date and time
  - [x] set a hidden minimum price (reserve)
- http://localhost:8080/webreg/Sell
- [x] a buyer should be able to bid
  - [x] let the buyer set a new bid
  - [x] in case of automatic bidding set secret upper limit and bid increment
  - [x] alert other buyers of the item that a higher bid has been placed (manual)
  - [x] alert buyers in case someone bids more than their upper limit (automatic)
- http://localhost:8080/webreg/Bargain/<int:itemId>
- http://localhost:8080/webreg/autobid.jsp

- [x] define the winner of the auction
  - [x] when the closing time has come, check if the seller has set a reserve
  - [x] if yes: if the reserve is higher than the last bid none is the winner.
  - [x] if no: whoever has the higher bid is the winner
    - [x] alert the winner that they won the auction
- http://localhost:8080/webreg/User

## 2. Browsing and advanced search functionality

- [x] let people browse on the items and see the status of the current bidding
- [x] sort by different criteria (by type, bidding price etc.)
- [x] search the list of items by various criteria.
- [x] a user should be able to:
  - [x] view all the history of bids for any specific auction
  - [x] view the list of all auctions a specific buyer or seller has participated in
  - [x] view the list of "similar" items on auctions in the preceding month (and auction information about them)
  - [x] let user set an alert for specific items s/he is interested
    - [x] get an alert when the item becomes available
  - [x] users browse questions and answers
  - [x] users search questions by keywords
- http://localhost:8080/webreg/Explore
- http://localhost:8080/webreg/Search?query=<string:query>
- http://localhost:8080/webreg/AdvancedSearch
- http://localhost:8080/webreg/AdvancedSearch?query=<string:query>
- http://localhost:8080/webreg/Report
- http://localhost:8080/webreg/Report?query=<string:query>
- http://localhost:8080/webreg/History/<string:query>

## 3. Admin and customer rep functions

- [x] Admin (create an admin account ahead of time)
  - [x] creates accounts for customer representatives
  - [x] generates sales reports for:
    - [x] total earnings
    - [x] earnings per: 
      - [x] item
      - [x] item type
      - [x] end-user
  - [x] best-selling items
  - [x] best buyers
- http://localhost:8080/webreg/Admin
- [x] Customer representative functions:
  - [x] users post questions to the customer representatives (i.e. customer service)
  - [x] reps reply to user questions
  - [x] edits and deletes account information
  - [x] removes bids 
  - [x] removes auctions
- http://localhost:8080/webreg/CRLogin
- http://localhost:8080/webreg/CRHomepage
- http://localhost:8080/webreg/Reply
- http://localhost:8080/webreg/Reply?query=<string:query>