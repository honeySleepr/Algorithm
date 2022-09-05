package level2;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>올바른 괄호</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/04</h2>
 * <br><h2>comment :</h2>
 */
public class P12909 {
    public static final char OPEN = '(';

    boolean solution(String s) {
        boolean answer = true;
        // "(())()"
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == OPEN) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != OPEN) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }

    static class TestP12909 {
        private final P12909 p = new P12909();

        @Test
        void test1() {
            assertThat(p.solution("(())()")).isEqualTo(true);
        }

        @Test
        void test2() {
            assertThat(p.solution(")()(")).isEqualTo(false);
        }
    }
}
