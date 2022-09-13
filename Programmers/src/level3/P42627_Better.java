package level3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>디스크 컨트롤러</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : O</h2>
 * <h2>체감 난이도 : ⭐⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/13</h2>
 * <br><h2>comment : for문으로 하니까 너무 지저분해서 다른 사람의 풀이를 참고하여 while문을 이용해 다시 풀어봤다 </h2>
 */
public class P42627_Better {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); /* IntelliJ는 자꾸 comparingInt() 쓰라는데 이게 가독성도 좋고 속도도 더 빠르다 */
        Queue<int[]> pQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int i = 0;
        int sum = 0;
        int endTime = 0;
        int count = 0;

        while (count < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= endTime) {
                pQueue.add(jobs[i]);
                i++;
            }

            if (pQueue.isEmpty()) { /* 비어있다는건 endTime 이내에 들어온 요청이 없다는 것 -> endTime이 멈춰버리면 안되므로 땡겨와준다 */
                endTime = jobs[i][0];
            } else {
                int[] poll = pQueue.poll();
                sum += endTime - poll[0] + poll[1];
                endTime += poll[1];
                count++;
            }
        }

        return sum / count;
    }

    static class TestP42627 {
        private final P42627_Better p = new P42627_Better();

        @Test
        void test1() {
            int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
            int answer = 9;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test2() {
            int[][] jobs = {{0, 5}, {1, 6}, {1, 9}};
            int answer = 11;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test3() {
            int[][] jobs = {{0, 5}, {4, 6}, {1, 9}};
            int answer = 10;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test4() {
            int[][] jobs = {{0, 5}, {5, 6}, {1, 9}};
            int answer = 10;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test5() {
            int[][] jobs = {{0, 5}, {6, 6}, {1, 9}};
            int answer = 10;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test6() {
            int[][] jobs = {{0, 16}, {0, 14}, {15, 1}, {13, 13}};
            int answer = 21;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test7() {
            int[][] jobs = {{0, 5}, {2, 10}, {10000, 2}};
            int answer = 6;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test8() {
            int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43},
                {26, 1}};
            int answer = 72;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test9() {
            int[][] jobs = {{0, 3}, {4, 4}, {5, 3}, {4, 1}};
            int answer = 3;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test10() {
            int[][] jobs = {{7, 8}, {3, 5}, {8, 6}};
            int answer = 8;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test11() {
            int[][] jobs = {{0, 1}, {1, 1}, {50, 7}};
            int answer = 3;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test12() {
            int[][] jobs = {{0, 10}, {4, 10}, {15, 2}, {5, 11}};
            int answer = 15;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test13() {
            int[][] jobs = {{0, 3}, {4, 6}, {4, 9}};
            int answer = 8;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }

        @Test
        void test14() { /* 이것 때~문에 오래 막힘 */
            int[][] jobs = {{0, 3}, {2, 8}, {3, 7}, {11, 11}};
            int answer = 11;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }
    }
}
