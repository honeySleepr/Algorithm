package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://level.goorm.io/l/challenge">합격자 찾기</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 10m</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/10/12</h2>
 * <br><h2>comment :</h2>
 */
public class P1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String[] answer = new String[t];
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] split = br.readLine().split("\\s");
			int sum = 0;
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(split[j]);
				sum += arr[j];
			}
			double avg = (double) sum / n;
			int count = 0;
			for (int g : arr) {
				if (g >= avg) {
					count++;
				}
			}
			answer[i] = count + "/" + n;
		}

		for (String s : answer) {
			System.out.println(s);
		}
	}

}
