package level3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1><a href="https://school.programmers.co.kr/learn/courses/30/lessons/92344">파괴되지 않은 건물</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 1d</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/06</h2>
 * <br><h2>comment : 그냥 for문을 돌면 효율성 테스트가 통과하지 못하기 때문에 누적합을 이용해야한다 <a href="https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/">풀이</a>
 * <br> 누적합을 이용해 2차원 행렬의 연산에서 시간복잡도를 줄이는 방법을 배웠다. O(skill*N*M) -> O(N*M)
 * <br> 2차원 행렬 누적합 템플릿 </h2>
 */
public class P92344 {

	public int solution(int[][] board, int[][] skill) {
		final int N = board.length;
		final int M = board[0].length;
		int[][] prefixSum = new int[N + 1][M + 1]; /* 누적합 2차원 행렬 */

		for (int i = 0; i < skill.length; i++) {
			int power = 0;
			if (skill[i][0] == 1) {
				power = -skill[i][5];
			} else {
				power = skill[i][5];
			}
			int r1 = skill[i][1];
			int c1 = skill[i][2];
			int r2 = skill[i][3];
			int c2 = skill[i][4];

			prefixSum[r1][c1] += power;
			prefixSum[r2 + 1][c2 + 1] += power;
			prefixSum[r1][c2 + 1] += (-1) * power;
			prefixSum[r2 + 1][c1] += (-1) * power;
		}

		/* 가로 누적합 */
		for (int x = 0; x <= N; x++) {
			for (int y = 1; y <= M; y++) {
				prefixSum[x][y] += prefixSum[x][y - 1];
			}
		}

		/* 세로 누적합 */
		for (int y = 0; y <= M; y++) {
			for (int x = 1; x <= N; x++) {
				prefixSum[x][y] += prefixSum[x - 1][y];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] += prefixSum[i][j];
			}
		}

		int answer = 0;
		for (int[] ints : board) {
			for (int i : ints) {
				if (i > 0) {
					answer++;
				}
			}
		}

		return answer;
	}

	static class TestP92344 {

		private final P92344 p = new P92344();

		//		@Test
		void changeBracket() {
			String[] input = {"[[1,2,3],[4,5,6],[7,8,9]]", "[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]"};
			for (String s : input) {
				System.out.println(s.replaceAll("\\[", "{").replaceAll("]", "}"));
			}
		}

		@Test
		void test1() {
			int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
			int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
			int answer = 10;
			assertThat(p.solution(board, skill)).isEqualTo(answer);
		}

		@Test
		void test2() {
			int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
			int[][] skill = {{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};
			int answer = 6;
			assertThat(p.solution(board, skill)).isEqualTo(answer);
		}
	}
}
