package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://www.acmicpc.net/problem/25501">재귀의 귀재</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/11/13</h2>
 * <br><h2>comment : 백준 단계별 풀기 : 재귀 </h2>
 */
public class BJ25501 {

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			int answer = recursion(s, 0, s.length() - 1);
			sb.append(answer).append(" ").append(count).append("\n");
			count = 0;
		}
		System.out.println(sb);

	}

	private static int recursion(String s, int l, int r) {
		count++;
		if (l >= r) {
			return 1;
		}
		if (s.charAt(l) != s.charAt(r)) {
			return 0;
		}
		return recursion(s, l + 1, r - 1);
	}
}
