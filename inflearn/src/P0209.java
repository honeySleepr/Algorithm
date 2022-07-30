import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>격자판 최대합</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 * <br><h2>comment : hSum += arr[i][k], vSum += arr[k][i], 대각선은 +=arr[i][i] && += arr[i][N-i-1] 로 쉽게 구할 수 있다</h2>
 */
public class P0209 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] vSum = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int hSum = 0;
            String[] split = br.readLine().split("\\s");
            for (int k = 0; k < N; k++) {
                int num = Integer.parseInt(split[k]);
                vSum[k] += num;
                hSum += num;
            }
            if (answer < hSum) {
                answer = hSum;
            }
        }

        for (int i : vSum) {
            if (answer < i) {
                answer = i;
            }
        }
        System.out.println(answer);
    }

}
