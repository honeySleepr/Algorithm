package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ25304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		String[] split;
		int total = 0;
		for (int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			total += Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
		}

		if (total == X) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
