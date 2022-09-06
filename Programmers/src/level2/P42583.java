package level2;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>다리를 지나는 트럭</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/06</h2>
 * <br><h2>comment : 뿌-듯</h2>
 */
public class P42583 {
    public static final int EMPTY = 0;

    public int solution(int length, int maxWeight, int[] trucks) {
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> bridgeQueue = new ArrayDeque<>();
        int weightSum = 0;
        int time = 0;
        for (int truck : trucks) {
            queue.add(truck);
        }

        while (queue.size() > 0 || weightSum > 0) { /* weightSum을 flag로 사용하는 방법을 찾는데까지 오래걸렸다 */
            time++;
            if (bridgeQueue.size() == length) {
                weightSum -= bridgeQueue.poll();
            }

            if (!queue.isEmpty() && maxWeight >= weightSum + queue.peek()) {
                Integer truck = queue.poll();
                bridgeQueue.add(truck);
                weightSum += truck;
            } else {
                bridgeQueue.add(EMPTY);
            }
        }
        return time;
    }

    static class TestP42583 {
        private final P42583 p = new P42583();

        @Test
        void test1() {
            int bridgeLength = 2;
            int weight = 10;
            int[] trucks = {7, 4, 5, 6};
            int answer = 8;
            assertThat(p.solution(bridgeLength, weight, trucks)).isEqualTo(answer);
        }

        @Test
        void test2() {
            int bridgeLength = 100;
            int weight = 100;
            int[] trucks = {10};
            int answer = 101;
            assertThat(p.solution(bridgeLength, weight, trucks)).isEqualTo(answer);
        }

        @Test
        void test3() {
            int bridgeLength = 100;
            int weight = 100;
            int[] trucks = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
            int answer = 110;
            assertThat(p.solution(bridgeLength, weight, trucks)).isEqualTo(answer);
        }
    }

}
