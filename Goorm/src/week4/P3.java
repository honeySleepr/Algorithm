package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="">거리 두기</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/31</h2>
 * <br><h2>comment :</h2>
 */
public class P3 {

	private static final int MOD = 100_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][5];
		for (int i = 0; i < 5; i++) {
			arr[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			arr[i][0] = (arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2] + arr[i - 1][3] + arr[i - 1][4]) % MOD;
			arr[i][1] = (arr[i - 1][0] + arr[i - 1][2] + arr[i - 1][3]) % MOD;
			arr[i][2] = (arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][3] + arr[i - 1][4]) % MOD;
			arr[i][3] = (arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2]) % MOD;
			arr[i][4] = (arr[i - 1][0] + arr[i - 1][2]) % MOD;
		}

		int answer = 0;
		for (int i = 0; i < 5; i++) {
			answer += arr[N][i] % MOD;
		}
		System.out.println(answer % MOD);

	}
}
