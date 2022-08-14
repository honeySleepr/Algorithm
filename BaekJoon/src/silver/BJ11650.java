package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>좌표 정렬하기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/14</h3>
 * <br><h2>comment :</h2>
 */
public class BJ11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\s");
            list.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }

        list.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x; /* 여기를 o1.x - o2.y 로 잘못 썼더니 자꾸 `런타임 에러 (IllegalArgument)`가 났다.
            답이 틀린거면 그냥 틀린거지 왜 런타임에러지..? */
        });

        StringBuilder sb = new StringBuilder();
        for (Point point : list) {
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }
        System.out.println(sb);
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
