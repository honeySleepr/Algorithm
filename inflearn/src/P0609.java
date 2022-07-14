import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 뮤직 비디오 (결정 알고리즘)
public class P0609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int n = Integer.parseInt(split[0]);
		int target = Integer.parseInt(split[1]);
		String[] split2 = br.readLine().split("\\s");
		List<Integer> list = new ArrayList<>();
		int l = Integer.parseInt(split2[n - 1]);
		int r = 0;
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(split2[i]));
			r += Integer.parseInt(split2[i]);
		}

		int mid = 0;
		int answer = 0;

		while (l <= r) {
			mid = (l + r) / 2;

			/* 여기서 '<'를 붙여야하는 부분이 헷갈렸다.
			최소 3개의 dvd로 나눠 담을 수 있도록 용량이 설정되었다면, 4개로도 나눌 수 있다. (말 그대로 '최소 3')
			하지만 3개의 dvd로 나눠지는걸 2개로 줄일 수는 없다. 그러기 위해선 용량을 늘려야한다.
			그렇기 때문에 전자는 조건을 만족하지만, 후자는 그렇지 않다.
			*/
			// mid의 최소값을 구하는거니 최소값(==target 일 때의 mid) 보다 큰 값으로 시작해서 범위를 줄여나간다
			if (minimumDivision(mid, list) <= target) {
				answer = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		System.out.println(answer);
	}

	private static int minimumDivision(int mid, List<Integer> list) {
		int count = 1;
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			if (sum > mid) {
				count++;
				sum = list.get(i);
			}
		}

		return count;
	}
}
