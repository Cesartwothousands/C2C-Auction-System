package model;

import java.sql.Date;

public class TableItem {
    Integer id;
    String name;
    Double initialPrice;
    Double currentPrice;
    Double increment;
    Integer bidnumber;
    String endDate;
    String description;
    String seller;
    String type;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getSeller() {
        return seller;
    }

    public String getType() {
        return type;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Double getIncrement() {
        return increment;
    }

    public Integer getBidnumber() {
        return bidnumber;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public TableItem(Integer id, String name, Double initialPrice, Double currentPrice, Double increment,
            Integer bidnumber, String endDate, String description, String seller, String type) {
        this.id = id;
        this.name = name;
        this.initialPrice = initialPrice;
        this.currentPrice = currentPrice;
        this.increment = increment;
        this.bidnumber = bidnumber;
        this.endDate = endDate;
        this.description = description;
        this.seller = seller;
        this.type = type;
    }
}
