# C2C-Auction-System

## Checking List
- [ ] Create accounts of users; 
    - [ ] login
    之后发生什么
    - [ ] logout.
    
### I. Auctions
- [ ] seller creates auctions and posts items for sale (WYT)
    - [ ] set all the characteristics of the item
    - [ ] set closing date and time
    - [ ] set a hidden minimum price (reserve)

- [ ] a buyer should be able to bid
    - [ ] let the buyer set a new bid
    - [ ] in case of automatic bidding set secret upper limit and bid increment
    THIS alert 追踪购买情况
    - [ ] alert other buyers of the item that a higher bid has been placed (manual)
    - [ ] alert buyers in case someone bids more than their upper limit (automatic)

- [ ] define the winner of the auction
    - [ ] when the closing time has come, check if the seller has set a reserve
        - [ ] if yes: if the reserve is higher than the last bid none is the winner.
        - [ ] if no: whoever has the higher bid is the winner
            - [ ] alert the winner that they won the auction

### II. Browsing and advanced search functionality
- [ ] let people browse on the items and see the status of the current bidding 
- [ ] sort by different criteria (by type, bidding price etc.)
- [ ] search the list of items by various criteria.

- [ ] a user should be able to:
    - [ ] view all the history of bids for any specific auction
    - [ ] view the list of all auctions a specific buyer or seller has participated in
    - [ ] view the list of "similar" items on auctions in the preceding month (and auction information about them)
- [ ] let user set an alert for specific items s/he is interested (WYT)
    - [ ] get an alert when the item becomes available

Discussion board
- [ ] users browse questions and answers
- [ ] users search questions by keywords

### III. Admin and customer rep functions
- [ ] Admin (create an admin account ahead of time) (WYT)
    - [ ] creates accounts for customer representatives
    - [ ] generates sales reports for:
        - [ ] total earnings
        - [ ] earnings per:
            - [ ] item
            - [ ] item type
            - [ ] end-user
        - [ ] best-selling items
        - [ ] best buyers
- [ ] Customer representative functions:
    - [ ] users post questions to the customer representatives (i.e. customer service)
    - [ ] reps reply to user questions
    - [ ] edits and deletes account information
    - [ ] removes bids 
    - [ ] removes auctions

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
Insert Data

Goal: This weekend


Define winner  Admin Buy
