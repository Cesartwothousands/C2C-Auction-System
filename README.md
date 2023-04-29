# C2C-Auction-System

# Checklist
## -1. Initialize
## 0. Accounts
- [ ] Create accounts of users;
- http://localhost:8080/webreg/
- [ ] Login, logout.
- http://localhost:8080/webreg/Login
- http://localhost:8080/webreg/Logout
## 1. Auctions
- [ ] seller creates auctions and posts items for sale
    - [ ] set all the characteristics of the item
    - [ ] set closing date and time
    - [ ] set a hidden minimum price (reserve)
- http://localhost:8080/webreg/Sell
- [ ] a buyer should be able to bid
    - [ ] let the buyer set a new bid
    - [ ] in case of automatic bidding set secret upper limit and bid increment
    - [ ] alert other buyers of the item that a higher bid has been placed (manual)
    - [ ] alert buyers in case someone bids more than their upper limit (automatic)
- http://localhost:8080/webreg/Bargain/<int:itemId>
- http://localhost:8080/webreg/autobid.jsp

- [ ]  define the winner of the auction
    - [ ] when the closing time has come, check if the seller has set a reserve
    - [ ]  if yes: if the reserve is higher than the last bid none is the winner.
    - [ ] if no: whoever has the higher bid is the winner
        - [ ] alert the winner that they won the auction
- http://localhost:8080/webreg/User

## 2. Browsing and advanced search functionality
- [ ] let people browse on the items and see the status of the current bidding
- [ ] sort by different criteria (by type, bidding price etc.)
- [ ] search the list of items by various criteria.
- [ ] a user should be able to:
    - [ ] view all the history of bids for any specific auction
    - [ ] view the list of all auctions a specific buyer or seller has participated in
    - [ ] view the list of "similar" items on auctions in the preceding month (and auction information about them)
    - [ ] let user set an alert for specific items s/he is interested
        - [ ] get an alert when the item becomes available
    - [ ] users browse questions and answers
    - [ ] users search questions by keywords
- http://localhost:8080/webreg/Explore
- http://localhost:8080/webreg/Search?query=<string:query>
- http://localhost:8080/webreg/AdvancedSearch
- http://localhost:8080/webreg/AdvancedSearch?query=<string:query>
- http://localhost:8080/webreg/Report
- http://localhost:8080/webreg/Report?query=<string:query>
- http://localhost:8080/webreg/History/<string:query>

## 3. Admin and customer rep functions
- [ ] Admin (create an admin account ahead of time)
    - [ ] creates accounts for customer representatives
    - [ ] generates sales reports for:
        - [ ] total earnings
        - [ ] earnings per: 
            - [ ] item
            - [ ] item type
            - [ ] end-user
    - [ ] best-selling items
    - [ ] best buyers
- http://localhost:8080/webreg/Admin
- [ ] Customer representative functions:
    - [ ] users post questions to the customer representatives (i.e. customer service)
    - [ ] reps reply to user questions
    - [ ] edits and deletes account information
    - [ ] removes bids 
    - [ ] removes auctions
- http://localhost:8080/webreg/CRHomepage
- http://localhost:8080/webreg/Reply
- http://localhost:8080/webreg/Reply?query=<string:query>
-----
## WYT
Auction Seller 
Browser5
Admin

## XQP
Auction Buyer
Browser4

## CZH
Browser1-3 67
Customer Rep

## How to Use

- Run Insert.sql with your local mysql database.
- Change the connection url and password in `WebReg\src\main\java\controller\DBConfig.java` to your url and password. 
- If you do not have maven installed in your computer, install maven. See https://maven.apache.org/install.html.
- Run the following code in command line with the project base directory:
    ```
    cd WebReg
    mvn compile
    mvn tomcat7:run
    ```
- visit the website at http://localhost:8080/webreg/
