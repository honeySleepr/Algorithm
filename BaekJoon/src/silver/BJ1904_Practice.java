package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <br><h2>comment : 01타일 복습 </h2>
 */
public class BJ1904_Practice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 2] % 15746) + (dp[i - 1] % 15746);
        }
        System.out.println(dp[N] % 15746);

    }

    private static int solution() {
        return 0;
    }

    static class TestBJ1904_Practice {
        @Test
        void test1() {
            assertThat(solution()).isEqualTo(0);
        }
    }

}
