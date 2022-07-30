import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1>친구인가? (Disjoint-Set : Union&Find)</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/25</h3>
 * <h3>걸린 시간 : 1h</h3>
 * <h2>풀이 방법 : List< queue1, queue2, queue3..> 활용</h2>
 * <br><h2>comment : 양방향 매핑을 해줘야한다! (2 5 == 5 2)</h2>
 * <h2>comment2 : 강의에서는 Union&Find를 사용해서 풀었는데, 아직 이해를 못해서 이 방법은 일단 패스 </h2>
 */
public class P0906 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        List<Deque<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayDeque<>());
        }

        for (int i = 0; i < m; i++) {
            String[] split1 = br.readLine().split("\\s");
            /* 1 -> 2 가 친구면 2 -> 1 도 친구다 */
            int friend1 = Integer.parseInt(split1[0]);
            int friend2 = Integer.parseInt(split1[1]);
            list.get(friend1).add(friend2);
            list.get(friend2).add(friend1);
        }
		/*
		list.get(1) : {2, 5}
		list.get(2) : {3, 1}
		list.get(3) : {4, 2}
		...
		*/
        String[] split2 = br.readLine().split("\\s");
        int start = Integer.parseInt(split2[0]);
        int end = Integer.parseInt(split2[1]);
        String answer = "NO";
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (queue.size() > 0) {
            Integer p = queue.poll();
            Deque<Integer> q = list.get(p);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                if (num == end) {
                    answer = "YES";
                    break;
                }
                queue.add(num);
            }
        }
        System.out.println(answer);
    }

}
/*
9 7
1 2
2 3
3 4
1 5
6 7
7 8
8 9
3 8

(마지막 라인이 질문 : 3과 8은 친구인가?)
답 : NO
*/
