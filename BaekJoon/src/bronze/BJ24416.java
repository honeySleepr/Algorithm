package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>알고리즘 수업 - 피보나치 수 1</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/24</h3>
 * <br><h2>comment : DP 연습 </h2>
 */
public class BJ24416 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int dpCount = fibonacciDP(target);
        System.out.println(arr[target] + " " + dpCount);
    }

    private static int fibonacciDP(int target) {
        arr = new int[target + 1];
        arr[1] = 1;
        arr[2] = 1;
        int count = 0;
        for (int i = 3; i <= target; i++) {
            count++;
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return count;
    }
}
