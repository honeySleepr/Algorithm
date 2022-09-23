package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>종이의 개수</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/20</h2>
 * <br><h2>comment :</h2>
 */
public class BJ1780_Better {
    private static int[][] arr;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        answer = new int[3];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        DFS(0, 0, N);

        for (int count : answer) {
            System.out.println(count);
        }
    }

    private static void DFS(int x, int y, int length) {
        if (hasSameNumber(x, y, length)) {
            answer[arr[x][y] + 1]++;        /* -1 : answer[0], 0 : answer[1], 1 : answer[2] */
            return;
        }

        int dividedLength = length / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                DFS(x + (dividedLength * i), y + (dividedLength * j), dividedLength);
            }
        }
    }

    private static boolean hasSameNumber(int x, int y, int length) {

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != arr[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
