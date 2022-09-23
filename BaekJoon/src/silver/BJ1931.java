package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <h1>회의실 배정</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/23</h2>
 * <br><h2>comment : 다른 사람들이랑 똑같이 푼 것 같은데 왜이리 느리지?? </h2>
 */
public class BJ1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, (o1, o2) -> { /* 끝나는 시간을 우선적으로 정렬 */
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int currentTime = 0;
        for (int[] meeting : arr) {
            if (meeting[0] >= currentTime) {
                count++;
                currentTime = meeting[1];
            }
        }

        System.out.println(count);
    }

}
