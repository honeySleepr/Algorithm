import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 합이 같은 부분집합(DFS : 아마존 인터뷰)
public class P0801 {

	private static int totalSum;
	private static int size;
	private static int[] arr;
	private static int[] checkArr;
	private static boolean tf = false;

	public static void DFS(int L) {
		int sum = 0;

		if (L == size) {
			/* DFS 안에서 또 for문을 돌리는 것 보다 P0801_V2 풀이 방식이 나은 것 같다 */
			for (int i = 1; i < L + 1; i++) {
				if (checkArr[i] == 1) {
					sum += arr[i];
				}
				if (sum == totalSum / 2) {
					tf = true;
					return;
				}
			}
			return;
		}
		/* true가 하나라도 나왔다면 남은 재귀를 더이상 돌려볼 필요가 없다 */
		if (tf) {
			return;
		}
		checkArr[L] = 1;
		DFS(L + 1);
		checkArr[L] = 0;
		DFS(L + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split("\\s");
		arr = new int[size + 1];
		for (int i = 0; i < size; i++) {
			arr[i + 1] = Integer.parseInt(split[i]);
			totalSum += arr[i + 1];
		}
		/* 원소의 합이 서로 같은 두 부분집합이 존재한다면, 그 합은 (전체 집합의 합)/2 와 값이 같아야한다 */
		/* 그러므로 애초에 전체 합이 짝수가 아닌 경우 이를 만족하는 부분집합이 있을 수 없다 */
		if (totalSum % 2 != 0) {
			System.out.println("NO");
			return;
		}
		checkArr = new int[size + 1];

		DFS(0);
		if (tf) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}

/*
9
3 6 13 11 7 16 34 23 12
*/
// 답 : NO

/*
9
3 6 1 4 7 16 34 23 12
* */
// 답 : YES
