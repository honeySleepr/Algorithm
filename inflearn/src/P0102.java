import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>대소문자 변환</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <br><h2>comment : `Character.isLowerCase()` 를 사용하면 더 쉽게 풀 수 있다 </h2>
 */
public class P0102 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		char[] lower = string.toLowerCase().toCharArray();
		char[] upper = string.toUpperCase().toCharArray();
		char[] origin = string.toCharArray();
		char[] answer = new char[origin.length];

		/* Character.isLowerCase() */
		for (int i = 0; i < string.length(); i++) {
			if (origin[i] != lower[i]) {
				answer[i] = lower[i];
				continue;
			}
			if (origin[i] != upper[i]) {
				answer[i] = upper[i];
				continue;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : answer) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
/*
StuDY

answer : sTUdy
*/
