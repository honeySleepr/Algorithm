package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * <h1>최소 힙</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/21</h2>
 * <br><h2>comment : PriorityQueue 사용 문제. Heap 구현방법을 알고 있어야 하려나..?</h2>
 */
public class BJ1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pQueue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pQueue.poll()).append("\n");
                }
                continue;
            }
            pQueue.offer(input);
        }

        System.out.println(sb);
    }

}
