package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>좌표 압축</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/19</h2>
 * <br><h2>comment : target 보다 작은 `서로 다른` 좌표의 개수를 표시해야한다! 즉 중복은 제거!
 * <br> counting sort 사용하려 했는데 좌표값 범위가 -10억~+10억이어서 안되겠다
 * <br> 한참 걸리긴 했지만 결과적으로 Map이나 Set으로 쉽게 풀 수 있는 문제였다 (ranking list, 순위 리스트를 만드는 문제)
 * </h2>
 */
public class BJ18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        int[] sorted = new int[N];
        int[] original = new int[N];
        for (int i = 0; i < N; i++) {
            int parseInt = Integer.parseInt(split[i]);
            original[i] = parseInt;
            sorted[i] = parseInt;
        }

        Arrays.sort(sorted);
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : original) {
            sb.append((map.get(i))).append(" ");
        }
        System.out.println(sb);
    }

}
/*
2 4 -10 4 -9
-10 -9 2 4 4

1000 999 1000 999 1000 999
999 999 9999 1000 1000 1000
*/
