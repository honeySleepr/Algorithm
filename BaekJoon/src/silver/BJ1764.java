package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>듣보잡</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/13</h2>
 * <br><h2>comment :</h2>
 */
public class BJ1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        final int M = Integer.parseInt(split[1]);

        Map<String, Boolean> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                count++;
                list.add(name);
                continue;
            }
            map.put(name, true);
        }

        list.sort(Comparator.naturalOrder());
        for (String name : list) {
            sb.append(name).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }

}
