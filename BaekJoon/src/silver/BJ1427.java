package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://www.acmicpc.net/problem/1427">소트인사이드</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/11/13</h2>
 * <br><h2>comment : 백준 단계별 풀기 : 정렬
 * <br> Counting 정렬 사용 </h2>
 */
public class BJ1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		int num = Integer.parseInt(br.readLine());

		while (num > 0) {
			int digit = num % 10;
			num /= 10;
			arr[digit]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			while (arr[i] != 0) {
				arr[i]--;
				sb.append(i);
			}
		}
		System.out.println(sb);
	}
}
