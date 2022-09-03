package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>숫자 카드 2</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/01</h2>
 * <br><h2>comment : Map을 활용한 풀이 </h2>
 */
public class BJ10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        String[] split = br.readLine().split("\\s");
        for (int i = 0; i < N; i++) {
            int parseInt = Integer.parseInt(split[i]);
            map.put(parseInt, map.getOrDefault(parseInt, 0) + 1);
        }

        final int M = Integer.parseInt(br.readLine());
        String[] split2 = br.readLine().split("\\s");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int parseInt = Integer.parseInt(split2[i]);
            sb.append(map.getOrDefault(parseInt, 0)).append(" ");
        }

        System.out.println(sb);
    }

}
