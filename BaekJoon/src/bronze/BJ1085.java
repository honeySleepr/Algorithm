package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>직사각형에서 탈출</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/30</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment :</h2>
 */
public class BJ1085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int[] arr = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		int minW = Math.min(arr[0], arr[2] - arr[0]);
		int minH = Math.min(arr[1], arr[3] - arr[1]);
		System.out.println(Math.min(minW, minH));

	}
}
/*
6 2 10 3
답 : 1

1 1 5 5
답 : 1

653 375 1000 1000
답 : 347

161 181 762 375
답 : 161
*/
