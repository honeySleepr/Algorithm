import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 공주 구하기
public class P0506 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i < n + 1; i++) {
			queue.add(i);
		}

		while (queue.size() > 1) {
			for (int i = 0; i < k - 1; i++) {
				queue.add(queue.poll());
			}
			queue.poll();
		}

		System.out.println(queue.poll());
	}
}
/* 8 3 */
