import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>중복문자제거</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <br><h2>다른 풀이 : if(string.indexOf(string.charAt(i)) == i)) </h2>
 */
public class P0106 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Map<Character, Boolean> map = new HashMap<>();
		for (char c : chars) {
			/* */
			if (!map.containsKey(c)) {
				map.put(c, true);
				sb.append(c);
			}
		}
		System.out.println(sb);
	}
}
/*
ksekkset

answer : kset
 */
