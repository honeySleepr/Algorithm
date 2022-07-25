import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * <h1>섬나라 아일랜드</h1>
 * <h2>해설 참고 : O</h2>
 * <h2>코드 참고 : X</h2>
 */
public class P0813 {

    private static int n;
    private static int[][] arr;
    private static int answer;
    private static ArrayDeque<Point> queue = new ArrayDeque<>();
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split("\\s");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(split[j - 1]);
                if (arr[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }
        while (queue.size() > 0) {
            Point point = queue.poll();
            /* queue에서 꺼냈는데 더이상 1이 아니면 지운거니까 패스*/
            if (arr[point.x][point.y] == 1) {
                arr[point.x][point.y] = 0;
                DFS(point.x, point.y);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isIsland(nx, ny)) {
                /* 확인 된 섬 지우기 */
                arr[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    private static boolean isIsland(int nx, int ny) {
        if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && arr[nx][ny] == 1) {
            return true;
        }
        return false;
    }

    private static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
/*
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

답 : 5
*/
