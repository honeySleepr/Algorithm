package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>나무 자르기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/02</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment : "적어도" M미터의 나무를 집에 가져가기 위한 절단기 최대값! </h2>
 * <br><h2>comment : 항상 범위가 Integer.MAX_VALUE를 넘어설 수 있는 경우를 조심하자!  </h2>
 */
public class BJ2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        final int TARGET = Integer.parseInt(split[1]);
        int[] arr = new int[N];
        int max = 0;
        String[] strings = br.readLine().split("\\s");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int l = 0;
        int r = max;
        int answer = 0;

        while (l < r) {
            int mid = (l + r) / 2; /* 절삭기 높이 */
            long sum = 0; /* 나무 높이는 10억이 최대지만, sum은 Integer.MAX_VALUE를 넘을 수 있다! */

            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {    /* 나무가 절삭기보다 낮을 경우 sum에 음수값이 더해지면 안된다 */
                    sum += arr[i] - mid;
                }
            }
            if (sum >= TARGET) {
                if (answer < mid) {
                    answer = mid;
                }
                l = mid + 1;
            }
            if (sum < TARGET) {
                r = mid;
            }
        }
        System.out.println(answer);
    }
}
