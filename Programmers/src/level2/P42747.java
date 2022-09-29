package level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>H-Index</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/29</h2>
 * <br><h2>comment : 테스트케이스가 하나 밖에 없어서 문제 조건을 이해하기 어려웠다.
 * <br> 다른 사람들 풀이를 보니.. 내 머리로는 생각해낼 수 없는 답이었다.. </h2>
 */
public class P42747 {
    public int solution(int[] citations) {
        int size = citations.length;
        int[] countArr = new int[10_000 + 1];

        int max = 0;
        for (int i = 0; i < size; i++) {
            countArr[citations[i]]++;
            max = Math.max(citations[i], max);
        }

        int[] sumArr = new int[10_000 + 1];  /* 누적합을 구한다 */
        sumArr[0] = countArr[0];
        for (int i = 1; i < size; i++) {
            sumArr[i] = sumArr[i - 1] + countArr[i];
        }

        int answer = 0;
        int sum = 0;
        for (int i = max; i > 0; i--) { /* 맨 뒤(인용 횟수 최대값) 부터 거꾸로 내려온다 */
            sum += countArr[i];
            if (sum >= i && sumArr[i - 1] <= sum) { /* sum은 i회 이상 인용된 논문의 수, sumArr[i-1]는 그 외의 논문의 수이다 */
                answer = i;
                break;
            }
        }

        return answer;
    }

    static class TestP42747 {
        private final P42747 p = new P42747();

        @Test
        void test1() {
            int[] input = {3, 0, 6, 1, 5};
            int answer = 3;
            assertThat(p.solution(input)).isEqualTo(answer);
        }

        @Test
        void test2() {
            int[] input = {3, 0, 4, 0};
            int answer = 2;
            assertThat(p.solution(input)).isEqualTo(answer);
        }

        @Test
        void test3() {
            int[] input = {3, 3, 3, 2, 2, 2, 2};
            int answer = 2;
            assertThat(p.solution(input)).isEqualTo(answer);
        }

    }
}
