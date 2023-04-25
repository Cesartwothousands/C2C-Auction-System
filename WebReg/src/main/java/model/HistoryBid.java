package model;

public class HistoryBid {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    int id;
    String userName;
    String itemName;
    String itemType;
    double bid_price;
    String end_date;
    String seller;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getitemType() {
        return itemType;
    }

    public void setitemType(String itemType) {
        this.itemType = itemType;
    }

    public double getBid_price() {
        return bid_price;
    }

    public void setBid_price(double bid_price) {
        this.bid_price = bid_price;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public HistoryBid(int id, String userName, String itemName, String itemType, double bid_price, String end_date, String seller) {
        this.id = id;
        this.userName = userName;
        this.itemName = itemName;
        this.itemType = itemType;
        this.bid_price = bid_price;
        this.end_date = end_date;
        this.seller = seller;
    }


}
