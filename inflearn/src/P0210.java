import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>봉우리</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 */
public class P0210 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split("\\s");
            for (int k = 1; k <= N; k++) {
                arr[i][k] = Integer.parseInt(split[k - 1]);
            }
        }

        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 1; i <= N; i++) {
            for (int k = 1; k <= N; k++) {
                /* i-1, k+1, i+1, k-1 */
                int now = arr[i][k];
                answer++;
                for (int r = 0; r < 4; r++) {
                    /* 값이 같아도 봉우리 안됨! */
                    if (now <= arr[i + dx[r]][k + dy[r]]) {
                        /* 일단 answer++ 해놨다가 기준점보다 큰 값이 하나라도 나오면 -- 해준다 */
                        answer--;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
