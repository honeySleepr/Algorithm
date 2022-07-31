import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1>동전교환(냅색 알고리즘)</h1>
 * <h3>해설 참고 : O</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment :</h2>
 */
public class P1005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        final int TARGET = Integer.parseInt(br.readLine());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(split[i]);
        }
        int[] arr = new int[TARGET + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        for (int k = 0; k < N; k++) {
            int coin = coins[k];
            for (int i = coin; i < arr.length; i++) {
                arr[i] = Math.min(arr[i], arr[i - coin] + 1);
            }
        }
        System.out.println(arr[TARGET]);
    }

}
/*
3
1 2 5
15

answer : 3
*/
