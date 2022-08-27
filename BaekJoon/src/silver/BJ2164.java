package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>카드2</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/22</h3>
 * <br><h2>comment :</h2>
 */
public class BJ2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }

    private static int solution() {
        return 0;
    }

    static class TestBJ2164 {
        @Test
        void test1() {
            assertThat(solution()).isEqualTo(0);
        }
    }

}
