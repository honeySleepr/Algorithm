package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <h1><a href="https://www.acmicpc.net/problem/14567">선수 과목</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/11/15</h2>
 * <br><h2>comment : 위상 정렬을 배웠다 </h2>
 */
public class BJ14567 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Integer>> listList = new LinkedList<>();
		int[] countArr = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			listList.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 단방향
			listList.get(a).add(b);
			countArr[b]++;
		}

		Deque<Integer> queue = new ArrayDeque<>();
		int[] answer = new int[N + 1];

		for (int i = 1; i < countArr.length; i++) {
			if (countArr[i] == 0) {
				queue.add(i);
				answer[i] = 1;
			}
		}

		/* 위상 정렬 템플릿 */
		while (!queue.isEmpty()) {
			Integer now = queue.poll();
			for (Integer next : listList.get(now)) {
				countArr[next]--;

				if (countArr[next] == 0) {
					queue.add(next);
					// [count를 0으로 만든 과목] == [직전 학기에 들었던 과목]. 그러므로 +1 해주는 것.
					answer[next] = answer[now] + 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < answer.length; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);

	}

}
/*
[1,0,0,1,0,1]

1:
2: 1
3: 1
4:
5: {2,4}
6:
*/

/*
6 4
1 2
1 3
2 5
4 5
*/
