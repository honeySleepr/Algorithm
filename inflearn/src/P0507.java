import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 교육과정 설계
public class P0507 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars1 = br.readLine().toCharArray();
		char[] chars2 = br.readLine().toCharArray();

		Queue<Character> queue = new ArrayDeque<>();
		for (char c : chars1) {
			queue.add(c);
		}
		String answer = "YES";
		for (char c : chars2) {
			if (queue.contains(c)) {
				if (queue.peek() == c) {
					queue.poll();
				} else {
					answer = "NO";
					break;
				}
			}
		}
		if (!queue.isEmpty()) {
			answer = "NO";
		}
		System.out.println(answer);
	}
}
/*
CBA
CDGB
*/
