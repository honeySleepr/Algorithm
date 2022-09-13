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
 * <br><h2>comment : 일단, 구해야하는 조건을 찾는게 어려웠다. 작업 시간이 짧은것 부터 먼저 실행해야 평균 작업시간이 짧아진다는게 떠올리기 쉽지 않았다.
 * 그리고 `하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.` 라는 조건이 헷갈렸다.
 * 가령 3초에 한 작업이 끝나고 (2,20) 작업과 (3,1) 작업이 남아있을 때, (3,1)은 기존 작업 수행을 마친 순간에 들어온 요청이니까 그 순간은 작업을 수행하지
 * 않은 상태가 되어서 (2,20)을 먼저 실행해야하는 것으로 생각하였다.(심지어 힌트에도 '매 작업이 끝나는 시점마다 <u>끝나기 전에</u> 요청된 작업 리스트를 갱신해주세요.'라고 되어있다)
 * <a href="https://school.programmers.co.kr/learn/courses/14743/lessons/118893">링크</a>
 * <br> 몇시간 동안 반례들을 보며 헤매고서야 작업이 끝남과 동시에 주어지는 작업도 '먼저 들어온 요청으로 간주해도 된다'는걸 알게되었다.
 * </h2>
 */
public class P42627 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        Queue<int[]> shortTaskPriorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int sum = jobs[0][1];
        int endTime = jobs[0][0] + jobs[0][1];

        for (int i = 1; i < jobs.length; i++) {
            /* 작업 실행 중 작업이 추가된 경우 */
            if (jobs[i][0] <= endTime) {
                shortTaskPriorityQueue.add(jobs[i]);
                continue;
            }

            while (!shortTaskPriorityQueue.isEmpty() && jobs[i][0] > endTime) {
                int[] poll = shortTaskPriorityQueue.poll();
                sum += endTime - poll[0] + poll[1];
                endTime += poll[1];
            }

            if (jobs[i][0] > endTime) {
                sum += jobs[i][1];
                endTime = jobs[i][0] + jobs[i][1];
            } else {
                shortTaskPriorityQueue.add(jobs[i]);
            }
        }

        while (!shortTaskPriorityQueue.isEmpty()) {
            int[] poll = shortTaskPriorityQueue.poll();
            sum += endTime - poll[0] + poll[1];
            endTime += poll[1];
        }

        return sum / jobs.length;
    }

    static class TestP42627 {
        private final P42627 p = new P42627();

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
        void test14() { /* 이것 때문에 오래 막힘 */
            int[][] jobs = {{0, 3}, {2, 8}, {3, 7}, {11, 11}};
            int answer = 11;
            assertThat(p.solution(jobs)).isEqualTo(answer);
        }
    }
}
