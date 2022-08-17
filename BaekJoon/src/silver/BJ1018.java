package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>체스판 다시 칠하기</h1>
 * <h3>도움!! : O</h3>
 * <h3>체감 난이도 : ⭐⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/17</h3>
 * <br><h2>comment :</h2>
 */
public class BJ1018 {
    private static final int ROW = 8;
    private static final int COLUMN = 8;
    private static boolean[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        final int M = Integer.parseInt(split[1]);
        arr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = (chars[j] == 'W'); // W -> true, B -> false
            }
        }
        boolean tf = false;

        int min = Integer.MAX_VALUE;
        /* (0,0)-(0,1) / (0,1)-(0,2) / (1,0)-(1,1) / (1,1)-(1,2) */
        for (int rowStartIndex = 0; rowStartIndex < N - ROW + 1; rowStartIndex++) {
            for (int columnStartIndex = 0; columnStartIndex < M - COLUMN + 1; columnStartIndex++) {
                int count = getCount(rowStartIndex, columnStartIndex);
                min = Math.min(count, min);
            }
        }
        System.out.println(min);
    }

    /**
     * <h2> 색깔을 바꿔야 하는 최소 횟수를 구한다</h2>
     */
    private static int getCount(int rowStartIndex, int columnStartIndex) {
        boolean tf = false;
        int count = 0;
        tf = arr[rowStartIndex][columnStartIndex];
        for (int i = rowStartIndex; i < ROW + rowStartIndex; i++) {
            for (int j = columnStartIndex; j < COLUMN + columnStartIndex; j++) {
                if (arr[i][j] != tf) {
                    count++;
                }
                tf = !tf; /* 흑 <-> 백 전환*/
            }
            tf = !tf;
        }
        /* 첫 칸의 색깔을 기준으로 잡았을 때와 첫 칸과 반대되는 색을 기준으로 잡았을 때 바꿔야하는 횟수를 비교한다 */
        /* `전체개수 - count`가 맞는지 머리속으로 잘 안 그려지지만 어쨌든 맞다 */
        return Math.min(count, ROW * COLUMN - count);
    }

}
/*
8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
*/
