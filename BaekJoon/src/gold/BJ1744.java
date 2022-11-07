package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <h1><a href="https://www.acmicpc.net/problem/1744">수 묶기</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/11/03</h2>
 * <br><h2>comment :</h2>
 */
public class BJ1744 {

	public static final int EMPTY = -2000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> negativeList = new ArrayList<>();
		List<Integer> positiveList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num <= 0) {
				negativeList.add(num);
				continue;
			}
			positiveList.add(num);
		}

		negativeList.sort(Comparator.naturalOrder()); // -1000, -900 ... -1, 0
		positiveList.sort(Comparator.reverseOrder()); // 1000, 900, 800...3 2 1

		long sum = compute(negativeList);
		sum += compute(positiveList);

		System.out.println(sum);
	}

	private static long compute(List<Integer> list) {
		long sum = 0;
		int temp = EMPTY;
		for (Integer num : list) {
			int integer = num.intValue();
			if (temp != EMPTY) {
				if (temp == 1 || integer == 1) { // 1*3 = 3  VS  1+3 = 4
					sum += temp + integer;
				} else {
					sum += temp * integer;
				}
				temp = EMPTY;
				continue;
			}
			temp = integer;
		}

		if (temp != EMPTY) {
			sum += temp;
		}
		return sum;
	}
}
