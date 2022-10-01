package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>사탕 게임</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/29</h2>
 * <br><h2>comment : 빡 구현</h2>
 */
public class BJ3085 {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static char[][] arr;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = chars[j];
            }
        }

        int answer = findMaxCount();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    if (isValidCoord(i + dx[k], j + dy[k])) {
                        change(i, j, i + dx[k], j + dy[k]);
                        answer = Math.max(answer, findMaxCount());
                        change(i, j, i + dx[k], j + dy[k]);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void change(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    private static int findMaxCount() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int countH = 0;
            int countV = 0;
            char tempH = ' ';
            char tempV = ' ';
            for (int j = 0; j < N; j++) {
                /*----------세로줄 체크----------*/
                if (tempV != arr[j][i]) {
                    countV = 0;
                    tempV = arr[j][i];
                }
                countV++;

                /*----------가로줄 체크----------*/
                if (tempH != arr[i][j]) {
                    countH = 0;
                    tempH = arr[i][j];
                }
                countH++;

                /* 5*5 행렬에서 4번째 항까지 일치해서 count가 4였더라도, 마지막 하나가 다를 경우 count=1이 최종 값이 된다 */
                /* 그러므로 for(int j..)문이 끝나고 나서야 max를 집계해선 안되고, for문 안에서도 계속 max를 체크 해야한다. */
                if (max < countV || max < countH) {
                    max = Math.max(Math.max(countV, countH), max);
                }
            }
        }
        return max;
    }

    private static boolean isValidCoord(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) { /* && 조건들 보다는 || 조건으로 if문을 만들어야 속도가 빠를 것 같다 */
            return false;
        }
        return true;
    }

}
/*
5
Y C P Z Y
C Y Z Z P
C C P P P
Y C Y Z C
C P P Z Z
*/
