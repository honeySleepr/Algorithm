import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 후위식 연산
public class P0504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("");
		Deque<Integer> stack = new ArrayDeque<>();

		for (String s : split) {
			if (s.matches("\\d")) {
				stack.push(Integer.parseInt(s));
			} else {
				if (s.equals("+")) {
					stack.push((stack.pop() + stack.pop()));
				}
				if (s.equals("-")) {
					stack.push((-stack.pop() + stack.pop()));
				}
				if (s.equals("*")) {
					stack.push((stack.pop() * stack.pop()));
				}
				if (s.equals("/")) {
					stack.push((1 / stack.pop() * stack.pop()));
				}
			}
		}
		System.out.println(stack.pop());
	}
}
/*
3 5 2 + * 9 -
*/
