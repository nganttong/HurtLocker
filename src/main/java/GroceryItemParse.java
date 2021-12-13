import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryItemParse {
    public static boolean hasSymbol (String string) {
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


}
