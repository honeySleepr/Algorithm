package level2;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1><a href="https://school.programmers.co.kr/learn/courses/30/lessons/42885">구명보트</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/13</h2>
 * <br><h2>comment : 최대 2명만 태울 수 있다. 아이디어가 떠오르지 않아 결국 타니의 설명을 듣고서야 풀었다 </h2>
 */
public class P42885 {

	public int solution(int[] people, int limit) {
		int n = people.length;
		Arrays.sort(people);

		int l = 0;
		int r = n - 1;
		int answer = 0;

		while (l <= r) {
			int sum = people[l] + people[r];
			if (sum > limit) {
				answer++;
				r--;
				continue;
			}
			answer++;
			l++;
			r--;
		}

		return answer;
	}

	static class TestP42885 {

		private final P42885 p = new P42885();

		@Test
		void changeBracket() {
			String[] input = {};
			for (String s : input) {
				System.out.println(s.replaceAll("\\[", "{").replaceAll("]", "}"));
			}
		}

		@Test
		void test1() {
			int[] people = {70, 50, 80, 50};
			int limit = 100;
			int answer = 3;
			assertThat(p.solution(people, limit)).isEqualTo(answer);
		}

		@Test
		void test2() {
			int[] people = {70, 80, 50};
			int limit = 100;
			int answer = 3;
			assertThat(p.solution(people, limit)).isEqualTo(answer);
		}

		@Test
		void test3() {
			int[] people = {40, 40, 50, 50, 90, 90};
			int limit = 90;
			int answer = 4;
			assertThat(p.solution(people, limit)).isEqualTo(answer);
		}
	}

}
