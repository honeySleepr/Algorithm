package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>부녀회장이 될테야</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/05</h2>
 * <br><h2>comment : 표로 그려보니 규칙이 있다 : arr[k][n] = arr[k][n-1] + arr[k-1][n] </h2>
 */
public class BJ2775 {
    private static int[][] arr = new int[14 + 1][14 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int CASES = Integer.parseInt(br.readLine());

        for (int i = 0; i < CASES; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int count = DFS(k, n);
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static int DFS(int k, int n) {
        if (arr[k][n] != 0) {
            return arr[k][n];
        }
        if (k == 0) {
            return n;
        }
        if (n == 1) {
            return 1;
        }

        return arr[k][n] = DFS(k, n - 1) + DFS(k - 1, n);
    }

}
