package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * <h1>같은 숫자는 싫어</h1>
 */
public class NoSameNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution11 s = new Solution11();
		s.solution(new int[] {1, 1, 3, 3, 0, 1, 1});
	}
}

class Solution11 {
	public int[] solution(int[] arr) {
		Deque<Integer> stack = new ArrayDeque<>();
		Stack<Integer> s = new Stack<>();
		stack.push(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (stack.peek() == arr[i]) {
				continue;
			}
			stack.push(arr[i]);
		}

		int size = stack.size();
		int[] answer = new int[size];

		for (int i = 0; i < size; i++) {
			answer[i] = stack.pollLast();
		}

		for (int i = size - 1; i >= 0; i--) {
			answer[i] = stack.pop();
		}

		Arrays.stream(answer).forEach(i -> System.out.print(i + " "));
		return answer;
	}
}
