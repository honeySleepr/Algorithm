package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://www.acmicpc.net/problem/2630">색종이 만들기</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/29</h2>
 * <br><h2>comment :</h2>
 */
public class BJ2630 {

	static int N;
	static int[] count = new int[2];
	static int[] dx = {0, 0, 1, 1};
	static int[] dy = {0, 1, 0, 1};
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("\\s");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
			}
		}
		DFS(0, 0, N);
		System.out.println(count[0]);
		System.out.println(count[1]);
	}

	private static void DFS(int x, int y, int length) {
		int newLength = length / 2;
		if (newLength < 1) {
			if (arr[x][y] == 0) {
				count[0]++;
			} else {
				count[1]++;
			}
			return;
		}
		if (isSameColoredSqaure(x, y, length)) {
			if (arr[x][y] == 0) {
				count[0]++;
			} else {
				count[1]++;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i] * newLength;
			int newY = y + dy[i] * newLength;
			DFS(newX, newY, newLength);
		}
	}

	private static boolean isSameColoredSqaure(int x, int y, int length) {
		int color = arr[x][y];
		for (int i = x; i < x + length; i++) {
			for (int j = y; j < y + length; j++) {
				if (color != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
