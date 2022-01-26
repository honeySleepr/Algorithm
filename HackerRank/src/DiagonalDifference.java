import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {
    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    //3
    // 11 2 4
    // 4 5 6
    // 10 8 -12
    public static int diagonalDifference(List<List<Integer>> arr) {
        int size = arr.get(0).size();
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < size; i++) {  // 0 1 2
            sum1 += arr.get(i).get(i);
        }
        for (int i = 0; i < size; i++) { // 2 1 0
            sum2 += arr.get(i).get(size - 1 - i);
        }

        System.out.println(Math.abs(sum1 - sum2));
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        List<List<Integer>> listList = new ArrayList<>();

        listList.add(List.of(11, 2, 4));
        listList.add(List.of(4, 5, 6));
        listList.add(List.of(10, 8, -12));

        DiagonalDifference.diagonalDifference(listList);
    }

}
