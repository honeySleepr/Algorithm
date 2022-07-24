import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * <h1>토마토 (BFS 활용)</h1>
 * <h2>해설 참고 : X</h2>
 * <h2>코드 참고 : X</h2>
 */
public class P0812 {

	private static int m;
	private static int n;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		m = Integer.parseInt(split[0]);
		n = Integer.parseInt(split[1]);
		arr = new int[n + 1][m + 1];
		ArrayDeque<Point> queue = new ArrayDeque<>();
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int zeroCount = 0;

		for (int i = 1; i <= n; i++) {
			String[] split1 = br.readLine().split("\\s");
			for (int j = 1; j <= split1.length; j++) {
				arr[i][j] = Integer.parseInt(split1[j - 1]);
				if (arr[i][j] == 1) {
					queue.add(new Point(i, j));
				}
				if (arr[i][j] == 0) {
					zeroCount++;
				}
			}
		}
		int size;
		int nx;
		int ny;
		int level = -1;
		/* BFS */
		while ((size = queue.size()) > 0) {
			/* level = 0 부터 시작. 움직인 칸(=queue에 새로 들어온 Point)이 있어야 level++ 한다 */
			level++;
			for (int i = 0; i < size; i++) {
				Point point = queue.poll();
				/* 4 방향 확인*/
				for (int j = 0; j < 4; j++) {
					nx = point.x + dx[j];
					ny = point.y + dy[j];
					if (canMove(nx, ny)) {
						arr[nx][ny] = 1;
						queue.add(new Point(nx, ny));
						zeroCount--;
					}
				}
			}
		}
		if (zeroCount != 0) {
			System.out.println(-1);
		} else {
			System.out.println(level);
		}
	}

	private static boolean canMove(int nx, int ny) {
		if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && arr[nx][ny] == 0) {
			return true;
		}
		return false;
	}

	static class Point {

		private final int x;
		private final int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
/*
6 4
0 0 -1 0 -1 0
0 0 1 0 -1 -1
0 0 -1 0 0 0
0 0 0 0 -1 1

답 : 4
*/
