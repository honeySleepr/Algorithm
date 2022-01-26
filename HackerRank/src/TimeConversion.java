public class TimeConversion {
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     *
     * Sample Input :  07:05:45PM
     * Sample Output : 19:05:45
     */

    public static String timeConversion(String s) {
        int lastIndex = s.length() - 1;

        if (s.charAt(lastIndex - 1) == 'A') {
            if (s.substring(0, 2).equals("12")) {
                return "00" + s.substring(2, lastIndex - 1);
            }
            return s.substring(0, lastIndex - 1);
        }

        if (s.charAt(lastIndex - 1) == 'P') {
            if (s.substring(0, 2).equals("12")) {
                return "12" + s.substring(2, lastIndex - 1);
            }

            int hour = Integer.parseInt(s.substring(0, 2));
            hour = (hour + 12) % 24;
            return hour + s.substring(2, lastIndex - 1);
        }
        return "";
    }

    public static void main(String[] args) {
        TimeConversion.timeConversion("07:05:45PM");
    }

}
