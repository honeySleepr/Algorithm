package level1;

import java.io.IOException;

/**
 * <h1>두 정수 사이의 합</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/03</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment :</h2>
 */
public class P12912 {

	public static void main(String[] args) throws IOException {

		Solution12912 s = new Solution12912();
		s.solution(3, 5);
	}
}

class Solution12912 {
	public long solution(int a, int b) {
		int start;
		int end;
		if (a == b) {
			return a;
		}

		if (a > b) {
			start = b;
			end = a;
		} else {
			start = a;
			end = b;
		}
		long answer = 0;
		for (int i = start; i <= end; i++) {
			answer += i;
		}
		return answer;
	}
}
