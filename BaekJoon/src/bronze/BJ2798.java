package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>블랙잭</h1>
 * <h3>코드 참고 : X</h3>
 * <h3>반례 참고 : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/31</h3>
 * <br><h2>comment : DFS로 하면 시간 초과나서 3중 for문 ㄱㄱ</h2>
 */
public class BJ2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        final int TARGET = Integer.parseInt(split[1]);
        int[] arr = new int[N];
        String[] split2 = br.readLine().split("\\s");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split2[i]);
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > TARGET) {
                break;
            }
            for (int j = i + 1; j < N; j++) {
                if (arr[j] > TARGET) {
                    break;
                }
                for (int k = j + 1; k < N; k++) {
                    if (arr[k] > TARGET) {
                        break;
                    }
                    sum = arr[i] + arr[j] + arr[k];
                    if (sum > TARGET) {
                        continue;
                    }
                    max = Math.max(arr[i] + arr[j] + arr[k], max);
                }
            }
        }
        System.out.println(max);
    }

}
