package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>종이의 개수</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/20</h2>
 * <br><h2>comment : 같은 숫자로 채워진 3*3 짜리 사각형만 종이 1장으로 치는게 아니라, 같은 숫자로 이루어진 9*9 짜리 사각형도 종이 1장으로 계산되어야 한다
 * 이 점을 놓쳐서 반례에 걸렸다 (코드 아래에 반례 적어둠)</h2>
 */

public class BJ1780 {
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

        int lengthToNextSquare = N / 3;
        DFS(0, 0, lengthToNextSquare);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }

    private static void DFS(int x, int y, int length) {
        if (scanAll(x, y, length * 3)) {
            return;
        }
        if (length == 1 || length == 0) { /* N == 1 인 경우도 여기서 처리한다 */
            int tempMinus = 0;
            int tempZero = 0;
            int tempPlus = 0;
            int end = (int)Math.pow(3, length);
            for (int i = 0; i < end; i++) {
                for (int j = 0; j < end; j++) {
                    int value = arr[x + i][y + j];
                    if (value == -1) {
                        tempMinus++;
                    } else if (value == 0) {
                        tempZero++;
                    } else {
                        tempPlus++;
                    }
                }
            }
            if (tempMinus == 9 || tempZero == 9 || tempPlus == 9) {
                answer[0] += tempMinus / 9;
                answer[1] += tempZero / 9;
                answer[2] += tempPlus / 9;
            } else {
                answer[0] += tempMinus;
                answer[1] += tempZero;
                answer[2] += tempPlus;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                DFS(x + length * i, y + length * j, length / 3);
            }
        }
    }

    private static boolean scanAll(int x, int y, int edge) {
        int temp = arr[x][y];
        for (int i = x; i < x + edge; i++) {
            for (int j = y; j < y + edge; j++) {
                if (arr[i][j] != temp) {
                    return false;
                }
            }
        }
        if (temp == -1) {
            answer[0]++;
        } else if (temp == 0) {
            answer[1]++;
        } else {
            answer[2]++;
        }
        return true;
    }

}
/*
27
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1

답 :
0
24
1

*/
