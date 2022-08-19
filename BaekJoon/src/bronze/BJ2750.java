package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>수 정렬하기</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/18</h3>
 * <br><h2>comment : QuickSort 연습</h2>
 */
public class BJ2750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution(arr);

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static int[] solution(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end) {
        int partition2StartIndex = partition(arr, start, end);
        if (partition2StartIndex - start > 1) {
            quickSort(arr, start, partition2StartIndex - 1);
        }
        if (end - partition2StartIndex > 0) {
            quickSort(arr, partition2StartIndex, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        int target = arr[mid];
        while (start <= end) {
            while (arr[start] < target) {
                start++;
            }
            while (target < arr[end]) {
                end--;
            }

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

    static class TestBJ2750 {
        @Test
        void 입력_54321() {
            assertThat(solution(new int[] {5, 4, 3, 2, 1})).isEqualTo(new int[] {1, 2, 3, 4, 5});
        }

        @Test
        void 입력_2675901438() {
            assertThat(solution(new int[] {2, 6, 7, 5, 9, 0, 1, 4, 3, 8})).isEqualTo(
                new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        }

    }

}
/*
5
5
2
3
4
1
*/
/*
10
2
6
7
5
9
0
1
4
3
8
*/
