import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최대점수 구하기(DFS)
public class P0803 {

	private static int size;
	private static int timeLimit;
	private static int[] scoreArr;
	private static int[] timeArr;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split1 = br.readLine().split("\\s");
		size = Integer.parseInt(split1[0]);
		timeLimit = Integer.parseInt(split1[1]);
		scoreArr = new int[size + 1];
		timeArr = new int[size + 1];

		for (int i = 1; i < size + 1; i++) {
			String[] split = br.readLine().split("\\s");
			scoreArr[i] = Integer.parseInt(split[0]);
			timeArr[i] = Integer.parseInt(split[1]);
		}

		DFS(0, 0, 0);

		System.out.println(answer);
	}

	private static void DFS(int L, int scoreSum, int timeSum) {
		if (timeSum > timeLimit) {
			return;
		}
		if (L == size || timeSum == timeLimit) {
			answer = Math.max(answer, scoreSum);
			return;
		}

		DFS(L + 1, scoreSum + scoreArr[L + 1], timeSum + timeArr[L + 1]);
		DFS(L + 1, scoreSum, timeSum);

	}
}
