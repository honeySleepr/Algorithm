package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
/*처음 색 2개는 저항의 값, 마지막 색은 곱해야 하는 값*/

public class BJ1076 {
    static Map<String, int[]> resistanceMap = Map.of(
        "black", new int[] {0, 1},
        "brown", new int[] {1, 10},
        "red", new int[] {2, 100},
        "orange", new int[] {3, 1000},
        "yellow", new int[] {4, 10000},
        "green", new int[] {5, 100000},
        "blue", new int[] {6, 1000000},
        "violet", new int[] {7, 10000000},
        "grey", new int[] {8, 100000000},
        "white", new int[] {9, 1000000000}
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] color = new String[3];
        for (int i = 0; i < 3; i++) {
            color[i] = br.readLine();
        }
        int value1 = resistanceMap.get(color[0])[0];
        int value2 = resistanceMap.get(color[1])[0];

        String stringNum = Integer.toString(value1) + (value2);

        long value3 = resistanceMap.get(color[2])[1];

        long answer = (Integer.parseInt(stringNum) * value3);

        System.out.println(answer);
    }

}
