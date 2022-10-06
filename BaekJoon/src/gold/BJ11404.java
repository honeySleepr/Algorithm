package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1><a href="https://www.acmicpc.net/problem/11404">플로이드</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : O</h2>
 * <h2>풀이 시간 : 1.5h</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎︎</h2>
 * <h2>날짜 : 2022/10/06</h2>
 * <br><h2>comment : M 값을 충분히 크게 잡지 않으면 98%에서 자꾸 틀린다 </h2>
 */
public class BJ11404 {

	static final long M = 10_000_000_000L; /* 10억으로도 통과는 되는데, 노선 10만 * 비용 10만 = 100억이므로 충분히 크게 잡아보았다 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		long[][] arr = new long[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(arr[i], M);
			arr[i][i] = 0L;
		}

		/* 노선 등록 */
		for (int i = 0; i < m; i++) {
			String[] split = br.readLine().split("\\s");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			long c = Long.parseLong(split[2]);
			arr[a - 1][b - 1] = Math.min(arr[a - 1][b - 1], c); /* 노선이 하나가 아닐 수 있다 */
		}

		/* 플로이드-와샬 템플릿 */
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k) {
					continue;
				}
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		/* 출력 (노선이 없다면 0으로 출력한다)*/
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == M) {
					sb.append("0").append(" ");
				} else {
					sb.append(arr[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
