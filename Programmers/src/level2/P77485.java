package level2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1>행렬 테두리 회전하기</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 55m</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎︎</h2>
 * <h2>날짜 : 2022/10/01</h2>
 * <br><h2>comment : 구현 문제 </h2>
 */
public class P77485 {

	int[][] map;
	int min;
	int toss;

	public int[] solution(int rows, int columns, int[][] queries) {
		map = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = i * columns + j + 1;
			}
		}
		int[] answer = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			int x1 = queries[i][0] - 1;
			int y1 = queries[i][1] - 1;
			int x2 = queries[i][2] - 1;
			int y2 = queries[i][3] - 1;

			min = Integer.MAX_VALUE;
			toss = map[x1][y1];
			moveHorizontal(x1, y1, y2);
			moveVertical(x1, y2, x2);
			moveHorizontal(x2, y2, y1);
			moveVertical(x2, y1, x1);

			answer[i] = min;
		}
		return answer;
	}

	private void moveVertical(int x1, int y1, int x2) {
		int diff = x1 - x2 > 0 ? -1 : 1;

		int prev = toss;
		int temp = 0;
		while (x1 != x2) {
			min = Math.min(prev, min);
			x1 += diff;
			temp = map[x1][y1];
			map[x1][y1] = prev;
			prev = temp;
		}
		toss = temp;
	}

	private void moveHorizontal(int x1, int y1, int y2) {
		int diff = y1 - y2 > 0 ? -1 : 1;

		int prev = toss;
		int temp = 0;
		while (y1 != y2) {
			min = Math.min(prev, min);
			y1 += diff;
			temp = map[x1][y1];
			map[x1][y1] = prev;
			prev = temp;
		}
		toss = temp;
	}

	static class TestP77485 {

		private final P77485 p = new P77485();

		@Test
		void test1() {
			int rows = 6;
			int columns = 6;
			int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
			int[] answer = {8, 10, 25};
			assertThat(p.solution(rows, columns, queries)).isEqualTo(answer);
		}

		@Test
		void test2() {
			int rows = 3;
			int columns = 3;
			int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
			int[] answer = {1, 1, 5, 3};
			assertThat(p.solution(rows, columns, queries)).isEqualTo(answer);
		}
	}

}
