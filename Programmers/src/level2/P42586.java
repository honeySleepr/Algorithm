package level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <h1>기능개발</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/01</h2>
 * <br><h2>comment :</h2>
 */
public class P42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> answerQueue = new ArrayDeque<>();
        for (int progress : progresses) {
            queue.add(progress);
        }
        /*int day = 0;*/
        int speedsStartIndex = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            int count = 0;
            /*day++;*/
            boolean next = false;

            for (int i = 0; i < size; i++) {
                int progress = queue.poll() + speeds[speedsStartIndex + i]; // speeds 인덱스를 생각못했다
                if (i == 0 && progress >= 100) {
                    next = true;
                }
                if (progress >= 100 && next) {
                    count++;
                } else {
                    next = false;
                    queue.add(progress);
                }
            }
            if (count > 0) {
                /*System.out.println("day : " + day);*/
                answerQueue.add(count);
                speedsStartIndex += count;
            }
        }

        int size = answerQueue.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = answerQueue.poll();
        }
        return answer;
    }

    static class TestP42586 {
        private final P42586 p = new P42586();

        @Test
        void test1() {
            int[] progresses = {93, 30, 55};
            int[] speeds = {1, 30, 5};
            int[] answer = {2, 1};
            int[] solution = p.solution(progresses, speeds);
            System.out.println(Arrays.toString(solution));
            Assertions.assertArrayEquals(answer, solution);
        }

        @Test
        void test2() {
            int[] progresses = {95, 90, 99, 99, 80, 99};
            int[] speeds = {1, 1, 1, 1, 1, 1};
            int[] answer = {1, 3, 2};
            int[] solution = p.solution(progresses, speeds);
            System.out.println(Arrays.toString(solution));
            Assertions.assertArrayEquals(answer, solution);
        }

        @Test
        void test3() {
            int[] progresses = {95, 95, 95, 95, 95};
            int[] speeds = {3, 2, 5, 1, 1};
            int[] answer = {1, 2, 2};
            int[] solution = p.solution(progresses, speeds);
            System.out.println(Arrays.toString(solution));
            Assertions.assertArrayEquals(answer, solution);
        }
    }
}
