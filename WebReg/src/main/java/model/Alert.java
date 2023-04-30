package model;

public class Alert {
    private int id;

    private Member user;
    private String itemName;

    public Alert(int id, Member user, String itemName) {
        super();
        this.id = id;
        this.user = user;
        this.itemName = itemName;
    }

    public Member getUser() {
        return user;
    }

    public void setUser(Member user) {
        this.user = user;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
