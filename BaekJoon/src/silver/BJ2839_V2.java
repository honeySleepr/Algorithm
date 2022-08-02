package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1>설탕 배달</h1>
 * <h3>도움!! : O</h3>
 * <h3>날짜 : 2022/08/02</h3>
 * <h2>풀이 방법 : 규칙 찾는 것 보다 DP가 더 나은 방법 같다 </h2>
 * <br><h2>comment :</h2>
 */
public class BJ2839_V2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE - 1);
        arr[0] = 0;
        arr[3] = 1;

        for (int i = 5; i <= N; i++) {
            arr[i] = Math.min(arr[i - 5], arr[i - 3]) + 1;
        }

        if (arr[N] >= Integer.MAX_VALUE - 1) {
            System.out.println(-1);
        } else {
            System.out.println(arr[N]);
        }

    }
}
