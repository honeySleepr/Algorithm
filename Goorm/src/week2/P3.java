package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1><a href="">출석부</a></h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : 20m</h2>
 * <h2>체감 난이도 : ⭐︎︎</h2>
 * <h2>날짜 : 2022/10/12</h2>
 * <br><h2>comment :</h2>
 */
public class P3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s");
		int N = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		List<Person> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] split1 = br.readLine().split("\\s");
			list.add(new Person(split1[0], split1[1]));
		}
		list.sort((o1, o2) -> {
			if (o1.name.equals(o2.name)) {
				double diff = Double.parseDouble(o1.grade) - Double.parseDouble(o2.grade);
				if (diff > 0) {
					return 1;
				} else if (diff == 0) {
					return 0;
				} else {
					return -1;
				}
			}
			return o1.name.compareTo(o2.name);
		});

		System.out.println(list.get(k - 1));
	}

	static class Person {

		private String name;
		private String grade;

		public Person(String name, String grade) {
			this.name = name;
			this.grade = grade;
		}

		@Override
		public String toString() {
			return name + " " + grade;
		}
	}

}
/*
5 1
goormy 109.50
oscar 100.00
henry 200.00
goorm 110.42
goorm 110.41

*/
