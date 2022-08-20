package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>스택 수열</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/20</h3>
 * <br><h2>comment :</h2>
 */
public class BJ1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int input = 1; input <= N; input++) { /* 1~N 입력 */
            stack.push(input);
            sb.append("+").append("\n");
            while (index < list.size() && list.get(index).equals(stack.peek())) {
                stack.pop();
                sb.append("-").append("\n");
                index++;
            }
        }
        if (stack.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }

    private static int solution() {
        return 0;
    }

    static class TestBJ1874 {
        @Test
        void test1() {
            assertThat(solution()).isEqualTo(0);
        }
    }
}
/*
8
4
3
6
8
7
5
2
1
*/
