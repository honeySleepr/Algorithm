import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 좌표 정렬
public class P0607 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split("\\s");
			list.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
		}

		Collections.sort(list);

		list.forEach(System.out::println);
	}

	static class Point implements Comparable<Point> {

		private final int x;
		private final int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		/*
		 * return this.x-point.x 하면 오름차순
		 * return -(this.x-point.x) 하면 내림차순으로 정렬된다.
		 */
		@Override
		public int compareTo(Point point) {
			if (this.x == point.x) {
				return this.y - point.y;
			}
			return this.x - point.x;
		}

		@Override
		public String toString() {
			return String.format("%d %d", x, y);
		}
	}
}
/*
5
2 7
1 3
1 2
2 5
3 6
*/
