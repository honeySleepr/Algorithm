package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="">폭탄 구현하기</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 40m</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎︎</h2>
 * <h2>날짜 : 2022/10/12</h2>
 * <br><h2>comment : 누적합을 이용해 풀어보았다. 십자가 모양으로 적용되는걸 구현하는데 오래 걸렸다
 * <br> </h2>
 */
public class P4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);

		int[][] prefixArr = new int[n][n + 1];

		for (int i = 0; i < k; i++) {
			split = br.readLine().split("\\s");
			int a = Integer.parseInt(split[0]) - 1;
			int b = Integer.parseInt(split[1]) - 1;

			/* 윗 줄 */
			if (a - 1 >= 0) {
				prefixArr[a - 1][b] += 1;
				prefixArr[a - 1][b + 1] += (-1);
			}

			/* 가운데 줄 */
			if (b - 1 >= 0) {
				prefixArr[a][b - 1] += 1;
			} else {
				prefixArr[a][b] += 1;
			}

			if (b + 2 < n + 1) {
				prefixArr[a][b + 2] += (-1);
			} else {
				prefixArr[a][b + 1] += (-1);
			}

			/* 아랫 줄 */
			if (a + 1 < n) {
				prefixArr[a + 1][b] += 1;
				prefixArr[a + 1][b + 1] += (-1);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n + 1; j++) {
				prefixArr[i][j] += prefixArr[i][j - 1];
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				answer += prefixArr[i][j];
			}
		}
		System.out.println(answer);
	}

}
/*
3 2
2 2
3 3

*/

/*
누적합
0 0 0
0 X 0
0 0 0
X 위치에 폭탄이 떨어진다고 하면, [3][3+1] arr를 새로 만들어서
0 1 -1 0
1 0 0 -1
0 1 -1 0
형태로 누적합을 모은 뒤, 가로로만 누적합를 더해주면 되지 않을까?
*/
