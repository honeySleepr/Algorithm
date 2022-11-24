package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://www.acmicpc.net/problem/11729">하노이 탑 이동 순서</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎︎</h2>
 * <h2>날짜 : 2022/11/24</h2>
 * <br><h2>comment : 이건..그냥 외워야겠는걸;;</h2>
 */
public class BJ11729 {

	static int count = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		hanoi(N, 1, 2, 3); // 맨 아래 돌(N)을 1에서 3으로 옮기겠다
		System.out.println(count);
		System.out.println(sb);
	}

	private static void hanoi(int N, int start, int mid, int end) {
		if (N == 1) { // 1번 옮김(제일 작은 탑)
			sb.append(start).append(" ").append(end).append("\n");
			count++;
			return;
		}

		hanoi(N - 1, start, end, mid);
		sb.append(start).append(" ").append(end).append("\n");
		count++;
		hanoi(N - 1, mid, start, end);
	}
}
