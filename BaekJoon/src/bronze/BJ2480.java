package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2480 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int[] arr = new int[7];
		for (String s : split) {
			arr[Integer.parseInt(s)]++;
		}

		int dice = 0;
		int bonus = 0;
		int weight = 100;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 1) {
				dice = i;
				continue;
			}
			if (arr[i] == 2) {
				dice = i;
				bonus = 1_000;
				break;
			}
			if (arr[i] == 3) {
				dice = i;
				bonus = 10_000;
				weight = 1_000;
				break;
			}
		}

		int prize = bonus + (dice * weight);
		System.out.println(prize);

	}

}
