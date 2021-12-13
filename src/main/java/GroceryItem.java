public class GroceryItem {
    private String nameOfItem;
    private double price;
    private String type;
    private String expiration;

    public GroceryItem() {
    }

    public GroceryItem(String nameOfItem, double price, String type, String expiration) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    @Override
    public String toString() {
        return "nameOfItem:" + nameOfItem +
                ", price:" + price +
                ", type:'" + type +
                ", expiration:'" + expiration;
    }
}
