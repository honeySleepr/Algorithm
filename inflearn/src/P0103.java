import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>문장 속 단어</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment :</h2>
 */
public class P0103 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int maxLength = 0;
		String answer = "";

		for (String s : split) {
			if (s.length() > maxLength) {
				maxLength = s.length();
				answer = s;
			}
		}
		System.out.println(answer);
	}
}
/*
it is time to study

answer : study
*/
