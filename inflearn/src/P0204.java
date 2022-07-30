import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>피보나치 수열</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 */
public class P0204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(" ");
        sb.append(1).append(" ");
        sb.append(2).append(" ");
        int l = 1;
        int r = 2;
        int sum = 0;
        for (int i = 3; i < N; i++) {
            sum = l + r;
            sb.append(sum).append(" ");
            l = r;
            r = sum;
        }
        System.out.println(sb);
    }

}
