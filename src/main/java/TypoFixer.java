public class TypoFixer {

    public static Character convertFromNumToLetter(Character numberToLetter) {
        if (numberToLetter.equals('0')) {
            return 'o';
        } else if (numberToLetter.equals('1')) {
            return 'l';
        } else if (numberToLetter.equals('3')) {
            return 'e';
        } else if (numberToLetter.equals('4')) {
            return 'a';
        } else if( numberToLetter.equals('5')) {
            return 's';
        } else if (numberToLetter.equals('7')) {
            return 't';
        } else {
            return numberToLetter;
        }
    }

    public static String converter (String stringToConvert) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stringToConvert.length(); i++) {
            sb.append(convertFromNumToLetter(stringToConvert.charAt(i)));
        }
        return sb.toString();
    }

    public static String makeSameCase (String string) {
        StringBuilder sameCaseString = new StringBuilder(string);
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            sameCaseString.setCharAt(i, c >= 'A' && c <= 'Z' ? (char) (c + 'a' - 'A') : c);
        }
        return sameCaseString.toString();
    }

    public static String convertAndSameCase (String string) {
        return makeSameCase(converter(string));
    }

}
