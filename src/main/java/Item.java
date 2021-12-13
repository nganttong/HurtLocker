public class Item {
    private String nameOfItem;
    private Double price;
    private String type;
    private String expiration;

    public Item() {
    }

    public Item(String nameOfItem, Double price, String type, String expiration) {
        this.nameOfItem = nameOfItem;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}
