package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>별 찍기 - 10</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/27</h2>
 * <br><h2>comment : 분할 정복 DFS. `종이의 개수`와 매우 비슷한 문제다 </h2>
 */
public class BJ2447 {

    private static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];

        DFS(0, 0, N);
        decryptAndPrint();
    }

    private static void decryptAndPrint() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void DFS(int x, int y, int length) {
        if (length == 1) {
            arr[x][y] = true;
            return;
        }

        int dividedLength = length / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                DFS(x + (dividedLength * i), y + (dividedLength * j), length / 3);
            }
        }
    }

}
/*
N=27(보기 편하게 공백 추가)

 ***  ***  ***     ***  ***  ***     ***  ***  ***
 * *  * *  * *     * *  * *  * *     * *  * *  * *
 ***  ***  ***     ***  ***  ***     ***  ***  ***
 ***       ***     ***       ***     ***       ***
 * *       * *     * *       * *     * *       * *
 ***       ***     ***       ***     ***       ***
 ***  ***  ***     ***  ***  ***     ***  ***  ***
 * *  * *  * *     * *  * *  * *     * *  * *  * *
 ***  ***  ***     ***  ***  ***     ***  ***  ***

 ***  ***  ***                       ***  ***  ***
 * *  * *  * *                       * *  * *  * *
 ***  ***  ***                       ***  ***  ***
 ***       ***                       ***       ***
 * *       * *                       * *       * *
 ***       ***                       ***       ***
 ***  ***  ***                       ***  ***  ***
 * *  * *  * *                       * *  * *  * *
 ***  ***  ***                       ***  ***  ***

 ***  ***  ***     ***  ***  ***     ***  ***  ***
 * *  * *  * *     * *  * *  * *     * *  * *  * *
 ***  ***  ***     ***  ***  ***     ***  ***  ***
 ***       ***     ***       ***     ***       ***
 * *       * *     * *       * *     * *       * *
 ***       ***     ***       ***     ***       ***
 ***  ***  ***     ***  ***  ***     ***  ***  ***
 * *  * *  * *     * *  * *  * *     * *  * *  * *
 ***  ***  ***     ***  ***  ***     ***  ***  ***

N=9
 ***  ***  ***
 * *  * *  * *
 ***  ***  ***
 ***       ***
 * *       * *
 ***       ***
 ***  ***  ***
 * *  * *  * *
 ***  ***  ***

N=3 ->1
***
* *
***
*/
