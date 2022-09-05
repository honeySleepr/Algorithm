package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>마인크래프트</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/05</h2>
 * <br><h2>comment : 브루트 포스라 그냥 생각한대로 막무가내로 푸니까 풀림 </h2>
 */
public class BJ18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        final int M = Integer.parseInt(split[1]);
        int b = Integer.parseInt(split[2]);
        int[][] arr = new int[N][M];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\s");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                min = Math.min(arr[i][j], min);
                max = Math.max(arr[i][j], max);
                sum += arr[i][j];
            }
        }

        int height = min;
        int neededBlocks = 0;
        int time = 0;
        int minTime = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        while (height <= max) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = height - arr[i][j];
                    if (diff > 0) {
                        neededBlocks += diff;
                        time += diff;
                    }
                    if (diff < 0) {
                        neededBlocks += diff; /* diff 음수임 주의 */
                        time += Math.abs(diff) * 2;
                    }
                }
            }

            if (b - neededBlocks >= 0) {
                if (minTime >= time) {
                    minTime = time;
                    maxHeight = Math.max(height, maxHeight);
                }
            }
            neededBlocks = 0;
            time = 0;
            height++;
        }
        System.out.println(minTime + " " + maxHeight);
    }
}
