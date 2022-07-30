import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>단어 뒤집기</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment : StringBuilder(st).reverse() 도 있구나 </h2>
 */
public class P0104 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			char[] chars = br.readLine().toCharArray();
			/* StringBuilder(st).reverse()를 사용하면 더 쉽게 구현 가능 */
			for (int j = chars.length - 1; j >= 0; j--) {
				sb.append(chars[j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}
}
/*
3
good
Time
Big

answer :
doog
emiT
giB
*/
