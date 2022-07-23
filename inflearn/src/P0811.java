import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>미로 최단거리 통로(BFS)</h1>
 * <h2>풀이 해설 참고 : X</h2>
 * <h2>코드 참고 : X</h2>
 */
public class P0811 {

    private static int[][] maze = new int[7][7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 7; i++) {
            String[] split = br.readLine().split("\\s");
            for (int j = 0; j < 7; j++) {
                maze[i][j] = Integer.parseInt(split[j]);
            }
        }

        Deque<Point> queue = new ArrayDeque<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int nx = 0;
        int ny = 0;
        int level = 0;
        maze[0][0] = 1;

        queue.add(new Point(0, 0));
        while (queue.size() > 0) {
            level++;
            int size = queue.size();
            /* 현재 level에서 생겨난 Point 만큼만 for문을 돌린다 */
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                for (int j = 0; j < 4; j++) {
                    nx = p.x + dx[j];
                    ny = p.y + dy[j];
                    if (canMove(nx, ny)) {
                        if (nx == 6 & ny == 6) {
                            System.out.println(level);
                            return;
                        }
                        maze[nx][ny] = 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean canMove(int nx, int ny) {
        return nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && maze[nx][ny] == 0;
    }

    static class Point {

        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
/*
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0

답 : 12
*/
