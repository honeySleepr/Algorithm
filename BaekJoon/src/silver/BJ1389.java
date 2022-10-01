package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>케빈 베이컨의 6단계 법칙</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/13</h2>
 * <br><h2>comment : BFS </h2>
 */
public class BJ1389 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        final int M = Integer.parseInt(split[1]);

        List<List<Integer>> deepList = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            deepList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            split = br.readLine().split("\\s");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            deepList.get(a).add(b);
            deepList.get(b).add(a);
        }

        /* [BFS 템플릿] */
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            Deque<Integer> queue = new ArrayDeque<>();
            boolean[] checked = new boolean[N + 1];
            int count = 0;

            int level = 1;
            queue.add(i); /* 1 */
            checked[i] = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    Integer poll = queue.poll();
                    for (Integer f : deepList.get(poll)) { /* 3, 4 */
                        if (checked[f]) {
                            continue;
                        }
                        checked[f] = true;
                        queue.add(f);
                        count += level;
                    }
                }
                level++;
            }
            if (min > count) {
                min = count;
                answer = i;
            }
        }

        System.out.println(answer);
    }

}
