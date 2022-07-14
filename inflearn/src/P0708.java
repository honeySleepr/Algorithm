import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

// 송아지 찾기1(BFS: Breadth-First Search; 넓이 우선 탐색)
public class P0708 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int s = Integer.parseInt(split[0]);
		int e = Integer.parseInt(split[1]);

		Deque<Integer> queue = new ArrayDeque<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		queue.offer(s);
		map.put(s, true);
		int level = 1;
		while (queue.size() != 0) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Integer num = queue.poll();
				if (map.put(num + 1, true) == null) {
					queue.offer(num + 1);
				}
				if (map.put(num - 1, true) == null) {
					queue.offer(num - 1);
				}
				if (map.put(num + 5, true) == null) {
					queue.offer(num + 5);
				}
			}
			if (map.containsKey(e)) {
				System.out.println(level);
				break;
			}
			level++;

		}
	}
}
