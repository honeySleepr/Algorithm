package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <br><h2>comment : 연속합 복습 </h2>
 */
public class BJ1912_Practice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(split[i]);
        }

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i] + dp[i - 1], dp[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
