package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1>직각삼각형</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/22</h3>
 * <br><h2>comment :</h2>
 */
public class BJ4153 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] split = br.readLine().split("\\s");
            if (split[0].equals("0")) {
                break;
            }
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            Arrays.sort(arr);
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            if ((a * a + b * b) == c * c) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }
        System.out.println(sb);
    }
}
