package level3;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1><a href="https://school.programmers.co.kr/learn/courses/30/lessons/43238">입국 심사</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/11/01</h2>
 * <br><h2>comment : 뭐를 이분 탐색해야하는지 찾느라 한참 걸렸고, 이분 탐색 자체도 까먹어서 헤맸다. 기억이 왜이리 휘발성일까
 * <br>이분 탐색이 헷갈리면 참고하자 <a href="https://st-lab.tistory.com/267">블로그 링크</a></h2>
 */
public class P43238 {

	public long solution(int n, int[] times) {

		int max = 0;
		for (int time : times) {
			if (max < time) {
				max = time;
			}
		}

		long lo = 1;
		long hi = max * (long) n; /* 이 부분에서 캐스팅을 해주지 않으면, 10억*10억이 int로 우선 계산 된 뒤 long으로 변환되기 때문에 이상한 값이 된다 */

		/* 이분탐색 템플릿 (최소값)*/
		while (lo < hi) {
			long mid = lo + (hi - lo) / 2;

			long headCount = 0;
			for (int time : times) {
				headCount += mid / time;
			}

			if (headCount >= n) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;
	}

	static class TestP43238 {

		private final P43238 p = new P43238();

		//		@Test
		void changeBracket() {
			String[] input = {""};
			for (String s : input) {
				System.out.println(s.replaceAll("\\[", "{").replaceAll("]", "}"));
			}
		}

		@Test
		void test1() {
			int n = 9;
			int[] times = {1, 5};
			int answer = 8;
			assertThat(p.solution(n, times)).isEqualTo(answer);
		}

		@Test
		void test2() {
			int n = 6;
			int[] times = {7, 10};
			int answer = 28;
			assertThat(p.solution(n, times)).isEqualTo(answer);
		}

	}
}
