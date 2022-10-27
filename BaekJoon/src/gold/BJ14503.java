package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://www.acmicpc.net/problem/14503">로봇 청소기</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 1.5h</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/27</h2>
 * <br><h2>comment : 방향을 고려해야해서 어려웠다.
 * <br>역시 이런 문제는 printMap() 메서드를 만들어두고 계속 출력해보면서 풀어야겠다</h2>
 */
/*
세로 N, 가로 M
1. 현재 방향을 기준으로 왼쪽 방향 부터 탐색
2. 청소할게 있으면 왼쪽으로 회전 후 전진
3. 청소할게 없으면 왼쪽으로 돌고, 거기서 다시 왼쪽 방향 탐색
4. 네 방향 모두 청소할게 없다면 현재 방향 기준 뒤로 한칸 이동
5. 반복
6. 움직일 수 있는 경우가 없어지면 끝

0 북, 1 동, 2 남, 3 서
*/
public class BJ14503 {

	public static final String WALL = "1";
	public static final String CLEAN = "-";
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int count = 0;
	static String[][] map;
	private static boolean stop;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int N = Integer.parseInt(split[0]); // 세로
		int M = Integer.parseInt(split[1]); // 가로

		split = br.readLine().split("\\s");
		int r = Integer.parseInt(split[0]);
		int c = Integer.parseInt(split[1]);
		int d = Integer.parseInt(split[2]);

		map = new String[N][M];

		for (int i = 0; i < N; i++) {
			split = br.readLine().split("\\s");
			for (int j = 0; j < M; j++) {
				map[i][j] = split[j];
			}
		}

		DFS(r, c, d);

		System.out.println(count);
	}

	private static void DFS(int r, int c, int d) {
		if (stop) {
			return;
		}
		if (!map[r][c].equals(CLEAN)) {
			count++;
			map[r][c] = CLEAN;
		}
		//		printMap();
		int newR = 0;
		int newC = 0;
		int newD = d;
		for (int i = 0; i < 4; i++) {
			if (newD - 1 < 0) {
				newD = 3;
			} else {
				newD = newD - 1;
			}
			newR = r + dx[newD];
			newC = c + dy[newD];
			if (map[newR][newC].equals(WALL) || map[newR][newC].equals(CLEAN)) {
				continue;
			}
			DFS(newR, newC, newD);
		}

		int backR = r - dx[newD];
		int backC = c - dy[newD];
		if (map[backR][backC].equals(WALL)) {
			stop = true;
			System.out.println("STOPPPPPP");
			return;
		}
		DFS(backR, backC, newD);
	}

	//	public static void printMap() {
	//		StringBuilder sb = new StringBuilder();
	//		for (int i = 0; i < map.length; i++) {
	//			for (int j = 0; j < map[0].length; j++) {
	//				sb.append(map[i][j]).append(" ");
	//			}
	//			sb.append("\n");
	//		}
	//		System.out.println(sb);
	//	}
}
/*
11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1
*/
