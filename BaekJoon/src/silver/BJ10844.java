package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1>쉬운 계단 수</h1>
 * <h3>도움!! : O <a href="https://st-lab.tistory.com/134">링크</a></h3>
 * <h3>체감 난이도 : ⭐⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/29</h3>
 * <br><h2>comment : 규칙 생각해내는게 여전히 어렵다. 항상 표를 그려보는 습관을 들여야겠다 </h2>
 */
public class BJ10844 {
    public static final long MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;
                    continue;
                }
                if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % MOD;
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] % MOD + dp[i - 1][j + 1] % MOD;
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        long sum = 0;
        for (int j = 1; j <= 9; j++) {
            sum += dp[N][j] % MOD;
        }

        System.out.println(sum % MOD);
    }
}
