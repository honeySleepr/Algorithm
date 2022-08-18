package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>최대 힙</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/17</h3>
 * <br><h2>comment :</h2>
 */
public class BJ11279 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			priorityQueue.offer(input);
			if (input == 0) {
				sb.append(priorityQueue.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}
}
