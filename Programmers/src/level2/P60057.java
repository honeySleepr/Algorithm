package level2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1><a href="https://school.programmers.co.kr/learn/courses/30/lessons/60057">문자열 압축</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/18</h2>
 * <br><h2>comment : 왜이리 머리가 안돌아갈까?  </h2>
 */
public class P60057 {

	public int solution(String s) {
		int length = s.length();

		int answer = length;
		String tempSt = "";

		for (int i = 1; i <= length / 2; i++) { /* length/2 보다 커지면 압축이 안된다 */
			tempSt = s.substring(0, i);
			int sum = 0;
			int count = 1;
			for (int j = i; j <= length - i; j += i) {
				String substring = s.substring(j, j + i);
				if (tempSt.equals(substring)) {
					count++;
					continue;
				}

				tempSt = substring;
				if (count == 1) {
					sum += i;
				} else {
					sum += i + 1 + Math.log10(count);
				}
				count = 1;
			}

			if (count == 1) {
				sum += i;
			} else {
				sum += i + 1 + Math.log10(count); /* count가 1~9면 +1만 하면 되지만 , 10~99 면 +2가 되어야하고, 100~999 면 +3이 되어야한다 */
			}
			sum += length % i; /* 뒤에 남은 자리를 더해준다 */

			if (sum == 0) {
				continue;
			}

			answer = Math.min(answer, sum);
		}
		return answer;
	}

	static class TestP60057 {

		private final P60057 p = new P60057();

		//		@Test
		void changeBracket() {
			String[] input = {""};
			for (String s : input) {
				System.out.println(s.replaceAll("\\[", "{").replaceAll("]", "}"));
			}
		}

		@Test
		void test1() {
			String s = "aabbacc";
			int anwer = 7;
			assertThat(p.solution(s)).isEqualTo(anwer);
		}

		@Test
		void test2() {
			String s = "ababcdcdababcdcd";
			int anwer = 9;
			assertThat(p.solution(s)).isEqualTo(anwer);
		}

		@Test
		void test3() {
			String s = "abcabcdede";
			int anwer = 8;
			assertThat(p.solution(s)).isEqualTo(anwer);
		}

		@Test
		void test4() {
			String s = "abcabcabcabcdededededede";
			int anwer = 14;
			assertThat(p.solution(s)).isEqualTo(anwer);
		}

		@Test
		void test5() {
			String s = "werwerwsdgsdfsdfsdf";
			int anwer = 17;
			assertThat(p.solution(s)).isEqualTo(anwer);
		}
	}

}
