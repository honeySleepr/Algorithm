import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 중복 확인
public class P0605_Other {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split("\\s");
		int[] arr = new int[n];
		HashMap<Integer, Boolean> map = new HashMap<>();
		String answer = "U";

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
			if (map.put(arr[i], true) != null) {
				answer = "D";
				break;
			}
		}
		System.out.println(answer);
	}
}
/*
8
20 25 52 30 39 33 43 33
*/
