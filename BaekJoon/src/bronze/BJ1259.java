package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>팰린드롬수(기러기토마토우영우)</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/07/30</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment :</h2>
 */
public class BJ1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = "";
		String answer = "";
		while (!(s = br.readLine()).equals("0")) {
			answer = "yes";
			for (int i = 0; i < s.length() / 2; i++) {
				if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
					answer = "no";
					break;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
