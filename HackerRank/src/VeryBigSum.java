import java.util.List;

public class VeryBigSum {

    /*
     * Complete the 'aVeryBigSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */

    public static long aVeryBigSum(List<Long> ar) {
        long answer = 0;
        for (Long l : ar) {
            answer += (long)l;
        }
        return answer;
    }
}
