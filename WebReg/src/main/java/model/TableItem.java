package model;

import java.sql.Date;

public class TableItem {
    String name;
    Double initialPrice;
    Double finalPrice;
    Date endDate;
    String description;

    public String getName() {
        return name;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public TableItem(String name, Double initialPrice, Double finalPrice, Date endDate, String description) {
        this.name = name;
        this.initialPrice = initialPrice;
        this.finalPrice = finalPrice;
        this.endDate = endDate;
        this.description = description;
    }
}
