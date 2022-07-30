import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>회문 문자열</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <br><h2>comment :</h2>
 */
public class P0107 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toLowerCase().toCharArray();
		String answer = "YES";
		for (int i = 0; i < chars.length / 2; i++) {
			if (chars[i] != chars[(chars.length - 1) - i]) {
				answer = "NO";
				break;
			}
		}
		System.out.println(answer);
	}

}
/*
gooG

answer : YES
 */
