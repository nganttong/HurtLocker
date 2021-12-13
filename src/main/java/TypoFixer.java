public class TypoFixer {
    //a way to convert/change numbers to letters
    //does capitalization matter?
    //does first litter of words like milk, cookies, apples need to be capital?

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


}
