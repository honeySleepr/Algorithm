package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://www.acmicpc.net/problem/11501">주식</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/31</h2>
 * <br><h2>comment : 그리디 넘 어렵. 혼자서 생각을 못해내겠다</h2>
 */
public class BJ11501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {

			int N = Integer.parseInt(br.readLine());
			String[] split = br.readLine().split("\\s");
			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(split[j]);
			}

			int max = 0;
			long answer = 0;
			for (int j = N - 1; j >= 0; j--) {
				if (max < arr[j]) {
					max = arr[j];
					continue;
				}
				answer += max - arr[j];
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
