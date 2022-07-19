import java.io.IOException;

// 중복 순열 (채점 지원 X)
public class P0804 {

	private static int n = 3;
	private static int m = 2;
	private static int answer;

	public static void main(String[] args) throws IOException {
		int[] arr = new int[n + 1];

		DFS(1, arr);
	}

	private static void DFS(int L, int[] arr) {
		if (L > m) {
			System.out.println(arr[1] + " " + arr[2]);
			return;
		}
		for (int i = 1; i < n + 1; i++) {
			arr[L] = i;
			DFS(L + 1, arr);
		}
	}

}
