import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>	미로탐색(DFS)</h1>
 * <h2>풀이 해설 참고 : X</h2>
 * <h2>코드 참고 : X</h2>
 */
public class P0810 {

    private static int[][] maze = new int[7][7]; // 미로
    private static int[][] checkArr = new int[7][7]; // 이미 지나온 길 체크
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 7; i++) {
            String[] split = br.readLine().split("\\s");
            for (int j = 0; j < 7; j++) {
                maze[i][j] = Integer.parseInt(split[j]);
            }
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int x, int y) {
        checkArr[x][y] = 1;
        if (x == 6 && y == 6) {
            answer++;
        }
        if (canMove("y", x, y - 1)) {
            DFS(x, y - 1);
        }
        if (canMove("y", x, y + 1)) {
            DFS(x, y + 1);
        }
        if (canMove("x", y, x - 1)) {
            DFS(x - 1, y);
        }
        if (canMove("x", y, x + 1)) {
            DFS(x + 1, y);
        }
        checkArr[x][y] = 0;
		/*
		강의에서는
		int[] dx = {-1, 0, 1, 0}
		int[] dy = {0, 1, 0, -1}
		두 행렬을 두고
		for(int i = 0; i < 4; i++){
		...
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx <= 6 && ny >= 0 && nx <= 6 && board[nx][ny] = 0){
				// 체크 표시 및 재귀 호출
			}
		}
		형태로 for문을 활용하여 구현하였다.
		*/
    }

    private static boolean canMove(String direction, int xOrY, int newXOrY) {
        if (direction.equals("y")) {
            if (newXOrY >= 0 && newXOrY <= 6 && checkArr[xOrY][newXOrY] == 0 && maze[xOrY][newXOrY] == 0) {
                return true;
            }
        } else {
            if (newXOrY >= 0 && newXOrY <= 6 && checkArr[newXOrY][xOrY] == 0 && maze[newXOrY][xOrY] == 0) {
                return true;
            }
        }
        return false;
    }
}
/*
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0

답 : 8
*/
