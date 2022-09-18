package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>Four Squares</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : O</h2>
 * <h2>체감 난이도 : ⭐⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/13</h2>
 * <br><h2>comment : 이 규칙을 어떻게 찾아내지;; </h2>
 */
public class BJ17626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }

        System.out.println(dp[N]);
    }

}
