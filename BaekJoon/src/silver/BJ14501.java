package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>퇴사</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : O</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/16</h2>
 * <br><h2>comment : dp는 역시 어렵군..</h2>
 */
/*
3
2 10
5 20
1 10
답 : 20
*/

public class BJ14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] time = new int[N + 1];
        int[] pay = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split("\\s");
            time[i] = Integer.parseInt(split[0]);
            pay[i] = Integer.parseInt(split[1]);
        }

        int[] dp = new int[N + 1];

        /* 원래 나의 풀이. 아래 처럼 dp[]를 잘 활용하면 되는데 쓸데없이 변수들을 사용하였다.
        그래서 아래가 더 dp다운 풀이 같다 */
        // int max = 0;
        // int answer = 0;
        // for (int i = 1; i <= N; i++) {
        //     max = Math.max(max, dp[i-1]);
        //     int dDay = i + time[i] - 1;
        //     if (dDay > N) {
        //         continue;
        //     }
        //     dp[dDay] = Math.max(dp[dDay], max + pay[i]);
        //     answer = Math.max(answer, dp[dDay]);
        // }

        for (int i = 1; i <= N; i++) {
            int dDay = i + time[i] - 1;
            if (dDay <= N) {
                dp[dDay] = Math.max(dp[dDay], dp[i - 1] + pay[i]);
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[N]);
    }

}

/*
3
2 10
5 20
1 10
답: 20

7
3 10
5 20
1 10
2 20
4 15
2 10
2 200
답 : 40

*/
