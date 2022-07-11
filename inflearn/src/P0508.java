import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

// 응급실
public class P0508 {

	private static int solution(int m, List<Integer> list, Queue<Person> queue) {
		int answer = 0;
		int i = 0;
		while (true) {
			Person person = queue.poll();
			if (person.priority == list.get(i)) {
				answer++;
				i++;
				if (person.index == m) {
					return answer;
				}
			} else {
				queue.add(person);
			}
		}
	}

	static class Person {

		private final int index;
		private final int priority;

		public Person(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strip1 = br.readLine().split("\\s");
		int n = Integer.parseInt(strip1[0]);
		int m = Integer.parseInt(strip1[1]);
		String[] strip2 = br.readLine().split("\\s");

		List<Integer> list = new ArrayList<>();
		Queue<Person> queue = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(strip2[i]));
			queue.add(new Person(i, Integer.parseInt(strip2[i])));
		}
		//내림차순으로 정렬 (우선순위 파악 용)
		Collections.sort(list, Comparator.reverseOrder());
		System.out.println(solution(m, list, queue));

	}
}
/*
5 2
60 50 70 80 90
*/
