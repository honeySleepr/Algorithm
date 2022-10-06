import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <h1>다익스트라 알고리즘</h1>
 * <h3>해설 참고 : O</h3>
 * <h3>코드 참고 : O</h3>
 * <h3>날짜 : 2022/07/26</h3>
 * <h2>풀이 방법 : 다익스트라 알고리즘</h2>
 * <h2>1. 방향이 있는 graph이므로 [출발점 c1 도착점 c2, 비용 cost]가 주어졌을 때 c1번째 리스트에 new Road(c2,cost)를 추가한다</h2>
 * <h2>2. 노드 수에 맞게 Array를 생성하고 Array.fill()을 사용해 Integer.MAX_VALUE로 채운다(최소값을 찾는 것이기 때문)</h2>
 * <h2>3. PriorityQueue를 생성하고, Road 클래스의 compareTo() 메서드를 오버라이딩하여 cost 기준으로 오름차순 정렬되도록 한다</h2>
 * <h2>4. queue에 시작지점 1을 넣는다 (new Road(1,0))</h2>
 * <h2>6. queue에서 Road를 꺼내서 road.city에서 출발하는 길들을 list.get(road.city)에서 전부 꺼내 for문을 돌린다</h2>
 * <h2>7. arr[도착점] > 출발지_까지의_cost + 출발지에서_도착지까지의_cost 를 만족한다는 것은, 기존 arr에 저장된 경로 보다 더 짧은 경로를 찾았다는 뜻이니까 그 새로운 값으로 Array를
 * 업데이트 하고 같은 값을 queue에도 다시 넣는다</h2>
 * <h2>  - queue에 넣었다는건 거기서 부터 출발하여 이어지는 다른 길들을 또 탐색하겠다는 것</h2>
 * <h2>8. 만약 queue에서 A로 가는 길이 poll되었고 비용이 100인데, arr[A]에 저장된 값이 이미 100보다 작다면, 해당 길로는 arr[A]의 최소값을 갱신할 수 없으므로 continue
 * 해버린다</h2>
 * <h2>9. queue가 빌 때 까지 6~8을 반복한다</h2>
 * <h2>  - PriorityQueue이기 때문에 cost가 가장 작은 road 부터 poll 된다</h2>
 * <h2>10. 최종적으로 Array에 기록된 값들이 출발점에서 해당 도시로 가기 위해 드는 최소 비용이다. 만약 그 값이 여전히 Integer.MAX_VALUE라면 그 도시로는 갈 수 없다는 뜻이
 * 된다</h2>
 */
public class P0905_Dijkstra {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        final int M = Integer.parseInt(split[1]);
        List<List<Road>> list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] strings = br.readLine().split("\\s");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            int c = Integer.parseInt(strings[2]);
            list.get(a).add(new Road(b, c));
        }

        int[] arr = new int[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);

        int startNode = 1;
        PriorityQueue<Road> queue = new PriorityQueue<>();
        queue.add(new Road(startNode, 0));
        arr[startNode] = 0;

        /* 다익스트라 알고리즘 템플릿 - 비용이 음수인 경우에는 사용할 수 없다!(대안:벨만포드)
         * 한 정점에서 다른 정점들로 갈 수 있는 최단거리를 구한다 */
        while (queue.size() > 0) {
            Road poll = queue.poll();
            int node = poll.city;
            int cost = poll.cost;

            /**
             * 이 부분 좀 헷갈리는데, 만약 큐에 (2,11), (2,13) 두개가 들어갔으면 priorityQueue니까 (2,11)이 먼저 poll 된다
             * 그게 최소 cost라면 arr에 등록된다
             * 그럼 queue에 남아 있는 (2,13)은 어차피 최소 cost가 될 수 없으므로 사전에 거르는 것
             */
            if (arr[node] < cost) {
                continue;
            }
            for (Road road : list.get(node)) {
                int newCost = cost + road.cost;
                if (arr[road.city] > newCost) {
                    arr[road.city] = newCost;
                    queue.add(new Road(road.city, newCost));
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            if (arr[i] == Integer.MAX_VALUE) {
                System.out.println("impossible");
                continue;
            }
            System.out.println(i + ":" + arr[i]);
        }
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
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5

답 :
2:11
3:4
4:9
5:14
6:impossible
*/
