package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>1로 만들기</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/30</h3>
 * <br><h2>comment : 호오 맞췄다 </h2>
 */
public class BJ1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int min;
        for (int i = 2; i <= n; i++) {
            min = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                min = Math.min(dp[i / 3], min);
            }
            if (i % 2 == 0) {
                min = Math.min(dp[i / 2], min);
            }
            dp[i] = Math.min(dp[i - 1], min) + 1;
        }
        System.out.println(dp[n]);
    }
}
