package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1><a href="https://level.goorm.io/exam/159769/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EB%A8%BC%EB%8D%B0%EC%9D%B4-3%ED%9A%8C/quiz/4">순환하는
 * 수로</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/18</h2>
 * <br><h2>comment : 순환 그래프 찾는 방법을 배웠다. DFS가 return 된 후에 if문들로 처리해주는 부분이 이해하기 어려웠다
 * <br> 그런데 강의 로직이랑 똑같이 푼 것 같은데 일부 테스트케이스에서 RunTimeError가 발생한다. 왜그런지 모르겠다
 * <a href="https://edu.goorm.io/qna/18277">다른 사람의 질문 글</a></h2>
 */
public class P4 {

	static Queue<Integer> cycleNodes;
	static boolean[] visited;
	static List<List<Integer>> listList;
	static int cycleStartNode = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		listList = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N + 1; i++) {
			listList.add(new ArrayList<>());
		}
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("\\s");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			listList.get(a).add(b);
			listList.get(b).add(a);
		}

		cycleNodes = new PriorityQueue<>(N);
		visited = new boolean[N + 1];

		DFS(1, -1);

		System.out.println(cycleNodes.size());
		StringBuilder sb = new StringBuilder();
		while (!cycleNodes.isEmpty()) {
			sb.append(cycleNodes.poll()).append(" ");
		}

		System.out.println(sb);
	}

	private static void DFS(int now, int prev) {

		if (visited[now]) {
			cycleStartNode = now;
			cycleNodes.add(now);
			return;
		}

		visited[now] = true;

		for (Integer next : listList.get(now)) {
			if (next.intValue() == prev) {
				continue;
			}
			DFS(next, now);

			/* 이 부분이 중요 */
			if (cycleStartNode == -2) {
				return;
			}
			if (cycleStartNode == now) {
				cycleStartNode = -2;
				return;
			}
			if (cycleStartNode > 0) {
				cycleNodes.add(now);
				return;
			}
		}

	}
}
/*
6
1 2
2 3
2 4
4 3
4 5
4 6

*/
