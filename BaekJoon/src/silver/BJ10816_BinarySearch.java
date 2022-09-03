package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1>숫자 카드 2</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/01</h2>
 * <br><h2>comment : 이분 탐색 연습</h2>
 */
public class BJ10816_BinarySearch {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] split = br.readLine().split("\\s");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);

        final int M = Integer.parseInt(br.readLine());
        String[] split2 = br.readLine().split("\\s");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(split2[i]);
            int startIndex = lowerBound(arr, target);
            int lastIndex = upperBound(arr, target);
            sb.append(lastIndex - startIndex).append(" ");
        }

        System.out.println(sb);
    }

    /**
     * @return 끝 인덱스 + 1 (exclusive)
     */
    private static int upperBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2; /* `mid = l+r/2`을 하면 예를 들어 l=1, r=Integer.MAX인 경우 int 범위를 넘어간다 */
            if (arr[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * @return 시작 인덱스 (inclusive)
     */
    private static int lowerBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= target) { /* upperBound와의 차이점은 여기에 `=`가 추가 된 것 */
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
