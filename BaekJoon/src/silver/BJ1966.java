package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>프린터 큐</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/19</h3>
 * <br><h2>comment : 문제를 제대로 이해하는게 어려웠다 </h2>
 */
public class BJ1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int CASE = Integer.parseInt(br.readLine());
        for (int i = 0; i < CASE; i++) {
            String[] split = br.readLine().split("\\s");
            final int N = Integer.parseInt(split[0]);
            final int TARGET = Integer.parseInt(split[1]);
            String[] numbers = br.readLine().split("\\s");

            sb.append(solution(N, TARGET, numbers)).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution(int N, int TARGET, String[] numbers) {
        Deque<Point> queue = new ArrayDeque<>();
        List<Integer> sequence = new ArrayList<>();

        for (int j = 0; j < N; j++) {
            int parseInt = Integer.parseInt(numbers[j]);
            queue.offer(new Point(j, parseInt));
            sequence.add(parseInt);
        }
        sequence.sort(Comparator.reverseOrder()); /* 순서 파악용 리스트 */

        int chosenOrder = 0;
        while (queue.size() > 0) {
            Point poll = queue.poll();
            if (sequence.get(chosenOrder) == poll.priority) { /* 현재 순서에 나와야 되는 번호가 맞는지 확인 */
                chosenOrder++;
                if (poll.index == TARGET) { /* 그 번호의 원래 인덱스가 찾고있는 인덱스인지 확인 */
                    break;
                }
            } else {
                queue.offer(poll);
                continue;
            }
        }
        return chosenOrder;
    }

    static class Point {
        private int index;
        private int priority;

        public Point(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    static class TestBJ1966 {
        @Test
        void 입력_() {
            assertThat(solution(6, 0, new String[] {"1", "1", "9", "1", "1", "1"})).isEqualTo(5);
        }

        @Test
        void 입력_1() {
            assertThat(solution(4, 2, new String[] {"1", "2", "3", "4"})).isEqualTo(2);
        }

        @Test
        void 입력_2() {
            assertThat(solution(1, 0, new String[] {"5"})).isEqualTo(1);
        }
    }

}
