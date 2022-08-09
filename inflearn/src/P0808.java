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
    private static boolean[] checkArr;
    private static boolean flag;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        n = Integer.parseInt(split[0]);
        f = Integer.parseInt(split[1]);

        combinationArr = new int[n];
        combinationTempArr = new int[n][n];
        pArr = new int[n];
        checkArr = new boolean[n];

        for (int i = 0; i < n; i++) {
            combinationArr[i] = C(n - 1, i);
        }
        DFS(0, 0);
        // System.out.println(count);
    }

    private static void DFS(int L, int sum) {
        // count++;
        if (sum == f && L == n) {
            for (int i = 0; i < pArr.length; i++) {
                System.out.print(pArr[i] + " ");
            }
            System.out.println();
            flag = true;
            return;
        }
        if (flag || L == n || sum > f) {
            return;
        }


        /* for문을 작은 수부터 돌리기 때문에 사전순으로 빠른 답이 먼저 구해지게된다 */
        for (int i = 0; i < n; i++) {
            if (checkArr[i]) {
                continue;
            }
            checkArr[i] = true;
            pArr[L] = i + 1;
            DFS(L + 1, sum + (combinationArr[L] * pArr[L]));
            checkArr[i] = false;
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
