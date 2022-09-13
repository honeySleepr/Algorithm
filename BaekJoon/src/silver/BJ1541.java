package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>잃어버린 괄호</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/13</h2>
 * <br><h2>comment :</h2>
 */
public class BJ1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        List<Integer> numList = new ArrayList<>();
        Deque<Character> queue = new ArrayDeque<>();

        for (char c : chars) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                queue.add(c);
                numList.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }
        numList.add(Integer.parseInt(sb.toString()));

        int answer = numList.get(0);
        boolean minusFlag = false;
        for (int i = 1; i < numList.size(); i++) {
            int num = numList.get(i);

            if (minusFlag) { /* -가 한번이라도 떴으면 뒤에는 볼것도 없이 다 빼버릴 수 있다 */
                answer -= num;
                continue;
            }

            if (!queue.isEmpty()) {
                Character poll = queue.poll();
                if (poll.equals('-')) {
                    num *= -1;
                    minusFlag = true;
                }
            }
            answer += num;
        }
        System.out.println(answer);
    }

}
