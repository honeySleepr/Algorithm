package level2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1>전력망을 둘로 나누기 - 풀이 개선 버전</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 2h</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/09/30</h2>
 * <br><h2>comment : wire 끊을 필요 없이 DFS를 이용해 자식 노드의 수만 구해와서 비교하는 방식. BFS 보다 훨씬 빠르다 </h2>
 */
public class P86971_Better {

	int min = Integer.MAX_VALUE;
	int N;

	public int solution(int n, int[][] wires) {
		N = n;
		int[][] map = new int[n + 1][n + 1];

		for (int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];
			map[a][b] = 1;
			map[b][a] = 1;
		}
		boolean[] visited = new boolean[n + 1];
		DFS(visited, map, 1);

		return min;
	}

	private int DFS(boolean[] visited, int[][] map, int node) {
		visited[node] = true;

		int child = 1;
		for (int i = 0; i < map[node].length; i++) {
			if (map[node][i] == 1 && !visited[i]) {
				child += DFS(visited, map, i);
			}
		}
		/* 각 노드의 자식노드(자신포함) 개수를 행렬 같은 곳에 담을 필요 없이, 그때그때 바로 최소값(답)이 될 수 있는지 체크한다 */
		min = Math.min(min, Math.abs(child - (N - child)));
		return child;
	}

	static class TestP86971 {

		private final P86971_Better p = new P86971_Better();

		@Test
		void test1() {
			int n = 9;
			int[][] input = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
			int answer = 3;
			assertThat(p.solution(n, input)).isEqualTo(answer);
		}

		@Test
		void test2() {
			int n = 4;
			int[][] input = {{1, 2}, {2, 3}, {3, 4}};
			int answer = 0;
			assertThat(p.solution(n, input)).isEqualTo(answer);
		}

		@Test
		void test3() {
			int n = 7;
			int[][] input = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
			int answer = 1;
			assertThat(p.solution(n, input)).isEqualTo(answer);
		}

	}
}
