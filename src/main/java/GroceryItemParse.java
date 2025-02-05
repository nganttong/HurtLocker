import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryItemParse {

    public static boolean hasSymbol(String string) {
        Pattern pattern = Pattern.compile("(:;)|(:%)|(:\\*)|(:@)|(:!)");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    private static List<String> splitStringIntoKVP(String stringPattern, String rawData) {
        return new ArrayList<>(Arrays.asList(rawData.split(stringPattern)));
    }

    public static List<String> rawDataToArray(String rawData){
        String stringPattern = "##";
        return splitStringIntoKVP(stringPattern , rawData);
    }

    public static GroceryItem parseStringToGroceryItem(String rawItem) throws GroceryItemException{
        if (hasSymbol(rawItem)) {
            throw new GroceryItemException();
        } else {
            String[] values = allValues(rawItem.toLowerCase()).split(",");
            return new GroceryItem(TypoFixer.convertAndSameCase(values[0]), Double.parseDouble(values[1]),
                    TypoFixer.convertAndSameCase(values[2]), values[3]);
        }
    }

    public static String returnValue (String pair) {
        return pair.substring(pair.lastIndexOf(":") + 1);
    }

    public static List<String> findKVPInRawData(String rawItem){
        String stringPattern = "[;^%*@!]";
        return splitStringIntoKVP(stringPattern , rawItem);
    }

    public static String allValues(String rawItem) {
        StringBuilder sb = new StringBuilder();
        List<String> pairs = findKVPInRawData(rawItem);
        for (String string: pairs ) {
            sb.append((sb.toString().equals("")) ? returnValue(string) : "," + returnValue(string));
        }
        return sb.toString();
    }

    public static void printToFile(String fileName, String rawItem) throws FileNotFoundException, GroceryItemException {
        Output output = new Output(rawDataToArray(rawItem));
        PrintStream file = new PrintStream(new File(fileName));
        PrintStream console = System.out;

        System.setOut(file);
        System.out.println(output.outputString());
    }

}
