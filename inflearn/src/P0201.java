import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>큰 수 출력하기</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 */
public class P0201 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.parseInt(split[0])).append(" ");

        for (int i = 1; i < N; i++) {
            int a = Integer.parseInt(split[i - 1]);
            int b = Integer.parseInt(split[i]);
            if (a < b) {
                sb.append(b).append(" ");
            }
        }
        System.out.println(sb);
    }

}
