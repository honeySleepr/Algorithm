package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1><a href="https://level.goorm.io/exam/160278/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%A8%BC%EB%8D%B0%EC%9D%B4-4%ED%9A%8C/quiz/1">체크
 * 카드</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/29</h2>
 * <br><h2>comment :</h2>
 */
/*
처음 잔액 N(0~100,000), 지난달 거래 횟수 M(1~10,000)이 주어진다

10
5
0
-5
-5
5
*/

public class P1 {

	static int N;
	static Deque<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		for (int i = 0; i < M; i++) {
			split = br.readLine().split("\\s");
			transaction(split[0], Integer.parseInt(split[1]));
		}

		System.out.println(N);
	}

	private static void transaction(String action, int amount) {
		switch (action) {
			case "deposit":
				N += amount;
				while (!queue.isEmpty() && N >= queue.peek()) { /* 이 부분 빼먹음 주의 */
					N -= queue.poll();
				}
				return;
			case "pay":
				if (N >= amount) {
					N -= amount;
				}
				return;
			case "reservation":
				queue.add(amount);
				if (!queue.isEmpty() && N >= queue.peek()) {
					N -= queue.poll();
				}
				return;
			default:
				System.out.println("transaction error");
		}

	}
}
/*
0 6
reservation 10
reservation 10
reservation 10
reservation 10
reservation 10
deposit 100

10
10 - 20
5 - 20
15 - 20
5

*/
