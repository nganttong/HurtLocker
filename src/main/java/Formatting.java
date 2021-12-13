public class Formatting {

    public static String capitalize(String s) {
        return Character.toUpperCase((s.charAt(0))) + s.substring(1);
    }

    public static String stringFormatName(String name, int count) {
        String time = (count > 1) ? "times" : "time";
        return (String.format("Name: %7s%6sSeen: %d " + time, capitalize(name), "", count));
    }

    public static String stringFormatPrice(Double price, int count, String label1, String label2) {
        String time = (count > 1) ? "times" : "time";
        return String.format("%7s%6.2f%5s%7s%d " + time + "\n",label1 + ": ", price,"",label2 + ": ", count);
    }

    public static String errorLine(int count) {
        String time = (count > 1) ? "times" : "time";
        return (String.format("%s%19s%2d " + time, "Errors", "Seen: ", count));
    }

    public static String singleLine() {
        return (String.format("%8s%6s%8s\n\n", "-------------", "", "-------------"));
    }

    public static String dividerLine() {
        return (String.format("\n%8s%6s%8s\n", "÷÷÷÷÷÷÷÷÷÷÷÷÷", "", "÷÷÷÷÷÷÷÷÷÷÷÷÷"));
    }
}
