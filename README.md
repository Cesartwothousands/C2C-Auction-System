# C2C-Auction-System

## Checking List

- [ ] **Insert URL on each page**

- [x] Create accounts of users; 
    - [x] login
    之后发生什么
    - [x] logout.
    
### I. Auctions
- [x] seller creates auctions and posts items for sale (WYT)
    - [x] set all the characteristics of the item
    - [x] set closing date and time
    - [x] set a hidden minimum price (reserve)

- [ ] a buyer should be able to bid
    - [x] let the buyer set a new bid  XQP
    - [ ] in case of automatic bidding set secret upper limit and bid increment
    THIS alert 追踪购买情况
    - [x] alert other buyers of the item that a higher bid has been placed (manual)
    - [x] alert buyers in case someone bids more than their upper limit (automatic)

- [ ] define the winner of the auction XQP
    - [x] when the closing time has come, check if the seller has set a reserve
        - [x] if yes: if the reserve is higher than the last bid none is the winner.
        - [x] if no: whoever has the higher bid is the winner
            - [ ] alert the winner that they won the auction

### II. Browsing and advanced search functionality
- [x] <u>let people browse on the items</u> and see the status of the current bidding (Precisly Bidding) (CZH) ??
- [x] sort by different criteria (by type, bidding price etc.) (Make Property in it) (CZH)
- [x] search the list of items by various criteria. (CZH)
    current price, auction enddate, bid price, item type, property name, seller name, (CZH)

	- [x] a user should be able to:
    - [x] view all the history of bids for any specific auction  XQP
    - [x] view the list of all auctions a specific buyer or seller has participated in XQP
	TODO:
    - [x] view the list of "similar" items on auctions in the preceding month (and auction information about them) XQP
- [x] let user set an alert for specific items s/he is interested (WYT)
    - [x] get an alert when the item becomes available

Discussion board
- [x] users browse questions and answers (CZH)
- [x] users search questions by keywords (CZH)

### III. Admin and customer rep functions
- [x] Admin (create an admin account ahead of time) (WYT)
    - [x] creates accounts for customer representatives
    - [x] generates sales reports for:
        - [x] total earnings
        - [x] earnings per:
            - [x] item
            - [x] item type
            - [x] end-user
        - [x] best-selling items
        - [x] best buyers
- [x] Customer representative functions:

    - [x] users post questions to the customer representatives (i.e. customer service) (CZH)
    - [x] reps reply to user questions (CZH)
    - [x] edits and deletes account information (CZH)
    - [x] removes bids (CZH)
    - [x] removes auctions (CZH)
- [x] Custom representative login (WYT)

-----

- [ ] Sample Data
- [ ] Insert Data

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
    mvn install
    mvn complie
    mvn tomcat7:run
    ```
- visit the website at http://localhost:8080/webreg/
