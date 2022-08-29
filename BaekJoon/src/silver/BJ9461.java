package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1>파도반 수열</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/27</h3>
 * <br><h2>comment :</h2>
 */
public class BJ9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int max = 0;
        int[] input = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            int parseInt = Integer.parseInt(br.readLine());
            input[i] = parseInt;
            max = Math.max(max, parseInt);
        }

        long[] dp = new long[max + 1];
        if (max >= 3) {
            dp[1] = dp[2] = dp[3] = 1;
        } else {
            Arrays.fill(dp, 1);
        }

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }

        StringBuilder sb = new StringBuilder();

        for (int i : input) {
            sb.append(dp[i]).append("\n");
        }
        System.out.println(sb);

    }

}
