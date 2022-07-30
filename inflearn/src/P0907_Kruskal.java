import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>원더랜드(크루스칼 알고리즘 사용)</h1>
 * <h3>해설 참고 : O</h3>
 * <h3>코드 참고 : O</h3>
 * <h3>날짜 : 2022/07/25</h3>
 * <h2>풀이 방법 : 정렬 + Union-Find</h2>
 * <h2>1. [출발점 c1, 도착점 c2, 비용 cost]가 주어지면 List< Road >에 new Road(c1,c2,c3)를 전부 때려넣는다</h2>
 * <h2>2. Road 클래스의 compareTo()를 오버라이딩 하여 cost를 기준으로 오름차순 정렬되게 한 뒤, 1에서 만든 list를 정렬한다</h2>
 * <h2>3. Array를 만들고 arr[1] = 1, arr[2] = 2 .. 형태로 길 개수 만큼 만든다. 각 길이 아직은 서로 이어지지 않은 서로소집함임을 표시한 것이다(1번 길은 1번집합 소속, 2번
 * 길은 2번 집합소속..)</h2>
 * <h2>3. union(), find() 메서드를 만든다. 두 메서드의 조합을 통해, union(c1,c2)가 호출되면 c1과 c2는 같은 집합에 소속하게끔 3에서 만든 Array가 수정된다(arr[c1]
 * == arr[c2])</h2>
 * <h2>4. list를 순서대로 돌려 union(c1,c2)를 호출한다. 순서대로 그냥 넣어도 되는 이유는 cost를 기준으로 오름차순 정렬했으므로 최소값이 보장되기 때문이다</h2>
 * <h2>  - 같은 c1, c2가 union(c1,c2)로 다시 호출되더라도, 이미 같은 집합에 속하게 된 c1,c2이면 union() 메서드는 아무것도 하지않는다</h2>
 * <h2>  - count를 해준 이유는, 도로의 개수가 `도시-1`개가 되면 불필요한 for문을 빠져나오기 위해서이다 (도시가 `9`개 일때 모든 도시들을 하나의 길로 이어주는 tree를 만들 경우
 * 간선(도로)의
 * 개수는 `9-1`개가 된다)</h2>
 * <h2>5. union() 안에서 새 길을 이었을때, 즉 find(c1) != find(c2) 를 만족할 때만 cost를 answer에 더해준다</h2>
 */
public class P0907_Kruskal {

    private static int[] arr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int V = Integer.parseInt(split[0]);
        final int E = Integer.parseInt(split[1]);
        List<Road> list = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            String[] strings = br.readLine().split("\\s");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            int c = Integer.parseInt(strings[2]);
            list.add(new Road(a, b, c));
        }
        /* cost 기준으로 오름차순 정렬 */
        Collections.sort(list);

        arr = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = i;
        }
        int count = 0;
        for (Road road : list) {
            if (count > V - 1) { /* 조금이라도 최적화. Tree가 완성되면 `간선 개수 = (노드 개수 - 1)`이 된다*/
                break;
            }
            count += union(road.c1, road.c2, road.cost);
        }

        System.out.println(answer);
    }

    private static int union(int c1, int c2, int cost) {
        if (find(c1) != find(c2)) {
            arr[find(c1)] = find(c2);
            answer += cost;
            return 1;
        }
        return 0;
    }

    private static int find(int i) {
        if (i == arr[i]) {
            return i;
        }
        arr[i] = find(arr[i]);
        return arr[i];
    }

    static class Road implements Comparable<Road> {

        final int c1;
        final int c2;
        final int cost;

        public Road(int c1, int c2, int cost) {
            this.c1 = c1;
            this.c2 = c2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }

}
/*
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

답 : 196
*/
