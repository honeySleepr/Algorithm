package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="">동명이인</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/08</h2>
 * <br><h2>comment :</h2>
 */
public class P2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int n = Integer.parseInt(split[0]);
		String regex = ".*" + split[1] + ".*";

		int answer = 0;
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if (input.matches(regex)) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
