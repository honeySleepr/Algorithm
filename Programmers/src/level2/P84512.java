package level2;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1>모음 사전</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 25m</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/01</h2>
 * <br><h2>comment :</h2>
 */
public class P84512 {

	private final String AEIOU = "AEIOU";

	public int solution(String word) {
		List<String> dictionary = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		permutation(sb, dictionary);

		return dictionary.indexOf(word);
	}

	private void permutation(StringBuilder sb, List<String> dictionary) {
		if (sb.length() > 5) {
			return;
		}
		dictionary.add(sb.toString());
		for (int i = 0; i < 5; i++) {
			sb.append(AEIOU.charAt(i));
			permutation(sb, dictionary);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	static class TestP84512 {

		private final P84512 p = new P84512();

		@Test
		void test1() {
			String word = "AAAAE";
			int answer = 6;
			assertThat(p.solution(word)).isEqualTo(answer);
		}

		@Test
		void test2() {
			String word = "I";
			int answer = 1563;
			assertThat(p.solution(word)).isEqualTo(answer);
		}

		@Test
		void test3() {
			String word = "EIO";
			int answer = 1189;
			assertThat(p.solution(word)).isEqualTo(answer);
		}
	}

}
