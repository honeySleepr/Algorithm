package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>가장 긴 증가하는 부분 수열</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/15</h2>
 * <br><h2>comment : O(n^2)</h2>
 */
public class BJ11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int A = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        int[] arr = new int[A + 1];

        for (int i = 1; i <= A; i++) {
            arr[i] = Integer.parseInt(split[i - 1]);
        }

        int[] dp = new int[A + 1];

        for (int i = 1; i <= A; i++) {
            int maxCount = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    maxCount = Math.max(maxCount, dp[j]);
                }
            }
            dp[i] = maxCount + 1;
        }

        int answer = 0;
        for (int i : dp) {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }

    private static int solution() {
        return 0;
    }

    static class TestBJ11053 {
        @Test
        void test1() {
            assertThat(solution()).isEqualTo(0);
        }
    }
}
