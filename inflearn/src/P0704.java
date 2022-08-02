import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 재귀(메모이제이션; memoization)
public class P0704 {

	private static int[] arr;
	private static long count;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		arr = new int[num + 1];
		/* for문으로 풀기 - 성능상으론 훨씬 유리하다*/
		arr[1] = 1;
		arr[2] = 1;
		for (int i = 1; i < num + 1; i++) {
			if (arr[i] != 0) {
				sb.append(arr[i]).append("\n");
				continue;
			}
			arr[i] = arr[i - 2] + arr[i - 1];
			sb.append(arr[i]).append("\n");
		}

		System.out.println(sb);
		sb.setLength(0);

		/* 재귀로 풀기 */
		arr = new int[num + 1];
		DFS(num);
		System.out.println("count : " + count);
		for (int i = 1; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);

	}

	private static int DFS(int num) {
		count++;
		/* 이미 구해놓은 값들은 또 DFS를 돌리지 않고 배열에서 바로 꺼냄으로써 연산 시간을 대폭 단축시킨다 */
		/* num = 45 일때 아래 if 문이 없으면 count = 2269806339, 있으면 87 이 된다*/
		if (arr[num] != 0) {
			return arr[num];
		}

		if (num == 1 || num == 2) {
			return arr[num] = 1;
		}
		return arr[num] = DFS(num - 2) + DFS(num - 1);
	}
}
/*
1 1 2 3 5 8 13 21
*/
