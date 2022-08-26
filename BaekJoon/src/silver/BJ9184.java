package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>신나는 함수 실행</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/26</h3>
 * <br><h2>comment : String.format()도 진짜 느리구나 </h2>
 */
public class BJ9184 {
    public static int[][][] checkArr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] split = br.readLine().split("\\s");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = solution(a, b, c);
            /* String.format 쓰면 1100ms 넘게 걸리는데, stringbuilder로만 하면 400ms대로 줄어든다 */
            // String printFormat = String.format("w(%d, %d, %d) = %d", a, b, c, result);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result)
                .append("\n");

        }
        System.out.println(sb);
    }

    private static int solution(int a, int b, int c) {
        return w(a, b, c);
    }

    private static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return checkArr[20][20][20] = w(20, 20, 20);
        }
        if (checkArr[a][b][c] != 0) { /* 여기서 배열에 저장된 값이 있으면 사용함으로써 연산 시간을 줄인다 */
            return checkArr[a][b][c];
        }

        if (a < b && b < c) {
            checkArr[a][b][c - 1] = w(a, b, c - 1);
            checkArr[a][b - 1][c - 1] = w(a, b - 1, c - 1);
            checkArr[a][b - 1][c] = w(a, b - 1, c);

            checkArr[a][b][c] = checkArr[a][b][c - 1]
                + checkArr[a][b - 1][c - 1]
                - checkArr[a][b - 1][c];

            return checkArr[a][b][c];
        }
        checkArr[a - 1][b][c] = w(a - 1, b, c);
        checkArr[a - 1][b - 1][c] = w(a - 1, b - 1, c);
        checkArr[a - 1][b][c - 1] = w(a - 1, b, c - 1);
        checkArr[a - 1][b - 1][c - 1] = w(a - 1, b - 1, c - 1);

        checkArr[a][b][c] = checkArr[a - 1][b][c]
            + checkArr[a - 1][b - 1][c]
            + checkArr[a - 1][b][c - 1]
            - checkArr[a - 1][b - 1][c - 1];

        return checkArr[a][b][c];
    }

    static class TestBJ9184 {
        @Test
        void test1() {
            assertThat(solution(1, 1, 1)).isEqualTo(2);
        }

        @Test
        void test2() {
            assertThat(solution(2, 2, 2)).isEqualTo(4);
        }

        @Test
        void test3() {
            assertThat(solution(10, 4, 6)).isEqualTo(523);
        }

        @Test
        void test4() {
            assertThat(solution(50, 50, 50)).isEqualTo(1048576);
        }

        @Test
        void test5() {
            assertThat(solution(-1, 7, 18)).isEqualTo(1);
        }
    }

}
