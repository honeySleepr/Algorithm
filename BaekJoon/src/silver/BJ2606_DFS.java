package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>바이러스</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/09</h3>
 * <br><h2>comment : DFS 활용 </h2>
 */
public class BJ2606_DFS {
    private static int answer;
    private static boolean[] checkArr;
    private static List<List<Integer>> listlist = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int C = Integer.parseInt(br.readLine());
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < C + 1; i++) { /* listlist.get(0)은 안쓴다. 칸 채우기 용 */
            listlist.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            listlist.get(Integer.parseInt(split[0])).add(Integer.parseInt(split[1]));
            listlist.get(Integer.parseInt(split[1])).add(Integer.parseInt(split[0]));
        }

        checkArr = new boolean[C + 1];
        checkArr[1] = true;
        DFS(1);
        System.out.println(answer);
    }

    private static void DFS(int i) {
        for (Integer num : listlist.get(i)) {
            if (!checkArr[num]) {
                checkArr[num] = true;
                answer++;
                DFS(num);
            }
        }
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
