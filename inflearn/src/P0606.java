import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 장난꾸러기
public class P0606 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split("\\s");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		int[] arrClone = arr.clone();
		Arrays.sort(arrClone);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			if (arr[i] != arrClone[i]) {
				sb.append(i + 1).append(" ");
			}
		}
		System.out.println(sb);
	}
}

/*
9
120 125 152 130 135 135 143 127 160
*/
