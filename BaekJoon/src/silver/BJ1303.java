package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>전쟁 - 전투</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/08</h2>
 * <br><h2>comment : </h2>
 */

public class BJ1303 {
    private static int N;
    private static int M;
    private static int[] dx = {-1, 0, 1, 0}; // 위, 아래
    private static int[] dy = {0, 1, 0, -1}; // 좌, 우
    private static char[][] arr;
    private static boolean[][] checked;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        N = Integer.parseInt(split[0]); /* 얘가 가로 */
        M = Integer.parseInt(split[1]); /* 얘가 세로 */
        arr = new char[M + 1][N + 1];
        checked = new boolean[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 1; j <= N; j++) {
                arr[i][j] = chars[j - 1];
            }
        }

        int powerW = 0;
        int powerB = 0;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                count = 0;
                if (checked[i][j]) {
                    continue;
                }
                if (arr[i][j] == 'W') {
                    powerW += getPower(i, j, 'W');
                } else {
                    powerB += getPower(i, j, 'B');
                }
            }
        }

        System.out.println(powerW + " " + powerB);
    }

    private static int getPower(int i, int j, char c) {
        DFS(i, j, c);

        if (count == 1) {
            return count;
        } else {
            return count * count;
        }
    }

    private static void DFS(int i, int j, char c) {
        if (i < 1 || i > M || j < 1 || j > N || checked[i][j]) { /* 가로, 세로 바뀐거 여기도 적용해줄것;; */
            return;
        }

        if (arr[i][j] == c) {
            checked[i][j] = true;
            count++;
        } else { /* 여기 빼먹었었다. W 찾고 있는데 B 밟았으면 return 해야지 안그럼 Stackoverflow! */
            return;
        }

        for (int k = 0; k < 4; k++) {
            DFS(i + dx[k], j + dy[k], c);
        }
    }

}
