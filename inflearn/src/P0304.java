import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P0304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split1 = br.readLine().split("\\s");
		String[] split2 = br.readLine().split("\\s");

		int n = Integer.parseInt(split1[0]);
		int targetValue = Integer.parseInt(split1[1]);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split2[i]);
		}
		int start = 0;
		int a = 0;
		int sum = 0;
		int count = 0;

		while (a < n) {
			while (sum < targetValue && a < n) {
				sum += arr[a];
				a++;
			}

			while (sum >= targetValue && start < n) {
				if (sum == targetValue) {
					count++;
				}
				sum -= arr[start];
				start++;
			}
		}

		System.out.println(count);
	}
}
/*
8 3
1 2 1 3 1 1 1 2
* */
