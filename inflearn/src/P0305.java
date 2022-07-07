import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 연속된 자연수의 합
public class P0305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int sum = 0;
		int answer = 0;
		int l = 1;

		for (int r = 1; r <= N / 2 + 1; r++) {
			sum += r;
			while (sum >= N) {
				if (sum == N) {
					answer++;
				}
				sum -= l;
				l++;
			}
		}
		System.out.println(answer);
	}
}
