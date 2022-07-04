import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 결혼식
public class P0903 {

	private static void solution(List<Wedding> list) {
		int max = 1;
		Queue<Integer> queue = new LinkedList<>();
		int endTime = list.get(0).end;
		queue.add(endTime);

		for (int i = 1; i < list.size(); i++) {
			while (!queue.isEmpty() && queue.peek() <= list.get(i).start) {
				queue.remove();
			}

			if (list.get(i).start < endTime) {
				endTime = list.get(i).end;
				queue.add(endTime);
				max = Math.max(queue.size(), max);
			}

		}

		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Wedding> list = new ArrayList<>();
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			String[] split = br.readLine().split("\\s");
			int start = Integer.parseInt(split[0]);
			int end = Integer.parseInt(split[1]);
			list.add(new Wedding(start, end));
		}
		Collections.sort(list, (o1, o2) -> {

			int x1 = o1.end;
			int x2 = o2.end;
			int sComp = x1 - x2;

			if (sComp != 0) {
				return sComp;
			}

			Integer y1 = o1.start;
			Integer y2 = o2.start;
			return y1 - y2;
		});

		solution(list);

	}

	static class Wedding implements Comparable<Wedding> {

		private int start;
		private int end;

		public Wedding(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Wedding o) {
			return this.end - o.end;
		}

	}
}

/*
6
10 13
5 14
12 15
14 18
15 20
20 30
*/
