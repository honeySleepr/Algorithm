import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 중복 확인
public class P0605 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split("\\s");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(arr);
		int save = -1;
		String answer = "U";

		for (int i : arr) {
			if (i == save) {
				answer = "D";
				break;
			} else {
				save = i;
			}
		}
		System.out.println(answer);
	}
}
/*
8
20 25 52 30 39 33 43 33
*/
