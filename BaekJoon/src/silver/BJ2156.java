package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>포도주 시식</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : {10, 100, 100, 10, 10, 100, 100} </h2>
 * <h2>체감 난이도 : ⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/08/31</h2>
 * <br><h2>comment : 두 칸을 건너뛰는 경우를 고려하지 않아서 틀렸다 </h2>
 */
public class BJ2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] in = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            in[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(in, N));
    }

    private static int solution(int[] in, int N) {
        int[] dp = new int[N + 1];
        dp[1] = in[1];
        int max = dp[1];
        if (N > 1) {
            dp[2] = in[1] + in[2];
            max = dp[2];
        }

        for (int i = 3; i <= N; i++) {
            /* 두칸을 건너뛰는 경우를 고려하기 위해 in[i]를 최대값에 더하지 않고 dp[i-1]만 선택하는 경우를 추가하였다 */
            dp[i] = Math.max(Math.max(in[i] + in[i - 1] + dp[i - 3], in[i] + dp[i - 2]), dp[i - 1]);
            max = Math.max(dp[i], max);
        }

        return max;
    }

    static class TestBJ2156 {
        @Test /* 반례 */
        void test5() {
            int[] in = {10, 100, 100, 10, 10, 100, 100};
            assertThat(solution(processedInput(in), in.length)).isEqualTo(400);
        }

        @Test
        void test1() {
            int[] in = {6, 10, 13, 9, 8, 1};
            assertThat(solution(processedInput(in), in.length)).isEqualTo(33);
        }

        @Test
        void test2() {
            int[] in = {6, 10};
            assertThat(solution(processedInput(in), in.length)).isEqualTo(16);
        }

        @Test
        void test3() {
            int[] in = {6};
            assertThat(solution(processedInput(in), in.length)).isEqualTo(6);
        }

        @Test
        void test4() {
            int[] in = {1, 2, 3};
            assertThat(solution(processedInput(in), in.length)).isEqualTo(5);
        }

        private int[] processedInput(int[] in) {
            int[] input = new int[in.length + 1];
            System.arraycopy(in, 0, input, 1, in.length); /* input = {0, in} 만들어줌 */
            return input;
        }
    }

}
