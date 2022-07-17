import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 그래프 최단 거리(BFS)
public class P0714 {

	private static int startNode = 1;
	private static int nodes;
	private static List<ArrayList<Integer>> list = new ArrayList<>();
	private static Deque<Integer> queue = new ArrayDeque<>();
	private static int[] checkArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		nodes = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		checkArr = new int[nodes + 1];

		for (int i = 0; i < nodes + 1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < b; i++) {
			String[] split1 = br.readLine().split("\\s");
			int x = Integer.parseInt(split1[0]);
			int y = Integer.parseInt(split1[1]);
			list.get(x).add(y);
		}

		checkArr[startNode] = 1;
		queue.offer(startNode);
		int level = 1;
		while (queue.size() > 0) {
			int qSize = queue.size(); /* 이 부분 안 빼먹게 주의*/
			for (int i = 0; i < qSize; i++) {
				int n = queue.poll();
				for (Integer num : list.get(n)) {
					if (checkArr[num] == 0) {
						queue.offer(num);
						checkArr[num] = level;
					}
				}
			}
			level++;
		}
		for (int i = 2; i < nodes + 1; i++) {
			System.out.println(i + " : " + checkArr[i]);
		}
	}
}
/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

답:
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
*/
