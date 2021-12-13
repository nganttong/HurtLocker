

public class GroceryItemException extends Exception{
    private static int counter = 0;

    public GroceryItemException () {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
