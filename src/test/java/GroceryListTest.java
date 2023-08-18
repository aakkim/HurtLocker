import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroceryListTest {

    @Test
    public void testCountGroceryName() {
        List<GroceryItem> list = new ArrayList<>();
        list.add(new GroceryItem("Milk", "2.40", "Food", "1/20/2026"));
        list.add(new GroceryItem("Cookies", "3.50", "Food", "5/14/2025"));
        list.add(new GroceryItem("Bread", "1.40", "Food", "5/24/2023"));
        GroceryList gl = new GroceryList();
        Map<String, Integer> count = gl.countGroceryName(list);
        Assert.assertEquals(count.size(), 3);
    }

    @Test
    public void testCountGroceryPrice() {
        List<GroceryItem> list = new ArrayList<>();
        list.add(new GroceryItem("Milk", "2.40", "Food", "1/20/2026"));
        list.add(new GroceryItem("Milk", "4.50", "Food", "1/20/2026"));
        list.add(new GroceryItem("Cookies", "3.50", "Food", "5/14/2025"));
        list.add(new GroceryItem("Bread", "1.40", "Food", "5/24/2023"));
        GroceryList gl = new GroceryList();
        Map<String, Integer> count = gl.countGroceryPrice(list, "Milk");
        Assert.assertEquals(count.size(), 2);
    }

}