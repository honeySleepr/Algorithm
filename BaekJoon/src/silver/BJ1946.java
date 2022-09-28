package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>신입 사원</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/23</h2>
 * <br><h2>comment : 1. Arrays.sort 때문에 정렬을 쓰지 않은 사람들과의 속도 차이가 많이 났다. (4000ms vs 800ms ㄷㄷ)
 * <br> A 성적을 기준으로 정렬 한 뒤 B 성적으로 선발 여부를 판별할거라면, 정렬을 하거나 2차원 배열을 만들 필요 없이
 * <br> A 성적을 배열의 인덱스로 두고, B 성적을 값으로 두고 푸는 방법을 쓸 수 있다는 걸 배웠다.
 * <br><br> 2. 이렇게 해도 여전히 2배 정도 느린건 StringTokenizer 때문이었다. 그런데 이 차이로 인해 시간초과 나는 문제는 없을 것 같아서, Javadocs에서도 더 추천하는 split을
 * 계속 사용해야겠다.
 * <a href="https://www.geeksforgeeks.org/difference-between-stringtokenizer-and-split-method-in-java/"> StringTokeinzer vs split</a> </h2>
 */
public class BJ1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < T; testCase++) {

            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N + 1];
            for (int i = 0; i < N; i++) {
                String[] split = br.readLine().split("\\s");
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);
                rank[a] = b;
            }

            int count = 0;
            int temp = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (rank[i] < temp) {
                    count++;
                    temp = rank[i];
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

}
/*
3 2
1 4
4 1
2 3
5 5

1 4
2 3
3 2
4 1
5 5

*/
