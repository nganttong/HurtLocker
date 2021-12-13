import java.util.HashMap;

public class Prices {
    private HashMap<Double, Integer> prices = new HashMap<Double, Integer>();

    //see how many times the same price appears
    public void howManyTimesPriceAppears (double price){
        //(price, counting occurrences)
        prices.put(price, prices.get(price) + 1);
    }

    //add new prices
    public void addPrice (double price) {
        prices.put(price, 1);
    }

    //some dont have prices????
    //see all prices
    public HashMap<Double, Integer> getAllPrices() {
        return prices;
    }
    //see how many have prices?
    //milk is pretty cheap...

    //get how many times a price has appeared
    public Integer getPriceCount(double price) {
        return prices.get(price);
    }
}
