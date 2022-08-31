package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>나이순 정렬</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/08/31</h2>
 * <br><h2>comment : 속도 : 872 -> 그렇게 빠르진 않네..?
 * <br> Counting Sort + StringBuilder[] 를 활용하는 발상이 너무 신기하다 <a href="https://st-lab.tistory.com/113">st-lab</a></h2>
 */
public class BJ10814_CountingSort {
    private static int AGE = 0;
    private static int NAME = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringBuilder[] sbArr = new StringBuilder[200 + 1];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            int age = Integer.parseInt(split[AGE]);
            if (sbArr[age] == null) {
                sbArr[age] = new StringBuilder();
            }
            sbArr[age].append(age).append(" ").append(split[NAME]).append("\n");
        }

        StringBuilder sbAnswer = new StringBuilder();
        for (StringBuilder sb : sbArr) {
            if (sb != null) {
                sbAnswer.append(sb);
            }
        }
        System.out.println(sbAnswer);
    }

}
