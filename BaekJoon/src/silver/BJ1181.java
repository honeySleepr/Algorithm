package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>단어 정렬</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/07/30</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment :</h2>
 */
public class BJ1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, (a, b) -> {
            if (a.length() == b.length()) { /* 길이가 같으면 ASCII 코드값으로 크기 비교 */
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
            }
            return a.length() - b.length(); /* 길이가 같지 않으면 길이로 비교 */
        });

        System.out.println(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).equals(list.get(i))) { /* 이전 단어와 같으면 출력하지 않고 패스 */
                continue;
            }
            System.out.println(list.get(i));
        }
    }
}
