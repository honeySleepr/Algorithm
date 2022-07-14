import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 마구간 정하기(결정 알고리즘)
public class P0610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int n = Integer.parseInt(split[0]);
		int target = Integer.parseInt(split[1]);
		String[] split2 = br.readLine().split("\\s");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(split2[i]));
		}
		Collections.sort(list);
		System.out.println(solution(n, target, list));
	}

	/**
	 * @param n      마구간의 수
	 * @param target 말의 수
	 * @param list   마구간 거리 좌표(오름차순, 중복 없음)
	 */
	private static int solution(int n, int target, List<Integer> list) {
		/* 구하려는 값을 기준으로 l,r 를 정한다. 여기서는 두 말 간의 거리의 최대 범위로 시작 */
		int l = 1;
		int r = list.get(n - 1);
		int mid = 0;
		int answer = 0;
		while (l <= r) {
			mid = (l + r) / 2;

			/* mid의 최대값을 구하는거니 최소값(==target 일 때의 mid) 보다 작은 mid 값으로 시작해서 범위를 줄여나간다 */
			if (horseCount(mid, list) >= target) {
				answer = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return answer;
	}

	/**
	 * @param mid 최소 말 간격. 이 값을 기준으로 최대 말 개수를 구한다
	 */
	private static int horseCount(int mid, List<Integer> list) {
		int count = 1;
		int save = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) - save >= mid) {
				count++;
				save = list.get(i);
			}
		}
		return count;
	}

}
/*
5 3
1 2 4 8 9
*/
