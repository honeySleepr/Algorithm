package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>요세푸스 문제 0</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/02</h2>
 * <br><h2>comment : </h2>
 */
public class BJ11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);
    }

    private static int solution() {
        return 0;
    }

    static class TestBJ11866 {
        @Test
        void test1() {
            assertThat(solution()).isEqualTo(0);
        }
    }
}
