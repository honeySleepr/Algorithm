package level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>프린터</h1>
 * <h2>코드 참고 : X2</h2>
 * <h2>반례 참고 : O</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/04</h2>
 * <br><h2>comment : 전에 백준에서 같은 문제를 풀었어서 쉽게 할 수 있을 줄 알았다.
 * <b2> 풀이 방법을 좀 바꿔서 해봤더니 또 막혀서 함참 걸렸다 ㅡㅡ;</h2>
 */
public class P42587 {
    public int solution(int[] priorities, int location) {
        List<Deque<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(new ArrayDeque<>());
        }

        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            list.get(priority).add(i);
        }

        int answer = 0;
        int index = 0;
        int printedCount = 0;
        /* 최고 우선순위인 9부터 거꾸로 내려간다 */
        /* {8,9,9,8} 이면 9들이 인쇄된 후 첫번째 8보다 네 번째 8이 먼저 출력된다. 이걸 판단하기 위해 index 변수를 두었다 */

        for (int p = 9; p > 0; p--) {
            Deque<Integer> deque = list.get(p);
            if (deque.isEmpty()) {
                continue;
            }

            while (!deque.isEmpty()) {
                /* {8,9,9} 인 경우 이 부분을 안해주면 시간 초과가 난다. 9의 마지막 인덱스인 2가 8의 인덱스인 0 보다 계속 크기 때문 */
                if (deque.peekLast() < index) { /* 그냥 peek()는 peekFirst()를 호출한다. 여기선 peekLast()를 써서 마지막으로 queue에 넣은
                값을 확인하였다. 다르게 구현하려면 각 priority의 마지막 index를 저장하는 배열을 만들어서 활용하면 될 것 같다 */
                    index = 0;
                }
                while (deque.peek() < index) {
                    deque.add(deque.poll());
                }

                index = deque.poll();
                printedCount++;

                if (index == location) {
                    answer = printedCount;
                }
            }
        }
        return answer;
    }

    static class TestP42587 {
        private final P42587 p = new P42587();

        @Test
        void test1() {
            int[] priorities = {2, 1, 3, 2};
            int location = 2;
            int answer = 1;
            assertThat(p.solution(priorities, location)).isEqualTo(answer);
        }

        @Test
        void test2() {
            int[] priorities = {1, 1, 9, 1, 1, 1};
            int location = 0;
            int answer = 5;
            assertThat(p.solution(priorities, location)).isEqualTo(answer);
        }

        @Test
        void test3() {
            int[] priorities = {7, 9, 1, 9, 7};
            int location = 2;
            int answer = 5;
            assertThat(p.solution(priorities, location)).isEqualTo(answer);
        }

        @Test
        void test4() {
            int[] priorities = {2, 3, 3, 2, 9, 3, 3};
            int location = 0;
            int answer = 7;
            assertThat(p.solution(priorities, location)).isEqualTo(answer);
        }

        @Test
        void test5() {
            int[] priorities = {1, 2, 3, 4};
            int location = 0;
            int answer = 4;
            assertThat(p.solution(priorities, location)).isEqualTo(answer);
        }
    }
}
