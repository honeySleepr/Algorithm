import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 조합의 경우수(메모이제이션)
public class P0807 {

    private static int count;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        int n = Integer.parseInt(split[0]);
        int r = Integer.parseInt(split[1]);

        /* 계산 시간 절약을 위한 연산 값 저장용 */
        arr = new int[n + 1][r + 1];

        System.out.println(DFS(n, r));
        // System.out.println("count = " + count);
    }

    private static int DFS(int n, int r) {
        // count++;
        if (arr[n][r] != 0) { /* 메모이제이션 안쓰면 count : 1637618399, 쓰면 533*/
            return arr[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        return arr[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }
}
