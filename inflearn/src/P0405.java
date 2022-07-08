import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

// K번째 큰 수
public class P0405 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		String[] split1 = br.readLine().split("\\s");
		int[] arr = new int[split1.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(split1[i]);
		}

		System.out.println(solution(k, arr));
	}

	private static int solution(int k, int[] arr) {
		TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int l = j + 1; l < arr.length; l++) {
					set.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		if (set.size() < k) {
			return -1;
		}

		for (int i = 0; i < k - 1; i++) {
			set.pollFirst();
		}
		return set.first();
	}
}
/*
10 3
13 15 34 23 45 65 33 11 26 42
*/
