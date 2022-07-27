import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>최대 수입 스케쥴(PriorityQueue 응용문제)</h1>
 * <h3>해설 참고 : O</h3>
 * <h3>코드 참고 : O</h3>
 * <h3>날짜 : 2022/07/22</h3>
 * <h3>걸린 시간 : 2h</h3>
 * <h2>풀이 방법 : PriorityQueue 사용</h2>
 * <h3>comment : 한 date에 대해서 2번 이상 돌지 않아 이전 풀이보다 더 낫다</h3>
 */
public class P0904_Better {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Lecture> lectures = new ArrayList<>();
		Queue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split("\\s");
			lectures.add(new Lecture(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
		}
		int answer = 0;
		Collections.sort(lectures);
		int date = lectures.get(0).dDay;
		int index = 0;
		while (date > 0) {
			while (index < lectures.size() && lectures.get(index).dDay == date) {
				pQueue.add(lectures.get(index).pay);
				index++;
			}
			if (pQueue.size() > 0) {
				answer += pQueue.poll();
			}
			date--;
		}

		System.out.println(answer);

	}

	static class Lecture implements Comparable<Lecture> {

		private int pay;
		private int dDay;

		public Lecture(int pay, int dDay) {
			this.pay = pay;
			this.dDay = dDay;
		}

		@Override
		public String toString() {
			return pay + " " + dDay;
		}

		@Override
		public int compareTo(Lecture o) {
			if (this.dDay == o.dDay) {
				return -(this.pay - o.pay); // 내림 차순
			}
			return -(this.dDay - o.dDay); // 내림 차순
		}
	}
}

/*
6
50 2
20 1
40 2
60 3
30 3
30 1

|
v

60 3
50 2
40 2
30 3
30 1
20 1

*/
