import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 쇠막대기
// ')' 앞이 '('가 아니면 한 막대기의 오른쪽 끝 지점이다! << 이걸 빨리 캐치했어야하는데
public class P0505 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		Deque<Character> deque = new ArrayDeque<>();
		int answer = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == '(') {
				deque.push(arr[i]);
				continue;
			}

			if (arr[i] == ')') {
				/* 레이저든 막대기든 하나 끝난거니까 '(' 하나를 지워야한다 */
				deque.pop();

				if (arr[i - 1] == '(') {
					answer += deque.size();
				}
				if (arr[i - 1] == ')') {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}

/*
()(((()())(())()))(())
*/
