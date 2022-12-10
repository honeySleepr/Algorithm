package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		StringBuilder sb = new StringBuilder();
		int[] arr = {1, 1, 2, 2, 2, 8};

		for (int i = 0; i < split.length; i++) {
			sb.append(arr[i] - Integer.parseInt(split[i])).append(" ");
		}

		System.out.println(sb);
	}

}
