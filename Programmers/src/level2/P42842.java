package level2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1>카펫</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 26m</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/09/30</h2>
 * <br><h2>comment : 1. ab=B+Y, (a-2)(b-2)=Y -> [ a+b = B/2 + 2 ]
 * <br>2. ∴ [a+b = B/2 + 2] 와 [ab = B+Y]를 동시에 만족하는 a,b를 찾는다</h2>
 */
public class P42842 {

	public int[] solution(int brown, int yellow) {
		int sumTarget = brown / 2 + 2;
		int[] answer = new int[2];
		for (int a = 1; a <= sumTarget; a++) {

			if (a * (sumTarget - a) == brown + yellow) {
				answer[0] = sumTarget - a;
				answer[1] = a;
				break;
			}

		}
		return answer;
	}

	static class TestP42842 {

		private final P42842 p = new P42842();

		@Test
		void test1() {
			int brown = 10;
			int yellow = 2;
			int[] answer = {4, 3};
			assertThat(p.solution(brown, yellow)).isEqualTo(answer);
		}

		@Test
		void test2() {
			int brown = 8;
			int yellow = 1;
			int[] answer = {3, 3};
			assertThat(p.solution(brown, yellow)).isEqualTo(answer);
		}

		@Test
		void test3() {
			int brown = 24;
			int yellow = 24;
			int[] answer = {8, 6};
			assertThat(p.solution(brown, yellow)).isEqualTo(answer);
		}

	}
}
