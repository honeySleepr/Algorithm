package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://level.goorm.io/l/challenge">철자 분리 집합</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 5m</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/10/12</h2>
 * <br><h2>comment :</h2>
 */
public class P2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		char[] chars = br.readLine().toCharArray();

		char prev = '0';
		int count = 0;
		for (char c : chars) {
			if (c != prev) {
				count++;
				prev = c;
			}
		}
		System.out.println(count);
	}

}
