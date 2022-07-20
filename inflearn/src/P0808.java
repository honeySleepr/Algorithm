import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수열 추측하기 (개어려움)
public class P0808 {

    private static int n;
    private static int f;
    private static int[] combinationArr;
    private static int[][] combinationTempArr;
    private static int[] pArr;
    private static int[] checkArr;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        n = Integer.parseInt(split[0]);
        f = Integer.parseInt(split[1]);

        combinationArr = new int[n + 1];
        combinationTempArr = new int[n + 1][n + 1];
        pArr = new int[n + 1];
        checkArr = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            combinationArr[i] = C(n - 1, i - 1);
        }

        DFS(1, 0);
    }

    private static void DFS(int L, int sum) {
        if (sum == f && L > n) {
            for (int i = 1; i < pArr.length; i++) {
                System.out.print(pArr[i] + " ");
            }
            flag = true;
            return;
        }
        if (flag || L > n || sum > f) {
            return;
        }
        /* for문을 1부터 돌리기 때문에 사전순으로 빠른 답이 먼저 도출된다 */
        for (int i = 1; i < n + 1; i++) {
            if (checkArr[i] == 1) {
                continue;
            }
            checkArr[i] = 1;
            pArr[L] = i;
            DFS(L + 1, sum + (combinationArr[L] * pArr[L]));
            checkArr[i] = 0;
        }
    }

    /**
     * @return nCr
     */
    private static int C(int n, int r) {
        if (combinationTempArr[n][r] != 0) {
            return combinationTempArr[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        return combinationTempArr[n][r] = C(n - 1, r - 1) + C(n - 1, r);
    }
}

/*
4 16
답 : 3 1 2 4
*/
