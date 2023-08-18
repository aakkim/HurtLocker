import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MainTest{

    @Test
    public void testWordCheck() {
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016";
        String output = Main.wordCheck(input);
        System.out.println(output);
        Assert.assertNotEquals(input, output);
    }

    @Test
    public void testCleanData() {
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016";
        List<GroceryItem> output = Main.cleanData(input);
        System.out.println(output);
        Assert.assertEquals(output.size(), 5);
    }
}