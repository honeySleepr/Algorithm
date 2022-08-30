package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>RGB 거리</h1>
 * <h3>도움!! : O</h3>
 * <h3>체감 난이도 : ⭐⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/28</h3>
 * <br><h2>comment : DP 진짜,, 많이 풀어봐야겠다 </h2>
 */
public class BJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[][] intArr = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            for (int j = 0; j < 3; j++) {
                intArr[i][j] = Integer.parseInt(split[j]);
            }
        }
        System.out.println(solution(intArr));
    }

    private static int solution(int[][] input) {
        final int N = input.length;
        int[][] dp = input.clone();

        for (int i = 1; i < N; i++) {
            /* dp[i][x]는 i번째 집은 x 색깔로 무조건 칠한다. 그럼 고려할 것은 dp[i-1]의 값 중 색깔이 겹치지 않고 최소인 값이다 */
            dp[i][0] = dp[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = dp[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = dp[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
    }

    static class TestBJ1149 {

        @Test
        void test1() {
            String input = "26 40 83\n"
                + "49 60 57\n"
                + "13 89 99";
            assertThat(solution(makeDeepIntArray(input))).isEqualTo(96);
        }

        @Test
        void test2() {
            String input = "1 100 100\n"
                + "100 1 100\n"
                + "100 100 1";
            assertThat(solution(makeDeepIntArray(input))).isEqualTo(3);
        }

        @Test
        void test3() {
            String input = "1 100 100\n"
                + "100 100 100\n"
                + "1 100 100";
            assertThat(solution(makeDeepIntArray(input))).isEqualTo(102);
        }

        @Test
        void test4() {
            String input = "30 19 5\n"
                + "64 77 64\n"
                + "15 19 97\n"
                + "4 71 57\n"
                + "90 86 84\n"
                + "93 32 91";
            assertThat(solution(makeDeepIntArray(input))).isEqualTo(208);
        }

        @Test
        void test5() {
            String input = "71 39 44\n"
                + "32 83 55\n"
                + "51 37 63\n"
                + "89 29 100\n"
                + "83 58 11\n"
                + "65 13 15\n"
                + "47 25 29\n"
                + "60 66 19";
            assertThat(solution(makeDeepIntArray(input))).isEqualTo(253);
        }

        private int[][] makeDeepIntArray(String input) {
            String[] split = input.split("\n");
            int[][] intArr = new int[split.length][3];
            for (int i = 0; i < split.length; i++) {
                String[] split2 = split[i].split("\\s");
                for (int j = 0; j < 3; j++) {
                    intArr[i][j] = Integer.parseInt(split2[j]);
                }
            }
            return intArr;
        }

    }

}
