package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>나이순 정렬</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/08/31</h2>
 * <br><h2>comment : 속도 : 1100ms </h2>
 */
public class BJ10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            list.add(new Person(i, Integer.parseInt(split[0]), split[1]));
        }

        list.sort((o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.order - o2.order;
            }
            return o1.age - o2.age;
        });
        StringBuilder sb = new StringBuilder();
        for (Person person : list) {
            sb.append(person).append("\n");
        }
        System.out.println(sb);
    }

    static class Person {
        int order;
        int age;
        String name;

        public Person(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

}
