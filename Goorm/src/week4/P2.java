package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://level.goorm.io/exam/160278/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%A8%BC%EB%8D%B0%EC%9D%B4-4%ED%9A%8C/quiz/2">단풍나무</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/29</h2>
 * <br><h2>comment :</h2>
 */
public class P2 {

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	static int[][] arr;
	static int[][] countArr;
	static int N;

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
		int day = 0;

		while (true) {
			if (N == 1) { /* 이 부분 빼먹음 주의 */
				break;
			}
			countArr = new int[N][N];
			boolean done = true;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 0) {
						continue;
					}
					countArr[i][j] = getCount(i, j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 0) {
						continue;
					}
					arr[i][j] -= countArr[i][j];
					if (arr[i][j] < 0) {
						arr[i][j] = 0;
					}

					if (arr[i][j] != 0) {
						done = false;
					}
				}
			}
			//			printMap();

			day++;
			if (done) {
				break;
			}
		}

		System.out.println(day);
	}

	private static int getCount(int i, int j) {
		int count = 0;
		for (int k = 0; k < 4; k++) {
			int newI = i + dx[k];
			int newJ = j + dy[k];
			if (newI < 0 || newI >= N || newJ < 0 || newJ >= N) {
				continue;
			}
			if (arr[newI][newJ] == 0) {
				count++;
			}
		}
		return count;
	}

	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
/*
4
0 0 1 0
2 0 0 0
2 2 0 0
2 0 0 0

*/
