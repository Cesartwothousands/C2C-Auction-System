package model;

import java.sql.Date;
import java.util.List;

public class Item {
    String name;
    Date startDate;
    Date endDate;
    Double initialPrice;

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    Double increment;
    Double minimumPrice;
    String description;
    Member seller;

    List<Property> properties;

    Type type;

    public Item(String name, Date startDate, Date endDate, Double initialPrice, Double increment, Double minimumPrice, String description, Member seller, List<Property> properties, Type type, Type type1) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.initialPrice = initialPrice;
        this.increment = increment;
        this.minimumPrice = minimumPrice;
        this.description = description;
        this.seller = seller;
        this.properties = properties;
        this.type = type;
        this.type = type1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Double getIncrement() {
        return increment;
    }

    public void setIncrement(Double increment) {
        this.increment = increment;
    }

    public Double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member getSeller() {
        return seller;
    }

    public void setSeller(Member seller) {
        this.seller = seller;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
