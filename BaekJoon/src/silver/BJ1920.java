package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1>수 찾기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/02</h3>
 * <h2>풀이 방법 : 정렬 후 이분 탐색</h2>
 * <br><h2>comment : </h2>
 */
public class BJ1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        String[] split1 = br.readLine().split("\\s");
        for (int i = 0; i < split1.length; i++) {
            arr1[i] = Integer.parseInt(split1[i]);
        }
        final int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        String[] split2 = br.readLine().split("\\s");
        for (int i = 0; i < split2.length; i++) {
            arr2[i] = Integer.parseInt(split2[i]);
        }

        Arrays.sort(arr1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int result = 0;
            int target = arr2[i];
            long l = 0;
            long r = N - 1L;
            while (l <= r) {
                int mid = (int)(l + r) / 2;

                if (arr1[mid] == target) {
                    result = 1;
                    break;
                }
                if (arr1[mid] < target) {
                    l = mid + 1L;
                    continue;
                }
                if (arr1[mid] > target) {
                    r = mid - 1L;
                    continue;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
/*
5
150 100 32 4 1777
5
1 1788 150 9 1777
*/
