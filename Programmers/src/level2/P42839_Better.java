package level2;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1>소수 찾기</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/29</h2>
 * <br><h2>comment : permutation(순열) 구현 방법 잊지 말자</h2>
 */
public class P42839_Better {

	private boolean[] used;
	private Set<Integer> numSet;

	public int solution(String numbers) {
		StringBuilder sb = new StringBuilder();
		numSet = new HashSet<>();
		used = new boolean[numbers.length()];
		permutation(sb, numbers);

		int primeCount = 0;
		for (Integer num : numSet) {
			if (isPrime(num)) {
				primeCount++;
			}
		}

		return primeCount;
	}

	private boolean isPrime(Integer num) {
		if (num == 0 || num == 1) {
			return false;
		}
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	/* [permutation릿 템플릿, DFS, 순열, Stringbuilder 사용 */
	private void permutation(StringBuilder sb, String numbers) {
		if (sb.length() > numbers.length()) {
			return;
		}
		if (sb.length() != 0) {
			numSet.add(Integer.parseInt(sb.toString()));
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (used[i]) {
				continue;
			}
			used[i] = true;
			sb.append(numbers.charAt(i));
			permutation(sb, numbers);
			sb.deleteCharAt(sb.length() - 1);
			used[i] = false;
		}
	}

	static class TestP42839 {

		private final P42839_Better p = new P42839_Better();

		@Test
		void test1() {
			String input = "011";
			int answer = 2;
			assertThat(p.solution(input)).isEqualTo(answer);
		}

		@Test
		void test2() {
			String input = "17";
			int answer = 3;
			assertThat(p.solution(input)).isEqualTo(answer);
		}

		@Test
		void test3() {
			String input = "12345";
			int answer = 36;
			assertThat(p.solution(input)).isEqualTo(answer);
		}

	}
}
