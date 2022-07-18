import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 바둑이 승차(DFS)
public class P0802 {

	private static int[] arr;
	private static int limit;
	private static int size;
	private static int max;
	private static boolean done;

	private static void DFS(int L, int sum) {
		if (sum > limit || done) {
			return;
		}
		if (L == size) {
			max = Math.max(max, sum);
			if (max == limit) {
				done = true;
			}
			return;
		}
		DFS(L + 1, sum + arr[L + 1]);
		DFS(L + 1, sum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split1 = br.readLine().split("\\s");
		limit = Integer.parseInt(split1[0]);
		size = Integer.parseInt(split1[1]);
		arr = new int[size + 1];
		max = 0;
		for (int i = 1; i < size + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int sum = 0;

		DFS(0, sum);

		System.out.println(max);
	}
}
/*
259 5
81
58
42
33
61

답 : 242
*/
