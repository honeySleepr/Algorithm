package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>유기농 배추</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/09</h2>
 * <br><h2>comment :</h2>
 */
public class BJ1012 {

    private static boolean[][] arr;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int M;
    private static int N;
    private static int totalCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int CASE = Integer.parseInt(br.readLine());

        for (int i = 0; i < CASE; i++) {
            String[] split = br.readLine().split("\\s");
            M = Integer.parseInt(split[0]); // 가로 arr[][M]
            N = Integer.parseInt(split[1]); // 세로 arr[N][]
            final int K = Integer.parseInt(split[2]);
            arr = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                String[] bugPoint = br.readLine().split("\\s");
                int y = Integer.parseInt(bugPoint[0]);
                int x = Integer.parseInt(bugPoint[1]);
                arr[x][y] = true;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!arr[j][k]) {
                        continue;
                    }
                    DFS(j, k);
                    totalCount += 1;
                }
            }
            sb.append(totalCount).append("\n");
            totalCount = 0;
        }
        System.out.println(sb);
    }

    private static void DFS(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > M - 1 || !arr[x][y]) {
            return;
        }

        arr[x][y] = false;
        for (int i = 0; i < 4; i++) {
            DFS(x + dx[i], y + dy[i]);
        }
    }
}
