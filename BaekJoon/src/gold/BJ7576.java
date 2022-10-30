package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1><a href="https://www.acmicpc.net/problem/7576">토마토</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/30</h2>
 * <br><h2>comment : 다른 사람들 풀이는 왜 내것보다 2배는 빠른거지 고민했는데 역시나 StringTokenizer 때문이었다.</h2>
 */
public class BJ7576 {

	static int M;
	static int N;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] arr;
	static Deque<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		M = Integer.parseInt(split[0]);
		N = Integer.parseInt(split[1]);

		arr = new int[N][M];
		queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			split = br.readLine().split("\\s");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
				if (arr[i][j] == 1) {
					queue.add(new int[]{i, j});
				}
			}
		}

		int answer = BFS();
		if (unreachableTomatoExists()) {
			answer = -1;
		}
		/*
		모두 익을 때 까지 걸리는 시간 출력
		이미 모두 익어있는 상태면 0
		모두 익지 못하는 상황이면 -1
		*/
		System.out.println(answer);
	}

	private static int BFS() {
		int answer = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] poll = queue.poll();
				int a = poll[0];
				int b = poll[1];
				for (int j = 0; j < 4; j++) {
					int newA = a + dx[j];
					int newB = b + dy[j];
					if (!isValidCoordinate(newA, newB)) {
						continue;
					}
					arr[newA][newB] = 1;
					queue.add(new int[]{newA, newB});
				}
			}
			//			printMap();
			answer++;
		}
		return answer - 1; // 0을 다 채우고 나서 while문이 한번 더 돌기 때문에 -1을 해준다
	}

	private static boolean unreachableTomatoExists() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isValidCoordinate(int newA, int newB) {
		if (newA < 0 || newA >= N || newB < 0 || newB >= M) {
			return false;
		}
		if (arr[newA][newB] >= 1 || arr[newA][newB] == -1) {
			return false;
		}
		return true;
	}

	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
