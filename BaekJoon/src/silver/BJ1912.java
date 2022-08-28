package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>연속합</h1>
 * <h3>도움!! : O</h3>
 * <h3>체감 난이도 : ⭐⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/28</h3>
 * <br><h2>comment : 식을 잘못 만들어서 못풀었다. dp[i] = Math.max(dp[i - 1] + input[i], Math.max(dp[i - 1], input[i]))
 * <br> dp[i-1]은 단독으로는 고려해줄 필요가 없었는데, 그걸 생객해내지 못했다.
 * <br> 아직도 점화식 구하는게 너무 어렵다 </h2>
 */
public class BJ1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        String[] split = br.readLine().split("\\s");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(split[i]);
        }

        System.out.println(solution(input));
    }

    /**
     * max(dp[i-1]+input[i], input[i]) 를 구한다
     */
    private static int solution(int[] input) {
        int[] dp = new int[input.length];
        dp[0] = input[0];
        int max = input[0];

        /* {2,-12, 10, -2, 10} */
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + input[i], input[i]);
            max = Math.max(dp[i], max);
        }

        return max;
    }

    static class TestBJ1912 {
        @Test
        void test1() {
            int[] input = {-4, -1, -2, -3};
            assertThat(solution(input)).isEqualTo(-1);
        }

        @Test
        void test2() {
            int[] input = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
            assertThat(solution(input)).isEqualTo(33);
        }

        @Test
        void test3() {
            int[] input = {2, 1, -4, 3, 4, -4, 6, 5, -5, 1};
            assertThat(solution(input)).isEqualTo(14);
        }

        @Test
        void test4() {
            int[] input = {-1};
            assertThat(solution(input)).isEqualTo(-1);
        }

    }

}
