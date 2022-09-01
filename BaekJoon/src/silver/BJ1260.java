package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>DFS와 BFS</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/30</h3>
 * <br><h2>comment :</h2>
 */
public class BJ1260 {
    public static StringBuilder sb = new StringBuilder();
    public static List<PriorityQueue<Integer>> listForDFS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        int nodes = Integer.parseInt(split[0]);
        int roads = Integer.parseInt(split[1]);
        int startNode = Integer.parseInt(split[2]);
        List<PriorityQueue<Integer>> listForBFS = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) {
            listForDFS.add(new PriorityQueue<>());
            listForBFS.add(new PriorityQueue<>());
        }

        for (int i = 0; i < roads; i++) {
            String[] strings = br.readLine().split("\\s");
            int node1 = Integer.parseInt(strings[0]);
            int node2 = Integer.parseInt(strings[1]);
            /*양방향*/
            listForDFS.get(node1).add(node2);
            listForDFS.get(node2).add(node1);
            listForBFS.get(node1).add(node2);
            listForBFS.get(node2).add(node1);
        }

        boolean[] checkArr = new boolean[nodes + 1];
        checkArr[startNode] = true;
        DFS(0, startNode, checkArr);
        System.out.println(sb);
        sb.setLength(0);
        /*----------------------------------------*/
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        boolean[] checkArr2 = new boolean[nodes + 1];
        checkArr2[startNode] = true;
        while (queue.size() > 0) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");
            PriorityQueue<Integer> pQueue = listForBFS.get(poll);
            int size = pQueue.size();
            for (int i = 0; i < size; i++) { // for(integer i : pQueue)로 하니까 순서 정렬 안됨
                Integer poll2 = pQueue.poll();
                if (checkArr2[poll2]) {
                    continue;
                }
                checkArr2[poll2] = true;
                queue.add(poll2);
            }
        }
        System.out.println(sb);
    }

    private static void DFS(int L, int node, boolean[] checkArr) {
        sb.append(node).append(" ");
        PriorityQueue<Integer> pQueue = listForDFS.get(node);
        int size = pQueue.size();
        for (int i = 0; i < size; i++) {
            Integer poll = pQueue.poll();
            if (checkArr[poll]) {
                continue;
            }
            checkArr[poll] = true;
            DFS(L + 1, poll, checkArr);
        }

    }

    private static int solution() {
        return 0;
    }

    static class TestBJ1260 {
        @Test
        void test1() {
            assertThat(solution()).isEqualTo(0);
        }
    }

}
