package level2;

import java.util.ArrayDeque;
import java.util.Deque;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1><a href="https://school.programmers.co.kr/learn/courses/30/lessons/1844">게임 맵 최단거리
 * </a></a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/11/10</h2>
 * <br><h2>comment : 여전히 구현이 느리다. 알고를 열심히 하진 않더라도 꾸준히는 연습해야겠다</h2>
 */
public class P1844 {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int M;

	public int solution(int[][] maps) {
		arr = maps;
		N = arr.length;
		M = arr[0].length;
		visited = new boolean[N][M];
		BFS(0, 0);
		//		printMap();
		if (!visited[N - 1][M - 1]) {
			return -1;
		}
		return arr[N - 1][M - 1];
	}

	/* BFS 템플릿. for문을 하나만 사용하는 버전. 2중 for문 버전과 시간 복잡도는 같다 */
	private void BFS(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{x, y});
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int oldX = poll[0];
			int oldY = poll[1];

			for (int j = 0; j < 4; j++) {
				int newX = oldX + dx[j];
				int newY = oldY + dy[j];
				/* 맵 범위 밖을 벗어나거나, 벽이거나, 이미 방문했다면 패스 */
				if (newX < 0 || newX >= N || newY < 0 || newY >= M ||
					arr[newX][newY] == 0 || visited[newX][newY]) {
					continue;
				}
				queue.add(new int[]{newX, newY});
				visited[newX][newY] = true;
				arr[newX][newY] = arr[oldX][oldY] + 1;

				/* 목표지점에 도달했다면 while문 탈출 */
				if (newX == N - 1 && newY == M - 1) {
					return;
				}
			}
		}
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

	static class TestP1844 {

		private final P1844 p = new P1844();

		//				@Test
		void changeBracket() {
			String[] input = {"[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]"};
			for (String s : input) {
				System.out.println(s.replaceAll("\\[", "{").replaceAll("]", "}"));
			}
		}

		@Test
		void test1() {
			int maps[][] = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
			int answer = 11;
			assertThat(p.solution(maps)).isEqualTo(answer);
		}

		@Test
		void test2() {
			int maps[][] = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
			int answer = -1;
			assertThat(p.solution(maps)).isEqualTo(answer);
		}
	}
}
