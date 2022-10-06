package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * <h1>경로 찾기</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : O</h2>
 * <h2>풀이 시간 : 2h</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎︎</h2>
 * <h2>날짜 : 2022/10/04</h2>
 * <br><h2>comment : union-find는 양방향이 되기 때문에 이 문제에선 사용할 수 없다.
 * <br> 한 경로로 계속 파고 들어가는 DFS보다 최소 경로로 목적지를 찾아낼 수 있는 BFS가 더 효율적인 것 같다
 * <br>- queue를 BFS 돌릴 때마다 초기화해주지 않은 것 때문에 62%에서 자꾸 틀려서 한참 헤맸다
 * <br><br>개선 버전에서는 플로이드-와샬을 배워서 사용해봐야겠다.
 * </h2>
 */
public class BJ11403 {

	static int N;
	static Deque<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<List<Integer>> listList = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			listList.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			String[] split = br.readLine().split("\\s");
			for (int j = 1; j <= N; j++) {
				if (Integer.parseInt(split[j - 1]) == 1) {
					listList.get(i).add(j);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				boolean[] checked = new boolean[N + 1];
				queue = new ArrayDeque<>(); /* 초기화 까먹지 말자.. */
				if (checkConnectionBFS(i, j, checked, listList)) {
					sb.append(1).append(" ");
					continue;
				}
				sb.append(0).append(" ");
			}
			sb.deleteCharAt(sb.length() - 1).append("\n");
		}

		System.out.println(sb);
	}

	private static boolean checkConnectionBFS(int i, int j, boolean[] checked,
		List<List<Integer>> listList) {

		queue.add(i);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				Integer poll = queue.poll();
				for (Integer num : listList.get(poll)) {
					if (num.equals(j)) {
						return true;
					}
					if (checked[num]) {
						continue;
					}
					checked[num] = true;
					queue.add(num);
				}
			}
		}
		return false;
	}

	//	private static boolean checkConnection(int i, int j, boolean[] checked,
	//		List<List<Integer>> listList) {
	//		for (Integer node : listList.get(i)) {
	//			if (checked[node]) {
	//				continue;
	//			}
	//			if (node == j) {
	//				return true;
	//			}
	//			checked[node] = true;
	//			return checkConnection(node, j, checked, listList);
	//		}
	//		return false;
	//	}

	private static int solution() {
		return 0;
	}

	static class TestBJ11403 {

		@Test
		void test1() {
			assertThat(solution()).isEqualTo(0);
		}
	}

}
