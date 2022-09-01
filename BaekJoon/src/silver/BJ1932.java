package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>정수 삼각형</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/29</h3>
 * <br><h2>comment : `RGB 거리`를 풀고 나니까 이건 금방 풀었다 </h2>
 */
public class BJ1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Integer[][] dp = new Integer[N][N]; /* 빈 칸은 0보다는 null이여야 구분하기 편할 것 같아서 Integer로 하였다 */
        /* 속도 차이 거의 안남, 용량은 좀 차이남 29200 < 33200 */
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) { /* 왼쪽 끝인 경우 옵션 한가지 뿐 */
                    dp[i][j] += dp[i - 1][0];
                    continue;
                }
                if (j == i) { /* 오른쪽 끝인 경우도 마찬가지 */
                    dp[i][j] += dp[i - 1][i - 1];
                    continue;
                }
                dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (Integer sum : dp[N - 1]) {
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
