import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>원더랜드(프림 알고리즘 사용)</h1>
 * <h3>해설 참고 : O</h3>
 * <h3>코드 참고 : O</h3>
 * <h3>날짜 : 2022/07/26</h3>
 * <h3>걸린 시간 : </h3>
 * <h2>풀이 방법 : PriorityQueue 활용</h2>
 * <h2>1. [출발점 c1, 도착점 c2, 비용 cost]가 주어졌을 때, List< List < Road >> 을 만들어 c1번째 리스트에 new Road(c2,cost)를 추가한다</h2>
 * <h2>2. 이때 문제에서는 방향 구분이 없는 도로가 주어졌기 때문에 반대 방향도 입력해줘야한다. c2 번째 리스트에 new Road(c1,cost) 도 추가한다</h2>
 * <h2>3. PriorityQueue를 생성하고, Road 클래스의 compareTo() 메서드를 오버라이딩하여 cost 기준으로 오름차순 정렬되도록 한다</h2>
 * <h2>4. 첫 출발점을 1번으로 잡는다. queue에 new Road(1,0)을 추가한다 (출발점이기 때문에 비용을 0으로 잡는다)</h2>
 * <h2>5. 지나온 길을 표시할 Array를 만들어 default 값은 0으로 둔다</h2>
 * <h2>6. queue에서 Road를 꺼내서 c1으로 가는 길을 안지났다면 지났다는 표시를 하고(arr[c1] = 1) cost를 answer에 더한다</h2>
 * <h2>7. c1에서 출발하는 길을 전부 꺼내서 queue에 담는다. 단, 이때 해당 길이 이미 지난 길이라면 담지 않는다</h2>
 * <h2>8. queue가 빌 때 까지 6,7을 반복한다</h2>
 * <br><h2>comment : 맨 처음 나오는 길을 아무 의심 없이 선택해도 되는 이유는, PriorityQueue 안에서 cost가 가장 적은 Road 부터 poll()되기 때문이다 </h2>
 */
public class P0907_Prim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int V = Integer.parseInt(split[0]);
        final int E = Integer.parseInt(split[1]);
        List<List<Road>> list = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] strings = br.readLine().split("\\s");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            int c = Integer.parseInt(strings[2]);
            list.get(a).add(new Road(b, c));
            list.get(b).add(new Road(a, c));
        }

        Queue<Road> pQueue = new PriorityQueue<>();
        int[] arr = new int[V + 1];
        int answer = 0;

        /* 1로 가는 비용은 0이다. 즉, 1을 시작점으로 잡겠다 */
        pQueue.add(new Road(1, 0));
        while (pQueue.size() > 0) {
            Road poll = pQueue.poll();

            if (arr[poll.city] == 0) {
                arr[poll.city] = 1;
                answer += poll.cost;
                for (Road road : list.get(poll.city)) {
                    /* 길이 없는 경우에만 추가한다 */
                    if (arr[road.city] == 0) {
                        pQueue.add(road);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static class Road implements Comparable<Road> {

        final int city;
        final int cost;

        public Road(int city, int cost) {
            this.city = city;
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
