package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <h1><a href="https://www.acmicpc.net/problem/24060">알고리즘 수업 - 병합 정렬 1</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/12/18</h2>
 * <br><h2>comment : Merge Sort 템플릿 </h2>
 */
public class BJ24060 {

	private static int[] arr;
	private static int[] temp;
	private static int K;
	private static int count;
	private static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		temp = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(0, arr.length - 1);
		System.out.println(answer);
	}

	private static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = start + ((end - start) / 2);

			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}

	private static void merge(int start, int mid, int end) {
		int part1 = start;
		int part2 = mid + 1;
		int index = 0;

		while (part1 <= mid && part2 <= end) {
			if (arr[part1] <= arr[part2]) {
				temp[index] = arr[part1];
				part1++;
			} else {
				temp[index] = arr[part2];
				part2++;
			}
			index++;
		}

		while (part1 <= mid) {
			temp[index] = arr[part1];
			part1++;
			index++;
		}
		while (part2 <= end) {
			temp[index] = arr[part2];
			part2++;
			index++;
		}

		index = 0;
		while (start <= end) {
			/**/
			count++;
			if (count == K) {
				answer = temp[index];
				return;
			}
			/**/
			arr[start] = temp[index];
			start++;
			index++;
		}
	}
}
