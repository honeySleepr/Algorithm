package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>수 정렬하기 2</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/18</h3>
 * <br><h2>comment : O(nlogn) 정렬 알고리즘을 사용해야한다. MergeSort 연습 </h2>
 */
public class BJ2751 {

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
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = temp[part1 + i];
        }
    }

    static class TestBJ2751 {
        @Test
        void 입력_1() {
            int[] ints = {2, 6, 7, 5, 9, 0, 1, 4, 3, 8};
            Arrays.sort(ints);
            assertArrayEquals(ints, solution(new int[] {2, 6, 7, 5, 9, 0, 1, 4, 3, 8}));
        }

        @Test
        void 입력_2() {
            int[] ints = {5, 2, 3, 1, 4, 2, 1, 7};
            Arrays.sort(ints);
            assertArrayEquals(ints, solution(new int[] {5, 2, 3, 1, 4, 2, 1, 7}));
        }
    }

}
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
