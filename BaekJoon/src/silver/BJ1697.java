package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>숨바꼭질</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/13</h2>
 * <br><h2>comment : BFS</h2>
 */
public class BJ1697 {

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        final int K = Integer.parseInt(split[1]);
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] checked = new boolean[MAX * 2 + 1];
        queue.add(N);
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (checked[poll]) {
                    continue;
                }
                checked[poll] = true;
                if (poll == K) {
                    System.out.println(L);
                    return;
                }
                if (poll > 0 && poll <= MAX) {
                    queue.add(poll * 2);
                }
                if (poll < K) {
                    queue.add(poll + 1);
                }
                if (poll > 0) {
                    queue.add(poll - 1);
                }
            }
            L++;
        }
    }

}
