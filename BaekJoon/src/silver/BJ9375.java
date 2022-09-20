package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>패션왕 신해빈</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/14</h2>
 * <br><h2>comment : 해당 카테고리의 옷을 입지 않은 경우도 포함시키기 위해 각 카테고리의 옷의 개수에 +1을 해서 연산을 한 뒤,
 * 아무 옷도 입지 않은 경우를 제외하기 위해 전체 결과값에서 -1 해주는게 포인트다 </h2>
 */
public class BJ9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int answer = 1;
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                String[] split = br.readLine().split("\\s");
                map.put(split[1], map.getOrDefault(split[1], 0) + 1);

            }
            for (Integer value : map.values()) {
                answer *= (value + 1); /* 해당 카테고리의 옷을 입지 않은 경우도 포함하기 위해 +1 */
            }
            sb.append(answer - 1).append("\n"); /* 아무 옷도 입지 않은 경우는 빼주기 위해 -1 */
        }
        System.out.println(sb);
    }

}
