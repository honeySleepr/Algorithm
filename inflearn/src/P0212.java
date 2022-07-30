import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>멘토링</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 * <h2>풀이 방법 : 3중 for문</h2>
 */
public class P0212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		final int N = Integer.parseInt(split[0]);
		final int M = Integer.parseInt(split[1]);

		int[][] arr = new int[M + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			String[] strings = br.readLine().split("\\s");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(strings[j - 1]);
			}
		}
		int answer = 0;
		for (int s = 1; s < N; s++) { /* 꼴등은 확인 안함 */
			int student = arr[1][s];
			int[] checkArr = new int[N + 1];
			for (int i = 1; i <= M; i++) {
				boolean found = false;
				for (int j = 1; j <= N; j++) {
					if (found) { /* 멘토 후보 학생을 찾은 경우에만 그 뒤의 학생들을 카운트 */
						checkArr[arr[i][j]]++;
					}
					if (arr[i][j] == student) { /* 멘토 후보 학생 찾기 */
						found = true;
					}
				}
			}
			for (int i : checkArr) {
				if (i == M) { /* 모든 시험에서 점수가 앞서는 경우 */
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
