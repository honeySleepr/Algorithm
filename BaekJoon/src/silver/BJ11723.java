package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * <h1><a href="https://www.acmicpc.net/problem/11723">집합</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/11/09</h2>
 * <br><h2>comment : Set을 구현하는 문제</h2>
 */
public class BJ11723 {

	static LinkedList<String> S = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String[] split = br.readLine().split("\\s");
			if (split.length == 1) {
				operate(split[0]);
				continue;
			}
			operate(split[0], split[1]);
		}
		System.out.println(sb);
	}

	private static void operate(String s, String num) {
		switch (s) {
			case "add":
				if (!S.contains(num)) {
					S.add(num);
				}
				break;
			case "remove":
				S.remove(num);
				break;
			case "check":
				if (S.contains(num)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "toggle":
				if (!S.remove(num)) {
					S.add(num);
				}
			default:
				break;
		}
	}

	private static void operate(String s) {
		switch (s) {
			case "all":
				S = new LinkedList<>();
				for (int i = 1; i <= 20; i++) {
					S.add(String.valueOf(i));
				}
				break;
			case "empty":
				S = new LinkedList<>();
				break;
			default:
				break;
		}
	}
}
