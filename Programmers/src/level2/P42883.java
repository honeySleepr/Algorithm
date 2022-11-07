package level2;

import java.util.ArrayDeque;
import java.util.Deque;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1><a href="https://school.programmers.co.kr/learn/courses/30/lessons/42883">큰 수 만들기</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/17</h2>
 * <br><h2>comment : Greedy. 맨 앞에 큰 숫자들이 오도록 해야하는데 어떤 식으로 구현해야 할지 생각해내지 못했다.
 * 앞에서 부터 숫자를 stack에 넣는데, 새로 넣는 숫자가 peek 보다 크면, peek을 지운다 한바퀴 다 돌아도 k가 남는다면 뒤에서부터는 남은 k 만큼 지우기만 하면 된다(크기 비교는 위에서 이미 처리했기
 * 때문)</h2>
 */
public class P42883 {

	public String solution(String number, int k) {
		Deque<Integer> stack = new ArrayDeque<>();

		int popCount = 0;
		for (String s : number.split("")) {
			int num = Integer.parseInt(s);
			while (!stack.isEmpty() && stack.peek() < num && popCount < k) {
				stack.pop();
				popCount++;
			}
			stack.push(num);
		}

		StringBuilder sb = new StringBuilder();
		while (popCount < k) {
			stack.pop();
			popCount++;
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

	static class TestP42883 {

		private final P42883 p = new P42883();

		@Test
		void changeBracket() {
			String[] input = {""};
			for (String s : input) {
				System.out.println(s.replaceAll("\\[", "{").replaceAll("]", "}"));
			}
		}

		@Test
		void test1() {
			String number = "4177252841";
			int k = 4;
			String answer = "775841";
			assertThat(p.solution(number, k)).isEqualTo(answer);
		}

		@Test
		void test2() {
			String number = "111888543";
			int k = 4;
			String answer = "88854";
			assertThat(p.solution(number, k)).isEqualTo(answer);
		}
	}

}
