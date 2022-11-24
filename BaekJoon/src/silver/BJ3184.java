package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <h1><a href="https://www.acmicpc.net/problem/3184">양</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎︎</h2>
 * <h2>날짜 : 2022/11/22</h2>
 * <br><h2>comment :</h2>
 */
public class BJ3184 {

	private static char[][] map;
	private static int R;
	private static int C;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int wolfCount;
	private static int sheepCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int sheepTotalCount = 0;
		int wolfTotalCount = 0;
		map = new char[R][C];
		// 맵 그리기
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 벽이 아닌 곳이라면 영역 탐색 시작
				if (map[i][j] != '#') {
					wolfCount = 0;
					sheepCount = 0;
					search(i, j);
					if (sheepCount > wolfCount) {
						sheepTotalCount += sheepCount;
						continue;
					}
					wolfTotalCount += wolfCount;
				}
			}
		}

		System.out.println(sheepTotalCount + " " + wolfTotalCount);
		/*
		1. "#"를 제외한 다른 물체를 찾으면 해당 영역 탐색
		2. 양의 수와 늑대의 수 파악
		3. 이기는 쪽 카운트에 추가
		4. 반복
		*/
	}

	private static void search(int i, int j) {
		printMap();
		// 늑대 발견
		if (map[i][j] == 'v') {
			wolfCount++;
		}
		// 양 발견
		if (map[i][j] == 'o') {
			sheepCount++;
		}

		// 지나온 곳은 이제 필요없으니 벽으로 표시
		map[i][j] = '#';

		for (int a = 0; a < 4; a++) {
			int newI = i + dx[a];
			int newJ = j + dy[a];
			if (newI < 0 || newI >= R || newJ < 0 || newJ >= C || map[newI][newJ] == '#') {
				continue;
			}
			search(newI, newJ);
		}

	}

	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
		System.out.println("-------------------");
	}
}
