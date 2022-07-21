import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//  조합 구하기(채점 지원 안됨)
public class P0809 {

	private static int n;
	private static int m;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		arr = new int[m + 1];
		DFS(1, 1);
	}

	private static void DFS(int L, int start) {
		if (L > m) {
			System.out.println(arr[1] + " " + arr[2]);
			return;
		}
		for (int i = start; i < n + 1; i++) {

			arr[L] = i;
			DFS(L + 1, i + 1);
		}
	}
}
/*
입력:
4 2

답:
1 2
1 3
1 4
2 3
2 4
3 4
*/
