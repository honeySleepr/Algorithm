package level2;

import java.util.ArrayDeque;
import java.util.Deque;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1>전력망을 둘로 나누기</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 2h</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/09/30</h2>
 * <br><h2>comment : 인접행렬 오랜만에 쓰니 다 까먹었다. 이런 노드 문제가 아직 어렵다. 그리고 답은 맞지만 속도가 너무 느리다(평균 10ms 이상;)
 * <br>wire를 하나하나 끊을 필요 없이 DFS를 이용해 자식 노드의 수만 구해와서 비교하는 방식으로 풀어봐야겠다 </h2>
 */
public class P86971 {

	public int solution(int n, int[][] wires) {

		int[][] map = new int[n + 1][n + 1];

		for (int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];
			map[a][b] = 1;
			map[b][a] = 1;
		}

		int answer = n;

		for (int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];
			map[a][b] = 0;
			map[b][a] = 0;
			int count = BFS(n, map, 1);
			answer = Math.min(Math.abs((n - count) - count), answer);

			map[a][b] = 1;
			map[b][a] = 1;
		}

		return answer;
	}

	private int BFS(int n, int[][] map, int start) {
		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] checked = new boolean[n + 1];

		queue.add(start);
		checked[start] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			count++;
			for (int j = 1; j < map[poll].length; j++) {
				if (map[poll][j] == 1 && !checked[j]) {
					queue.add(j);
					checked[j] = true;
				}
			}
		}

		return count;
	}

	static class TestP86971 {

		private final P86971 p = new P86971();

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
