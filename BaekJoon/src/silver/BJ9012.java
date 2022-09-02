package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/08/31</h2>
 * <br><h2>comment :</h2>
 */
public class BJ9012 {

    private static char OPEN = '(';
    private static char CLOSE = ')';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            stack.clear();
            char[] chars = br.readLine().toCharArray();
            String result = "YES";
            for (char c : chars) {
                if (c == OPEN) {
                    stack.push(c);
                    continue;
                }
                if (c == CLOSE) {
                    if (!stack.isEmpty() && stack.peek() == OPEN) {
                        stack.pop();
                    } else {
                        result = "NO";
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                result = "NO";
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }
}
