import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>최대 수입 스케쥴(PriorityQueue 응용문제)</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/22</h3>
 * <h3>걸린 시간 : </h3>
 * <h2>풀이 방법 : HashMap 사용 </h2>
 * <h2>1. 강연료를 기준으로 내림차순 정렬하고, 강연료가 같은 경우 dDay를 내림차순 정렬한다</h2>
 * <h2>2. 큰 강연료부터 돌면서 map<dDay, 강연료>가 비어있는지 확인하고 값을 넣고, answer에 더해준다 </h2>
 * <h2>3. 비어있지 않으면 `dDay--`하면서 비어있는 칸을 찾아 넣는다 </h2>
 * <br><h2>comment : 최대 dDay가 5일 경우 while문이 각 for문마다 54321,4321,321,21.. 형태로 돌아야해서 비효율적이다</h2>
 */
public class P0904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Lecture> lectures = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split("\\s");
			lectures.add(new Lecture(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
		}
		int answer = 0;
		Collections.sort(lectures);
		for (Lecture l : lectures) {
			int date = l.dDay;
			/* 해당 날짜가 비어있으면 일정 추가 */
			while (date > 0) {
				if (!map.containsKey(date)) {
					map.put(date, l.pay);
					answer += l.pay;
					break;
				}
				date--;
			}
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
		public int compareTo(Lecture o) {
			if (this.pay == o.pay) {
				return -(this.dDay - o.dDay); // 내림 차순
			}
			return -(this.pay - o.pay); // 내림 차순
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

답 : 150
*/
