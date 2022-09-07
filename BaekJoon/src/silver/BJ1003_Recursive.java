package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>피보나치 함수</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/07</h2>
 * <br><h2>comment : <a href="https://st-lab.tistory.com/124">재귀 함수 버전</a></h2>
 */
public class BJ1003_Recursive {
    private static int[][] save;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        save = new int[41][2];

        save[0][0] = 1;
        save[1][1] = 1;

        for (int i = 0; i < N; i++) {
            int[] answer = fibonacci(Integer.parseInt(br.readLine()));
            sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
        }
        System.out.println(sb);
    }

    private static int[] fibonacci(int n) { /* 행렬을 반환해서 아래 if구문 안에서와 같이 활용하는 발상이 신기했다 */

        if (save[n][0] == 0 && save[n][1] == 0) {
            save[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            save[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return save[n];
    }

    private static int solution() {
        return 0;
    }

    static class TestBJ1003 {
        @Test
        void test1() {
            assertThat(solution()).isEqualTo(0);
        }
    }
}
