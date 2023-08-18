import org.junit.Assert;
import org.junit.Test;


public class GroceryItemTest {
    @Test
    public void getName() {
        String expected = "Me";
        GroceryItem item = new GroceryItem("Candy", "3.25", "Food", "3/04/2025");
        item.setName("Me");
        Assert.assertEquals(expected, item.getName());
    }


    @Test
    public void getPrice() {
        String expected = "1.00";
        GroceryItem item = new GroceryItem("Candy", "3.25", "Food", "3/04/2025");
        item.setPrice("1.00");
        Assert.assertEquals(expected, item.getPrice());
    }

    @Test
    public void getType() {
        String expected = "Liquid";
        GroceryItem item = new GroceryItem("Candy", "3.25", "Food", "3/04/2025");
        item.setType("Liquid");
        Assert.assertEquals(expected, item.getType());
    }

    @Test
    public void getExpiration() {
        String expected = "1/15/2027";
        GroceryItem item = new GroceryItem("Candy", "3.25", "Food", "3/04/2025");
        item.setExpiration("1/15/2027");
        Assert.assertEquals(expected, item.getExpiration());
    }

}