import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>숫자만 추출</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <br><h2>comment : String을 자연수로 바꿀 때 "00208" 같은것도 Integer.parseInt()에 넣어버리면 208이 된다</h2>
 */
public class P0109 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			if (Character.isDigit(c)) {
				sb.append(c);
			}
		}
		int startIndex = 0;
		/* 맨 앞에 '0'이 두 개 이상 나올 수도 있다 */
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) != '0') {
				startIndex = i;
				break;
			}
		}
		System.out.println(sb.substring(startIndex));
		System.out.println(Integer.parseInt("00230"));
	}
}
/*
g0en2T0s8eSoft

answer : 208
*/
