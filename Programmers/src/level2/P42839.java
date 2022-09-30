package level2;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>소수 찾기</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/29</h2>
 * <br><h2>comment : 맞긴 했는데.. 출력을 해보니 이게 어떻게 통과됐지 싶다. 순열 구현 방법을 다 까먹었다.
 * <br>Better 버전에서는 다른 풀이를 보고 제대로 된 순열을 구현해봐야겠다</h2>
 */
public class P42839 {
    private static String[] split;
    private static boolean[] used;
    private static Set<Integer> numberSet = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();

    public int solution(String numbers) {
        split = numbers.split("");
        used = new boolean[numbers.length()];
        DFS(0);

        int answer = 0;
        for (Integer integer : numberSet) {
            if (isPrime(integer)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void DFS(int L) {
        if (L == split.length) {
            if (sb.length() == 0) {
                return;
            }
            int num = Integer.parseInt(sb.toString());
            numberSet.add(num);
            return;
        }

        for (int i = 0; i < split.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            sb.append(split[i]);
            DFS(L + 1);
            sb.deleteCharAt(sb.length() - 1);
            DFS(L + 1);
            used[i] = false;
        }

    }

    static class TestP42839 {
        private final P42839 p = new P42839();

        @Test
        void test1() {
            String input = "011";
            int answer = 2;
            assertThat(p.solution(input)).isEqualTo(answer);
        }

        @Test
        void test2() {
            String input = "17";
            int answer = 3;
            assertThat(p.solution(input)).isEqualTo(answer);
        }

    }
}
