package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * <h1><a href="https://www.acmicpc.net/problem/1269">대칭 차집합</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/11/25</h2>
 * <br><h2>comment : A와 B의 교집합만 구하면 되니까 Set을 하나만 만들어줘도 되는구나 </h2>
 */
public class BJ1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Set<String> setA = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			setA.add(st.nextToken());
		}

		int duplicateCount = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			if (setA.contains(st.nextToken())) {
				duplicateCount++;
			}
		}

		System.out.println(A + B - (2 * duplicateCount));
	}
}
