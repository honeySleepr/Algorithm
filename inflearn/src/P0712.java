import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 경로 탐색(인접행렬) : 1에서 5로 갈 수 있는 방법은 몇가지인지 구하기
public class P0712 {

	private static int nodes;
	private static int startNode = 1;
	private static int finalNode = 5;
	//	private static int[][] arr;
	private static List<ArrayList<Integer>> list = new ArrayList<>();
	private static int[] checkArr;
	private static int answer;

	private static void DFS(int n) {

		for (Integer i : list.get(n)) {
			if (checkArr[i] == 0) {
				if (i == finalNode) {
					answer++;
					break;
				}
				checkArr[i] = 1; /* 이미 왔던 길로는 되돌아가지 않도록 왔던 길을 체크 */
				DFS(i);
				checkArr[i] = 0; /* 왔던 길 표시했던거 삭제!!! */
			}
		}
		/* node 수가 많아지면 행렬로 for문을 도는 방법으로는 시간 복잡도가 커지기 때문에 List로 변경
		 * 1번 리스트 : {2, 3, 4}
		 * 2번 리스트 : {1, 3, 5}
		 * ...
		 */
		//		for (int i = 1; i < nodes + 1; i++) {
		//			if (arr[n][i] == 1 && checkArr[i] == 0) {
		//				if (i == finalNode) {
		//					answer++;
		//					break;
		//				}
		//				checkArr[i] = 1; /* 이미 왔던 길로는 되돌아가지 않도록 왔던 길을 체크 */
		//				DFS(i);
		//				checkArr[i] = 0; /* 왔던 길 표시했던거 삭제!!! */
		//			}
		//		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		nodes = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		//		arr = new int[nodes + 1][nodes + 1];
		for (int i = 0; i < nodes + 1; i++) {
			list.add(new ArrayList<>());
		}
		checkArr = new int[nodes + 1];

		for (int i = 0; i < b; i++) {
			String[] split1 = br.readLine().split("\\s");
			int x = Integer.parseInt(split1[0]);
			int y = Integer.parseInt(split1[1]);
			//			arr[x][y] = 1;
			list.get(x).add(y);
		}
		checkArr[startNode] = 1;
		DFS(startNode);
		System.out.println(answer);
	}

}
/*
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

답 : 6
*/
