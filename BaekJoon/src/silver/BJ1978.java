package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>소수 찾기</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/22</h3>
 * <br><h2>comment :</h2>
 */
public class BJ1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int answer = N;
        String[] split = br.readLine().split("\\s");
        for (String s : split) {
            int parseInt = Integer.parseInt(s);
            if (parseInt == 1) {
                answer--;
                continue;
            }
            for (int i = 2; i * i <= parseInt; i++) {
                if (parseInt % i == 0) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static int solution() {
        return 0;
    }

    static class TestBJ1978 {
        @Test
        void test1() {
            assertThat(solution()).isEqualTo(0);
        }
    }

}
