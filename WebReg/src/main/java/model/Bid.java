package model;

public class Bid {
    private Member member;
    private Item item;
    private double price;
    public Bid(Member member, Item item, double price) {
        super();
        this.member = member;
        this.item = item;
        this.price = price;
    }
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
