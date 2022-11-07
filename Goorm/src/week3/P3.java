package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1><a href="https://level.goorm.io/exam/159769/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EB%A8%BC%EB%8D%B0%EC%9D%B4-3%ED%9A%8C/quiz/3">구름이의
 * 여행</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/18</h2>
 * <br><h2>comment :</h2>
 */
public class P3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int K = Integer.parseInt(split[2]);

		List<List<Integer>> dList = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			dList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			split = br.readLine().split("\\s");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			dList.get(a).add(b);
			dList.get(b).add(a);
		}

		System.out.println(BFS(N, K, dList));
	}

	private static String BFS(int n, int k, List<List<Integer>> dList) {
		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];
		queue.add(1);
		visited[1] = true;
		int L = 0;

		while (!queue.isEmpty() && L < k) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer poll = queue.poll();
				for (Integer node : dList.get(poll)) {
					if (visited[node]) {
						continue;
					}
					if (node.equals(n)) {
						return "YES";
					}
					queue.add(node);
					visited[node] = true;
				}
			}
			L++;
		}
		return "NO";
	}

}
/*
5 5 2
1 4
4 2
4 3
1 2
3 1

*/
