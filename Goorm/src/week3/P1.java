package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1><a href="https://level.goorm.io/exam/159769/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EB%A8%BC%EB%8D%B0%EC%9D%B4-3%ED%9A%8C/quiz/1">0커플</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/18</h2>
 * <br><h2>comment :</h2>
 */
public class P1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split("\\s");

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(split[i]);
			if (set.contains((-1) * n)) {
				set.remove((-1) * n);
				continue;
			}
			set.add(n);
		}

		int answer = 0;
		for (Integer integer : set) {
			answer += integer;
		}

		System.out.println(answer);
	}

}
