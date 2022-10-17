package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1><a href="https://www.acmicpc.net/problem/11659">구간 합 구하기 4</a></h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>풀이 시간 : -</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/10/10</h2>
 * <br><h2>comment : 누적합을 이용하지 않으면 시간초과가 난다. 1차원 행렬에서 누적합을 활용하는 방법을 배웠다</h2>
 */
public class BJ11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split0 = br.readLine().split("\\s");
        final int N = Integer.parseInt(split0[0]);
        final int M = Integer.parseInt(split0[1]);
        int[] arr = new int[N + 1];

        String[] split = br.readLine().split("\\s");
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(split[i - 1]); /* 누적합(Prefix Sum) */
        }

        int[] answer = new int[M];
        for (int i = 0; i < M; i++) {
            String[] split1 = br.readLine().split("\\s");
            int a = Integer.parseInt(split1[0]);
            int b = Integer.parseInt(split1[1]);
            answer[i] = arr[b] - arr[a - 1];
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }

}
