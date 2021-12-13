public class DuplicateItems {
    private String name;
    private int count;
    private Prices prices;

    public DuplicateItems(String name, int count, Prices prices) {
        this.name = name;
        this.count = count;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }
}
