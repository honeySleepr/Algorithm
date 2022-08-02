// 부분집합 구하기(DFS)
public class P0706 {

	private static int[] arr;
	private static int n = 3;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		arr = new int[n + 1];

		DFS(1);
		System.out.println(sb);
	}

	private static void DFS(int L) {
		if (L > n) {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == 1) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
			return;
		}

		arr[L] = 1;
		DFS(L + 1);
		arr[L] = 0;
		DFS(L + 1);
	}
}
