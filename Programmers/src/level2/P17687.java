package level2;

import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1><a href="https://school.programmers.co.kr/learn/courses/30/lessons/17687">n진수 게임</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 1h</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/11</h2>
 * <br><h2>comment : `Integer.toString(i, n)` 을 이용해 10진수 i를 n진법 수로 쉽게 변환할 수 있다는걸 배웠다 </h2>
 */
public class P17687 {

	Map<Integer, String> map = Map.of(
		10, "A",
		11, "B",
		12, "C",
		13, "D",
		14, "E",
		15, "F"
	);

	StringBuilder sb = new StringBuilder();

	public String solution(int n, int t, int m, int p) {
		StringBuilder localSb = new StringBuilder();

		localSb.append(0);
		for (int i = 1; i <= t * m; i++) {
			//			String decimal = getDecimal(n, i);
			String decimal = Integer.toString(i, n); // Java API를 이용해 간단하게 풀 수 있다;;
			localSb.append(decimal);
		}
		StringBuilder answerSb = new StringBuilder();
		String[] split = localSb.toString().split("");
		for (int i = p - 1; i < t * m; i += m) {
			answerSb.append(split[i]);
		}
		return answerSb.toString().toUpperCase();
	}

	/* 진법 변환기 템플릿 */
	private String getDecimal(int n, int i) {
		sb.setLength(0);
		while (i > 0) {
			if (i % n >= 10) {
				sb.append(map.get(i % n));
			} else {
				sb.append(i % n);
			}
			i /= n;
		}
		return sb.reverse().toString();
	}

	static class TestP17687 {

		private final P17687 p = new P17687();

		//		@Test
		void changeBracket() {
			String[] input = {""};
			for (String s : input) {
				System.out.println(s.replaceAll("\\[", "{").replaceAll("]", "}"));
			}
		}

		@Test
		void test1() {
			assertThat(p.solution(2, 4, 2, 1)).isEqualTo("0111");
		}

		@Test
		void test2() {
			assertThat(p.solution(16, 16, 2, 1)).isEqualTo("02468ACE11111111");
		}

		@Test
		void test3() {
			assertThat(p.solution(16, 16, 2, 2)).isEqualTo("13579BDF01234567");
		}
	}

}
