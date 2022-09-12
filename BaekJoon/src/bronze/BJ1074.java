package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>Z</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎⭐︎⭐︎</h2>
 * <h2>날짜 : 2022/09/12</h2>
 * <br><h2>comment : 분할 정복 DFS를 사용하면 되겠다 생각은 했으나 어떻게 구현할지 생각해내지 못했다.
 * 그리고 시간 초과를 피하기 위해 전체를 재귀로 돌리는게 아니라, 찾으려는 좌표가 위치한 사각형만 찾아서 거기서 또 범위를 좁혀가며 재귀를 돌리는걸 새롭게 배웠다.</h2>
 */
public class BJ1074 {
    private static int r;
    private static int c;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        r = Integer.parseInt(split[1]);
        c = Integer.parseInt(split[2]);

        DFS(0, 0, (int)Math.pow(2, N));

        System.out.println(answer);
    }

    private static void DFS(int x, int y, int length) {
        if (x == r && y == c) {
            return;
        }

        int halfLength = length / 2;
        int square = findSquare(x, y, halfLength);
        /* (r,c) 좌표가 포함된 사각형을 찾아서 거기서만 다시 재귀를 돌린다 */

        if (square == 1) {
            DFS(x, y, halfLength);
        } else if (square == 2) {
            answer += (halfLength * halfLength);
            DFS(x, y + halfLength, halfLength);
        } else if (square == 3) {
            answer += 2 * (halfLength * halfLength);
            DFS(x + halfLength, y, halfLength);
        } else {
            answer += 3 * (halfLength * halfLength);
            DFS(x + halfLength, y + halfLength, halfLength);
        }

    }

    private static int findSquare(int x, int y, int halfLength) {
        if ((r >= x && r < x + halfLength) && (c >= y && c < y + halfLength)) { /* (r,c)가 1번 사각형 안에 위치한 경우 */
            return 1;
        } else if ((r >= x && r < x + halfLength) && (c >= y + halfLength)) { /* 2번 사각형*/
            return 2;
        } else if ((r >= x + halfLength) && (c >= y && c < y + halfLength)) { /* 3번 사각형*/
            return 3;
        } else {                                                              /* 4번 사각형 */
            return 4;
        }
    }

}
