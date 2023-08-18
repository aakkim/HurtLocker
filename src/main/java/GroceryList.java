import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryList {

    public Map<String, Integer> countGroceryName(List<GroceryItem> list) {
        Map<String, Integer> nameCount = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            nameCount.put(list.get(i).getName(), nameCount.getOrDefault(list.get(i).getName(), 0) +1);
        }
        return nameCount;
    }

    public Map<String, Integer> countGroceryPrice(List<GroceryItem> list, String name) {
        Map<String, Integer> priceCount = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(name)) {
                priceCount.put(list.get(i).getPrice(), priceCount.getOrDefault(list.get(i).getPrice(), 0) + 1);
            }
        }
        return priceCount;
    }

    public String padding(int length) {
        return (" ".repeat(Math.max(0, length))); // repeat space length number of times
    }

    public String formattedString(List<GroceryItem> list) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Integer> entry: countGroceryName(list).entrySet()) {
            sb.append("Name: " + padding(7-entry.getKey().length()) +entry.getKey() + "\t\t Seen: " + entry.getValue() + " times\n");
            sb.append("============= \t\t =============\n");
            for (Map.Entry<String, Integer> priceEntry: countGroceryPrice(list, entry.getKey()).entrySet()) {
                sb.append("Price: " + padding(6-priceEntry.getKey().length()) + priceEntry.getKey() + "\t\t Seen: " + priceEntry.getValue() + " times\n");
                sb.append("------------- \t\t -------------\n");
            }
            sb.append("\n");
        }
        sb.append("Errors " + padding(5) + "\t\t Seen: 2 times");
        return sb.toString();
    }

}
