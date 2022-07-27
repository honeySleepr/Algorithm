import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>피자 배달 거리 V2</h1>
 * <h2>해설 참고 : O</h2>
 * <h2>코드 참고 : O</h2>
 * <h2>comment : 이렇게 간단하게 풀 수 있었군.. </h2>
 */
public class P0814_Better {

    private static int n;
    private static int m;
    private static int[][] arr;
    private static int answer = Integer.MAX_VALUE;
    private static List<Point> houseList = new ArrayList<>();
    private static List<Point> pizzaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        arr = new int[n + 1][n + 1];
        houseList = new ArrayList<>();
        pizzaList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] split1 = br.readLine().split("\\s");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(split1[j - 1]);
                if (arr[i][j] == 1) {
                    houseList.add(new Point(i, j));
                }
                if (arr[i][j] == 2) {
                    pizzaList.add(new Point(i, j));
                }
            }
        }

        int[] pizzaIndexArr = new int[m];
        DFS(0, 0, pizzaIndexArr);
        System.out.println(answer);

    }

    private static void DFS(int L, int start, int[] pizzaIndexArr) {
        if (L == m) {
            /* m개의 피자집 조합이 만들어졌을 때 각 집 까지의 최소거리의 합을 구하여 answer 값과 비교 후 저장한다 */
            answer = Math.min(getDistanceSum(pizzaIndexArr), answer);
            return;
        }
        for (int i = start; i < pizzaList.size(); i++) {
            pizzaIndexArr[L] = i;
            DFS(L + 1, i + 1, pizzaIndexArr);
        }
    }

    private static int getDistanceSum(int[] pizzaIndexArr) {
        int distance;
        int minDistance;
        int sum = 0;

        for (Point house : houseList) {
            minDistance = Integer.MAX_VALUE;
            /* 모든 피자집에서 한 집 까지의 거리를 구하고 그 중 최소값을 sum에 더한다*/
            for (int i : pizzaIndexArr) {
                distance = Math.abs(house.x - pizzaList.get(i).x) + Math.abs(house.y - pizzaList.get(i).y);
                minDistance = Math.min(minDistance, distance);
            }
            sum += minDistance;
        }
        return sum;
    }

    private static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
/*
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2

*/
