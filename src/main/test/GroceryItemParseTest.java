import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GroceryItemParseTest {
    private String twoItemList = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016";
    private String oneItemList = "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016";
    private String missingItems = "naMe:MilK;priCe:;type:Food;expiration:4/25/2016";
    GroceryItemParse groceryIP;
    GroceryItem groceryItem;

    @Before
    public void setUp() {
        groceryIP = new GroceryItemParse();
    }

    @Test
    public void rawDataToArrayTest(){
        //given
        Integer expected = 2;
        //when
        List<String> items = GroceryItemParse.rawDataToArray(twoItemList);
        Integer actual = items.size();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void stringToGroceryItemTest() throws GroceryItemException{
        //given
        GroceryItem expected = new GroceryItem("bread", 1.23, "food","2/25/2016");
        //when
        GroceryItem actual = GroceryItemParse.parseStringToGroceryItem(GroceryItemParse.rawDataToArray(oneItemList).get(0));
        //then
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void findKVPInRawDataTest(){
        //given
        Integer expected = 4;
        //when
        Integer actual = GroceryItemParse.findKVPInRawData(oneItemList).size();
        //then
        assertEquals(expected, actual);
    }


    @Test(expected = GroceryItemException.class)
    public void parseMissingGroceryItemTest() throws GroceryItemException{
        GroceryItemParse.parseStringToGroceryItem(missingItems);
    }
}