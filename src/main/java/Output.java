import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Output {
    private int exceptionCount;
    private HashMap<String, DuplicateItems> allGroceryItemCounts;
    private List<String> rawDataArray;
    private List<GroceryItem> allGroceryItems;

    public Output(List<String> rawDataArray) throws GroceryItemException {
        this.rawDataArray = rawDataArray;
        this.allGroceryItems = new ArrayList<>();
        exceptionCount = 0;

        exceptionsAndCounts();
        sameItemCounter(this.allGroceryItems);
        allGroceryItemCounts = sameItemCounter(this.allGroceryItems);
    }

    public int getExceptionCount() {
        return exceptionCount;
    }

    public HashMap<String, DuplicateItems> getAllGroceryItemCounts() {
        return allGroceryItemCounts;
    }

    public void addExceptionCount() {
        this.exceptionCount = getExceptionCount() + 1;
    }

    public void exceptionsAndCounts() throws GroceryItemException{
        for (String string:this.rawDataArray) {
            if (GroceryItemParse.hasSymbol(string)) {
                addExceptionCount();
            } else {
                allGroceryItems.add(GroceryItemParse.parseStringToGroceryItem(string));
            }
        }
    }

    private HashMap<String, DuplicateItems> sameItemCounter(List<GroceryItem> allGroceryItems) {
        HashMap<String, DuplicateItems> itemCounters = new HashMap<>();
        for (GroceryItem gItem: allGroceryItems) {
            DuplicateItems temp;
            if (!itemCounters.keySet().contains(gItem.getNameOfItem())) {
                temp = new DuplicateItems(gItem.getNameOfItem());
                temp.getPrices().addPrice(gItem.getPrice());
                itemCounters.put(gItem.getNameOfItem(), temp);
            } else {
                temp = itemCounters.get(gItem.getNameOfItem());
                if (!temp.getPrices().getAllPrices().keySet().contains(gItem.getPrice())) {
                    temp.getPrices().addPrice(gItem.getPrice());
                } else {
                    temp.getPrices().howManyTimesPriceAppears(gItem.getPrice());
                }
                temp.setCount(temp.getCount() + 1);
                itemCounters.put(gItem.getNameOfItem(),temp);
            }
        }
        return itemCounters;
    }

    public String outputString() {
        StringBuilder results = new StringBuilder();
        results.append("Grocery List: \n\n");

        for (DuplicateItems string : this.getAllGroceryItemCounts().values()) {
            results.append(Formatting.stringFormatName(string.getName(), string.getCount()));
            results.append(Formatting.dividerLine());

            for (Double aDouble : string.getPrices().getAllPrices().keySet()) {
                results.append(Formatting.stringFormatPrice(aDouble, string.getPrices().getPriceCount(aDouble), "Price", "Seen"));
                results.append(Formatting.singleLine());
            }
        }
        results.append(Formatting.errorLine(this.getExceptionCount()));
        return results.toString();
    }
}
