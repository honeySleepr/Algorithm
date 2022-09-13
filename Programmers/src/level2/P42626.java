package level2;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>더 맵게</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/12</h2>
 * <br><h2>comment : PriorityQueue 활용 </h2>
 */
public class P42626 {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pQueue = new PriorityQueue<>();
        Queue<Integer> smallestTwo = new PriorityQueue<>();
        for (int i : scoville) {
            pQueue.add(i);
        }

        int answer = 0;
        while (pQueue.size() > 1 && pQueue.peek() < K) {
            for (int i = 0; i < 2; i++) {
                smallestTwo.add(pQueue.poll());
            }
            answer++;
            pQueue.add(smallestTwo.poll() + smallestTwo.poll() * 2);
            /* 음식 두개를 저장할 변수나 Queue를 만들 필요없이 pQueue.add()에 바로 넣어주면 더 효율적이다 */
            /* pQueue.add(pQueue.poll() + pQueue.poll() *2); */
        }

        if (pQueue.peek() < K) {
            answer = -1;
        }
        return answer;
    }

    static class TestP42626 {
        private final P42626 p = new P42626();

        @Test
        void test1() {
            int[] input = {1, 2, 3, 9, 10, 12};
            int K = 7;
            int answer = 2;
            assertThat(p.solution(input, K)).isEqualTo(answer);
        }

        @Test
        void test2() {
            int[] input = {1, 1};
            int K = 7;
            int answer = -1;
            assertThat(p.solution(input, K)).isEqualTo(answer);
        }

        @Test
        void test3() {
            int[] input = {8, 10, 11};
            int K = 7;
            int answer = 0;
            assertThat(p.solution(input, K)).isEqualTo(answer);
        }
    }
}
