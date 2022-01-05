package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ10809 {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        int[] answer = new int[26];
        Arrays.fill(answer, -1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            /* a : 10, b : 11 ... 이므로 -10*/
            int abcIndex = Character.getNumericValue(arr[i]) - 10;
            if (!set.contains(abcIndex)) {
                set.add(abcIndex);
                answer[abcIndex] = i;
            }
        }
        System.out.println(Arrays.toString(answer)
                .replace("[", "")
                .replace(",", "")
                .replace("]", ""));
    }
}