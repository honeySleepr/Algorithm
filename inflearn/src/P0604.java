import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Least Recently Used
public class P0604 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split1 = br.readLine().split("\\s");
		int s = Integer.parseInt(split1[0]);
		int n = Integer.parseInt(split1[1]);
		String[] split2 = br.readLine().split("\\s");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split2[i]);
		}

		int[] answer = new int[s];

		for (int i = 0; i < n; i++) {
			int point = s - 1;

			for (int j = 0; j < s; j++) {
				if (arr[i] == answer[j]) {
					point = j;
					break;
				}
			}
			for (int j = point; j > 0; j--) {
				answer[j] = answer[j - 1];
			}
			answer[0] = arr[i];
		}

		for (int i : answer) {
			System.out.print(i + " ");
		}
	}
}
/*
5 9
1 2 3 2 6 2 3 5 7
*/
