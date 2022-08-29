package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <br><h2>comment : 계단 오르기 복습 </h2>
 */
public class BJ2579_Practice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] input = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[1] = input[1];
        if (N >= 2) {
            dp[2] = input[1] + input[2];
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = input[i] + Math.max(dp[i - 3] + input[i - 1], dp[i - 2]);
        }
        System.out.println(dp[N]);
    }

}
