package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>균형잡힌 세상</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/15</h3>
 * <br><h2>comment : 다 돌았을때 stack이 비어있는지를 체크해주는걸 빼먹어서 계속 틀렸었다 </h2>
 */
public class BJ4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        String input = "";

        while ((input = br.readLine()).length() > 1) {
            String result = "yes";
            char[] chars = input.toCharArray();
            for (char c : chars) {
                if (Character.isAlphabetic(c) || c == ' ') {
                    continue;
                }

                if (c == '(' || c == '[') {
                    stack.push(c);
                    continue;
                }
                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = "no";
                        break;
                    }
                    stack.pop();
                }
                if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = "no";
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.size() > 0) { /* 이 부분을 까먹어서 자꾸 실패가 떴었다 */
                result = "no";
            }
            sb.append(result).append("\n");
            stack.clear();
        }
        System.out.println(sb);
    }
}
