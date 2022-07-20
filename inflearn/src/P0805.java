import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 동전교환
public class P0805 {

    private static List<Integer> list = new ArrayList<>();
    private static int n;
    private static int target;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        target = Integer.parseInt(br.readLine());
        /* 0 인덱스 채워줌. 어차피 안씀. sort 시에 꼬이지 않도록 최대값 입력 */
        list.add(Integer.MAX_VALUE);
        for (int i = 1; i < n + 1; i++) {
            list.add(Integer.parseInt(split[i - 1]));
        }
        /* 큰 수부터 해야 아무래도 최소값이 빨리 나올테니 */
        Collections.sort(list, Comparator.reverseOrder());

        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int L, int sum) {

        if (sum > target || L > answer) {
            return;
        }
        if (sum == target) {
            answer = Math.min(answer, L);
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            sum += list.get(i);
            DFS(L + 1, sum);
            sum -= list.get(i);
        }
    }
}
