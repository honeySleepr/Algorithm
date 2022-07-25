import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// Least Recently Used
public class P0604_Other {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split1 = br.readLine().split("\\s");
		int s = Integer.parseInt(split1[0]);
		int n = Integer.parseInt(split1[1]);
		String[] split2 = br.readLine().split("\\s");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split2[i]);
		}
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i : arr) {
			stack.remove(i);
			stack.push(i);
		}

		for (int i = 0; i < s; i++) {
			System.out.print(stack.pop() + " ");
		}
	}
}
/*
5 9
1 2 3 2 6 2 3 5 7
*/
