package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * <h1><a href="https://level.goorm.io/exam/159769/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EB%A8%BC%EB%8D%B0%EC%9D%B4-3%ED%9A%8C/quiz/2">폴더
 * 폰 자판</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/18</h2>
 * <br><h2>comment :</h2>
 */
public class P2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, String> map = Map.of(
			"1", "1.,?!",
			"2", "2ABC",
			"3", "3DEF",
			"4", "4GHI",
			"5", "5JKL",
			"6", "6MNO",
			"7", "7PQRS",
			"8", "8TUV",
			"9", "9WXYZ"
		);

		StringBuilder sb = new StringBuilder();
		String[] split = br.readLine().split("");
		String temp = split[0];
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (!temp.equals(split[i])) {
				String s = map.get(temp);
				count = (count - 1) % s.length();
				sb.append(s.charAt(count));

				temp = split[i];
				count = 1;
				continue;
			}
			count++;
		}

		String s = map.get(temp);
		count = (count - 1) % s.length();
		sb.append(s.charAt(count));

		System.out.println(sb);
	}

}
