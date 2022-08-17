package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>수 정렬하기 3</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/17</h3>
 * <br><h2>comment : QuickSort를 배웠다 </h2>
 */
public class BJ10989_QUICKSORT {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, arr.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end); /* 오른쪽 파티션의 시작 인덱스를 구한다 */

        /* part2 시작 위치와 start 간의 차이가 1이면 왼쪽 파티션의 크기는 1인 것이다. 이 경우에는 왼쪽 파티션은 더이상 작업을 할 필요가 없다.
        그러므로 이 경우를 제외하고 재귀를 돌린다 */
        if (part2 - start > 1) {
            quickSort(arr, start, part2 - 1);
        }
        if (end - part2 > 0) {
            quickSort(arr, part2, end);
        }
    }

    /**
     * <h2>파티션2의 시작 인덱스를 구한다</h2>
     */
    private static int partition(int[] arr, int start, int end) {
        int mid = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < mid) {
                start++;
            }
            while (arr[end] > mid) {
                end--;
            }
            /* 여기서 조건을 안 걸어주면 arr[mid] 값이 swap 된 경우 정렬이 꼬일 수 있다 */
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }
}
/*
8
5
2
3
1
4
2
1
7
*/
