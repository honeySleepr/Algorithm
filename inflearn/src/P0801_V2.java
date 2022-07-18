import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 합이 같은 부분집합(DFS : 아마존 인터뷰)
public class P0801_V2 {

	private static int totalSum;
	private static int size;
	private static int[] arr;
	private static boolean tf = false;

	public static void DFS(int L, int sum) {

		if (tf || sum > totalSum / 2) {
			return;
		}

		if (L == size) {
			if (sum == totalSum / 2) {
				tf = true;
			}
			return;
		}

		DFS(L + 1, sum + arr[L]);
		DFS(L + 1, sum);

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

		if (totalSum % 2 != 0) {
			System.out.println("NO");
			return;
		}
		int sum = 0;

		DFS(0, sum);
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
