package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://www.acmicpc.net/problem/9095">1,2,3 더하기</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/11/09</h2>
 * <br><h2>comment : 조합</h2>
 */
public class BJ9095 {

	static StringBuilder sb = new StringBuilder();
	static int[] arr = {1, 2, 3};
	static int count;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			count = 0;
			n = Integer.parseInt(br.readLine());
			solution();

		}
		System.out.println(sb);
	}

	private static void solution() {
		DFS(0);
		sb.append(count).append("\n");
	}

	private static void DFS(int sum) {

		if (sum > n) {
			return;
		}
		if (sum == n) {
			count++;
		}

		for (int i = 0; i < arr.length; i++) {
			DFS(sum + arr[i]);
		}
	}
}
