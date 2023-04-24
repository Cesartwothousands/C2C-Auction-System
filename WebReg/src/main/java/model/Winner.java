package model;

public class Winner {
    int idItem;
    String itemName;
    String userName;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Winner(int idItem, String itemName, String userName) {
        this.idItem = idItem;
        this.itemName = itemName;
        this.userName = userName;
    }
}
