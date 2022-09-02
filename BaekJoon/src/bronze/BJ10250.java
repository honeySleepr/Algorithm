package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>ACM 호텔</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/08/31</h2>
 * <br><h2>comment : 수학적인건 항상 표를 그려보자 </h2>
 */
public class BJ10250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            int h = Integer.parseInt(split[0]);
            int num = Integer.parseInt(split[2]);
            int floor = num % h;
            if (floor == 0) {
                floor = h;
            }
            sb.append(floor);
            int roomNumber = (num - 1) / h + 1;
            if (roomNumber < 10) {
                sb.append(0);
            }
            sb.append(roomNumber).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution() {
        return 0;
    }

    static class TestBJ10250 {
        @Test
        void test1() {
            assertThat(solution()).isEqualTo(0);
        }
    }

}
