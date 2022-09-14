package level2;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>주식 가격</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/08</h2>
 * <br><h2>comment : 2중 for문으로 풀긴 했으나, O(n^2)이기도 하고 문제 의도와 맞지 않은 것 같아서 Stack으로 풀어보려 했으나,
 * <br> 내 머리로는 생각해낼 수 없어서 다른 사람 풀이 페이지에서 풀이를 보고 참고하였다
 * <br> 문제 설명을 너무 대충해놨고 예시도 하나밖에 없어서 이해하기 어려웠다 </h2>
 * <br> 예시 : {3,3,1,2,5} -> 답:{2,1,2,1,0}
 */

public class P42584 {
    public int[] solution(int[] prices) {
        Deque<Integer> indexStack = new ArrayDeque<>();
        int[] answer = new int[prices.length];

        indexStack.push(0);
        for (int i = 1; i < prices.length; i++) {
            /* 위 예시처럼 연속으로 같은 숫자가 나올 경우를 처리하기 위해 while문을 사용한다 */
            while (!indexStack.isEmpty() && prices[indexStack.peek()] > prices[i]) {
                Integer pop = indexStack.pop();
                answer[pop] = i - pop;
            }
            indexStack.push(i);
        }
        int lastIndex = prices.length - 1;
        while (!indexStack.isEmpty()) {
            Integer pop = indexStack.pop();
            answer[pop] = lastIndex - pop;
        }
        return answer;
    }

    static class TestP42584 {
        private final P42584 p = new P42584();

        @Test
        void test1() {
            int[] input = {1, 2, 3, 2, 3};
            int[] answer = {4, 3, 1, 1, 0};
            assertThat(p.solution(input)).isEqualTo(answer);
        }

        @Test
        void test2() {
            int[] input = {1, 2, 3, 2, 1};
            int[] answer = {4, 3, 1, 1, 0};
            assertThat(p.solution(input)).isEqualTo(answer);
        }

        @Test
        void test3() {
            int[] input = {2, 5, 3, 5};
            int[] answer = {3, 1, 1, 0};
            assertThat(p.solution(input)).isEqualTo(answer);
        }

        @Test
        void test4() {
            int[] input = {3, 3, 1, 2, 5};
            int[] answer = {2, 1, 2, 1, 0};
            assertThat(p.solution(input)).isEqualTo(answer);
        }
    }
}
