package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://www.acmicpc.net/problem/5525">IOIOI</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/20</h2>
 * <br><h2>comment : 이런 생각을 어떻게 해내지.. 다시 혼자 풀어보고 제출할 것</h2>
 */
public class BJ5525 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] chars = br.readLine().toCharArray();
		int count = 0;
		int answer = 0;
		for (int i = 2; i < M; i++) {
			if (chars[i - 2] == 'I' && chars[i - 1] == 'O' && chars[i] == 'I') {
				count++;
				if (count == N) {
					answer++;
					count--;
				}
				i++;
				continue;
			}
			count = 0;
		}

		System.out.println(answer);
	}
}
/*
1
13
OOIOIOIOIIOII
*/
