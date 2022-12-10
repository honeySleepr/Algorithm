package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2525 {

	static private int MINUTES_IN_ONE_DAY = 1440;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int current = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
		int cookTime = Integer.parseInt(br.readLine());

		int now = (current + cookTime) % MINUTES_IN_ONE_DAY;

		StringBuilder sb = new StringBuilder();
		sb.append(now / 60).append(" ").append(now % 60);
		System.out.println(sb);
	}

}
