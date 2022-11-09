package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1><a href="https://www.acmicpc.net/problem/11399">ATM</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/11/07</h2>
 * <br><h2>comment :</h2>
 */
public class BJ11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split("\\s");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}

		Arrays.sort(arr);
		int answer = 0;
		int sum = 0;
		for (int i : arr) {
			sum += i;
			answer += sum;
		}

		System.out.println(answer);
	}
}
// 1 2 3 4
