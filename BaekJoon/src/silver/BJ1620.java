package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>포켓몬 마스터 이다솜</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/11</h2>
 * <br><h2>comment : s.matches() 보다 Character.isDigit()을 쓰는 게 더 빠르다 (800ms, 560ms)</h2>
 */
public class BJ1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");

        final int N = Integer.parseInt(split[0]);
        final int M = Integer.parseInt(split[1]);
        String[] pokedex = new String[N + 1];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            pokedex[i] = br.readLine();
            map.put(pokedex[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (Character.isDigit(s.charAt(0))) {
                // if (s.matches("\\d*")) {
                sb.append(pokedex[Integer.parseInt(s)]).append("\n");
            } else {
                sb.append(map.get(s)).append("\n");
            }
        }
        System.out.println(sb);
    }

}
