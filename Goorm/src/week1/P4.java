package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="">소수 찾기</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/08</h2>
 * <br><h2>comment :</h2>
 */
public class P4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split("\\s");

		/* 에라토스테네스의 체 템플릿 */
		boolean[] notPrime = new boolean[n + 1];
		notPrime[0] = notPrime[1] = true;
		for (int i = 2; i * i <= n; i++) {
			if (notPrime[i]) {
				continue;
			}
			for (int j = i * i; j <= n; j += i) {
				notPrime[j] = true;
			}
		}

		int answer = 0;
		for (int i = 1; i < notPrime.length; i++) {
			if (!notPrime[i]) {
				answer += Integer.parseInt(split[i - 1]);
			}
		}
		System.out.println(answer);
	}

}
