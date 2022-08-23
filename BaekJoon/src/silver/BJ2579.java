package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>계단 오르기</h1>
 * <h3>도움!! : O</h3>
 * <h3>체감 난이도 : ⭐⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/23</h3>
 * <br><h2>comment : DP 많이 풀어봐야겠다..
 * <br>1. 맨 마지막 칸을 기준으로 점화식을 만들고
 * <br>2. 시작 부분을 초기화해준다
 * </h2>
 */
public class BJ2579 {

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
            /* dp[i-1] 대신 input[i-1]를 넣음으로써 3칸 연속 밟는 경우가 제외된다 */
        }
        System.out.println(dp[N]);
    }

}
