import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 이분검색
public class P0608 {

	/**
	 * if (num > target) { index *= 0.5; }<br> if (num < target) { index *= 1.5; }<br> 이렇게 구현하면 [0 1 2] 에서 구하고자 하는 값이 2
	 * 이면 1*1.5 = 1, 즉 2에 닿질 못한다
	 */
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
		int l = 0;
		int r = n - 1;
		int mid = 0;
		int count = 0;
		/* 값이 존재하지 않는 경우 l > r 이 된다 */
		while (true) {
			count++;
			mid = (l + r) / 2;

			if (list.get(mid) > target) {
				r = mid - 1;
			}
			if (list.get(mid) < target) {
				l = mid + 1;
			}
			if (list.get(mid) == target) {
				break;
			}
		}
		System.out.println("count = " + count);
		System.out.println(mid + 1);
	}
}
