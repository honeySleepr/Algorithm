import java.util.Arrays;
import java.util.List;

public class CompareTheTriplets {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a,
        List<Integer> b) {
        Integer[] arr = new Integer[] {0, 0};

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                arr[0]++;
                continue;
            }
            if (a.get(i) < b.get(i)) {
                arr[1]++;
                continue;
            }
        }
        return Arrays.asList(arr);
    }

}
