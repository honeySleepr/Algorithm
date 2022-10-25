package level2;

import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiFunction;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1><a href="https://school.programmers.co.kr/learn/courses/30/lessons/67257">수식 최대화</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/25</h2>
 * <br><h2>comment : </h2>
 */
public class P67257 {

	LinkedList<Long> numList;
	LinkedList<Character> signList;
	char[] chosenSigns = new char[3];
	char[] signs = {'*', '+', '-'};

	boolean[] used = new boolean[3];
	long answer = 0;
	Map<Character, BiFunction<Long, Long, Long>> operationMap = Map.of(
		'*', (a, b) -> a * b,
		'+', (a, b) -> a + b,
		'-', (a, b) -> a - b
	);

	public long solution(String expression) {
		numList = new LinkedList<>();
		signList = new LinkedList<>();

		char[] chars = expression.toCharArray();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < chars.length; i++) {
			if (Character.isDigit(chars[i])) {
				sb.append(chars[i]);
				continue;
			}
			/* 기호인 경우 */
			numList.add(Long.parseLong(sb.toString()));
			sb.setLength(0);
			signList.add(chars[i]);
		}
		numList.add(Long.parseLong(sb.toString()));
		permutation(0);

		return answer;
	}

	private void permutation(int level) {

		if (level == 3) {
			long l = calcSum();
			answer = Math.max(answer, Math.abs(l));
			return;
		}
		for (int i = 0; i < signs.length; i++) {
			if (used[i]) {
				continue;
			}
			used[i] = true;
			chosenSigns[level] = signs[i];
			permutation(level + 1);
			used[i] = false;
		}
	}

	private long calcSum() {
		LinkedList<Character> signListClone = new LinkedList<>(signList);
		LinkedList<Long> numListClone = new LinkedList<>(numList);

		for (char sign : chosenSigns) {
			for (int j = 0; j < signListClone.size(); j++) {
				if (signListClone.get(j) == sign) {
					signListClone.remove(j);
					Long a = numListClone.remove(j);
					Long b = numListClone.remove(j);
					numListClone.add(j, operationMap.get(sign).apply(a, b));
					j--;
				}
			}
		}
		return numListClone.get(0);
	}

	static class TestP67257 {

		private final P67257 p = new P67257();

		//		@Test
		void changeBracket() {
		}

		@Test
		void test1() {
			String expression = "100-200*300-500+20";
			long answer = 60420;
			assertThat(p.solution(expression)).isEqualTo(answer);
		}

		@Test
		void test2() {
			String expression = "50*6-3*2";
			long answer = 300;
			assertThat(p.solution(expression)).isEqualTo(answer);
		}

	}
}
