package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>소수 구하기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/17</h3>
 * <br><h2>comment :</h2>
 */
public class BJ1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int S = Integer.parseInt(split[0]);
        final int F = Integer.parseInt(split[1]);
        boolean[] arr = new boolean[F + 1];
        arr[1] = true; // true : 소수가 아니다
        for (int i = 2; i * i <= F; i++) {
            if (arr[i]) {
                continue;
            }
            for (int k = i * i; k <= F; k += i) {
                arr[k] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = S; i <= F; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
/*
3 16
*/
