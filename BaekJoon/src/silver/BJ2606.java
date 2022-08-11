package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>바이러스</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/09</h3>
 * <br><h2>comment : BFS 활용 </h2>
 */
public class BJ2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int C = Integer.parseInt(br.readLine());
        final int N = Integer.parseInt(br.readLine());
        List<List<Integer>> listlist = new ArrayList<>();
        for (int i = 0; i < C + 1; i++) { /* listlist.get(0)은 안쓴다. 칸 채우기 용 */
            listlist.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            listlist.get(Integer.parseInt(split[0])).add(Integer.parseInt(split[1]));
            listlist.get(Integer.parseInt(split[1])).add(Integer.parseInt(split[0]));
        }

        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] checkArr = new boolean[C + 1];
        queue.add(1);
        checkArr[1] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer com : listlist.get(poll)) {
                if (checkArr[com]) {
                    continue;
                }
                checkArr[com] = true;
                count++;
                queue.add(com);
            }
        }

        System.out.println(count);
    }
}
/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
*/
