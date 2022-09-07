package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>피보나치 함수</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/07</h2>
 * <br><h2>comment : DP 풀이 </h2>
 */
public class BJ1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[41][3]; // 0:count0, 1:count1, 2:피보나치 수열 값

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 0; // 피보나치 수열의 값은 사실 필요가 없군..
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            dp[i][2] = dp[i - 1][2] + dp[i - 2][2];
        }

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.println(sb);
    }

}
