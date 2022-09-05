package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1>덩치</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : O
 * <br>6
 * <br>55 181
 * <br>54 181
 * <br>56 181
 * <br>55 179
 * <br>56 182
 * <br>54 190
 * <br>답 : 2 2 1 3 1 1</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/05</h2>
 * <br><h2>comment : Greedy..인줄 알았으나 그냥 브루트포스 문제였다. 문제를 정확히 파악하도록 하자 </h2>
 */
public class BJ7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Person[] originalOrderArr = new Person[N];
        Person[] arr = new Person[N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            int w = Integer.parseInt(split[0]);
            int h = Integer.parseInt(split[1]);
            arr[i] = new Person(w, h);
            originalOrderArr[i] = arr[i];
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.weight == o2.weight) {
                return -(o1.height - o2.height);
            }
            return -(o1.weight - o2.weight);
        }); // 몸무게 내림차순, 몸무게가 같은 경우 키로 내림차순

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j].weight > arr[i].weight && arr[j].height > arr[i].height) {
                    count++;
                }
            }
            arr[i].rank = count + 1;
            count = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (Person person : originalOrderArr) {
            sb.append(person.rank).append(" ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));

    }

    public static class Person {
        final int weight;
        final int height;
        int rank;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
/*
5
55 185
58 183
88 186
60 175
46 155
답 : 2 2 1 2 5

6
55 181
54 181
56 181
55 179
56 182
54 190
답: 2 2 1 3 1 1

*/
