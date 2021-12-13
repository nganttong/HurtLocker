import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GroceryItemParseTest {
    private String twoItemList = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016";

    GroceryItemParse groceryIP;

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
}