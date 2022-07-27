import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>피자 배달 거리</h1>
 * <h2>해설 참고 : X</h2>
 * <h2>코드 참고 : X</h2>
 * <h2>풀이 방법 : </h2>
 * <h2>1. 현재 피자집 수 : p, 목표 피자집 수 : m 일 때 p-m 개의 피자집을 지울 수 있는 모든 조합의 arr를 만든다</h2>
 * <h2>2. 각 arr에서 각 집을 기준으로 피자집 까지 가장 가까운 거리를 BFS로 구하여 총 sum을 구한다</h2>
 * <h2>3. 최소 sum 값이 답이 된다</h2><br>
 * <h2>comment : 푸는데 너무 오래 걸렸다..</h2>
 */
public class P0814 {

	private static int n;
	private static int m;
	private static int p; // 최초 피자집 수
	private static int remove; // 파업 시켜야 하는 피자집 수
	private static int answer = Integer.MAX_VALUE;
	private static int[] pizzaExcludeIndexArr; // 파업시켜야하는 피자집의 인덱스를 담을 행렬
	private static int[][] arr;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	private static List<Point> pizzaList = new ArrayList<>();
	private static List<Point> houseList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			String[] split1 = br.readLine().split("\\s");
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(split1[j - 1]);
				if (arr[i][j] == 1) {
					houseList.add(new Point(i, j));
				}
				if (arr[i][j] == 2) {
					pizzaList.add(new Point(i, j));
				}
			}
		}

		p = pizzaList.size(); // 최초 피자집 수
		remove = p - m;
		pizzaExcludeIndexArr = new int[remove];
		DFS1(0, 0);

		System.out.println(answer);

	}

	/* 어느 피자집 지울 지 결정 하는 DFS */
	private static void DFS1(int L, int start) {
		if (L == remove) {
			answer = Math.min(getAllDistance(pizzaExcludeIndexArr), answer);
			return;
		}
		for (int i = start; i < p; i++) {
			pizzaExcludeIndexArr[L] = i;
			DFS1(L + 1, i + 1);
		}
	}

	private static int getAllDistance(int[] pizzaExcludeIndexArr) {
		int sum = 0;
		/* 피자집 p-m개 지움 */
		for (int i : pizzaExcludeIndexArr) {
			Point point = pizzaList.get(i);
			arr[point.x][point.y] = 0;
		}

		for (Point house : houseList) {
			int[][] checkArr = new int[n + 1][n + 1];
			checkArr[house.x][house.y] = -1;
			Deque<Point> queue = new ArrayDeque<>();
			queue.add(new Point(house.x, house.y));
			sum += BFS(queue, checkArr);
		}

		/* 피자집 원상복귀 */
		for (int i : pizzaExcludeIndexArr) {
			Point point = pizzaList.get(i);
			arr[point.x][point.y] = 2;
		}

		return sum;
	}

	/* 각 집에서 가장 가까운 피자집 까지의 거리를 구한다*/
	private static int BFS(Deque<Point> queue, int[][] checkArr) {
		int size;
		int distance = -1;
		while ((size = queue.size()) > 0) {
			distance++;
			for (int i = 0; i < size; i++) {
				Point point = queue.poll();
				for (int j = 0; j < 4; j++) {
					int nx = point.x + dx[j];
					int ny = point.y + dy[j];
					if (canMove(nx, ny, checkArr)) {
						checkArr[nx][ny] = -1;
						queue.add(new Point(nx, ny));
						if (arr[nx][ny] == 2) {
							distance++;
							queue.clear();
							return distance;
						}
					}
				}
			}

		}
		return distance;
	}

	private static boolean canMove(int nx, int ny, int[][] checkArr) {
		if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && checkArr[nx][ny] != -1) {
			return true;
		}
		return false;
	}

	private static class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
/*
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2

답 : 6
*/
