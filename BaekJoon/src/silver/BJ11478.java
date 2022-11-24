package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1><a href="https://www.acmicpc.net/problem/11478">서로 다른 부분 문자열의 개수</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/11/25</h2>
 * <br><h2>comment : string.substring()도 다른 string 관련 연산처럼 느리다고 생각했는데
 * 문자 분할만 할거면 Stringbuilder보다 오히려 빠르군;</h2>
 */
public class BJ11478 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int size = s.length();

		Set<String> set = new HashSet<>();

		for (int i = 1; i <= size; i++) {
			for (int r = 0; r <= size - i; r++) {
				set.add(s.substring(r, r + i));
			}
		}

		System.out.println(set.size());
	}
}
