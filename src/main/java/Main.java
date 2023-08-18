import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static String wordCheck(String input) {
        Pattern pattern = Pattern.compile("\\bC\\w+");
        Matcher matcher = pattern.matcher(input);
        String cookies = matcher.replaceAll("Cookies");

        Pattern pattern1 = Pattern.compile("\\bM\\w+");
        Matcher matcher1 = pattern1.matcher(cookies);
        String milk = matcher1.replaceAll("Milk");

        Pattern pattern2 = Pattern.compile("\\bB\\w+");
        Matcher matcher2 = pattern2.matcher(milk);
        String bread = matcher2.replaceAll("Bread");

        Pattern pattern3 = Pattern.compile("\\ba\\w+");
        Matcher matcher3 = pattern3.matcher(bread);
        return matcher3.replaceAll("Apples");
    }

    public static List<GroceryItem> cleanData(String input) {
        List<GroceryItem> cleanedData = new ArrayList<>();
        int errors = 0;
        String newInput = wordCheck(input);
        String[] list = newInput.split("##");
        for (String l:list) {
            try {
                String[] data = l.split("[:;^%*@!]");
                for (int i = 0; i < data.length; i++) {
                    if(data[1].isEmpty()) {
                        data[1] = "None";
                    } else if(data[3].isEmpty()) {
                        data[3] = "0.00";
                    }
//                    System.out.println(i+": " + data[i]);
                }
                cleanedData.add(new GroceryItem(data[1], data[3], data[5], data[7]));

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ruh roh");
                errors++;
            }
        }
//        System.out.println(errors);
        return cleanedData;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        List<GroceryItem> cleaned = cleanData(output);

        GroceryList list = new GroceryList();
        System.out.println(list.formattedString(cleaned));

    }

}

