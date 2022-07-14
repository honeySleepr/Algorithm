// 부분집합 구하기(DFS)
public class P0706 {

	private static int[] arr;
	private static int n;

	public static void main(String[] args) {
		n = 3;
		arr = new int[n + 1];
		DFS(1);
	}

	private static void DFS(int L) {
		if (L == n + 1) {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == 1) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			return;
		}
		arr[L] = 1;
		DFS(L + 1);
		arr[L] = 0;
		DFS(L + 1);

	}
}
