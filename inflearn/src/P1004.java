import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <h1>가장 높은 탑 쌓기</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <h2>풀이 방법 : Greedy + Dynamic</h2>
 * <h2>1. 면적을 기준으로 내림차순 정렬한다. 그러면 순서대로만 진행하면 면적은 신경쓰지 않고 무게만 비교하면 된다</h2>
 * <h2>2. 현재(i) 무게보다 이전(k) 무게가 큰 경우에만 높이를 구한다. 그 중 가장 큰 값에 현재 벽돌의 높이를 더한 값을 height Array에 저장한다</h2>
 * <h2>3. 2를 반복하여 구한 높이 중 가장 큰 값이 답이다</h2>
 */
public class P1004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		List<Brick> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("\\s");
			int area = Integer.parseInt(split[0]);
			int height = Integer.parseInt(split[1]);
			int weight = Integer.parseInt(split[2]);
			list.add(new Brick(area, height, weight));
		}

		Collections.sort(list, Comparator.reverseOrder()); // area 기준 내림차순 정렬
		int[] height = new int[N];
		height[0] = list.get(0).height;
		/* 첫번째 벽돌 위로 쌓을 수 있는 벽돌이 없고 첫번째 벽돌이 가장 높은 벽돌이라면, 첫 벽돌의 높이가 answer가 된다. 그래서 여기서 초기화를 시켜줘야한다 */
		int answer = list.get(0).height;

		for (int i = 1; i < N; i++) {
			int max = 0;
			int rightW = list.get(i).weight;
			for (int k = i - 1; k >= 0; k--) {
				int leftW = list.get(k).weight;
				if (leftW > rightW) {
					max = Math.max(max, height[k]);
				}
			}
			height[i] = max + list.get(i).height;
			answer = Math.max(answer, height[i]);
		}
		System.out.println(answer);
	}

	static class Brick implements Comparable<Brick> {

		private int area;
		private int height;
		private int weight;

		public Brick(int area, int height, int weight) {
			this.area = area;
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Brick o) {
			return this.area - o.area; /* area 기준 정렬 */
		}
	}

}
/*
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2

답 : 10
*/
