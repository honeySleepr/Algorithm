import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최대 길이 연속부분수열
public class P0306 {

	private static int solution(int n, int k, int[] arr) {
		int l = 0;
		int answer = 0;
		int count = 0;

		for (int r = 0; r < arr.length; r++) {

			if (arr[r] == 0) {
				count++;
			}
			while (count > k) {
				if (arr[l] == 0) {
					count--;
				}
				l++;
			}
			answer = Math.max(answer, r - l + 1);
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		String[] split2 = br.readLine().split("\\s");
		int[] arr = new int[split2.length];

		for (int i = 0; i < split2.length; i++) {
			arr[i] = Integer.parseInt(split2[i]);
		}

		int answer = solution(n, k, arr);
		System.out.println(answer);
	}
}
