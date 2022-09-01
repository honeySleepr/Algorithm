package level2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <h1>기능개발</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐︎</h2>
 * <h2>날짜 : 2022/09/01</h2>
 * <br><h2>comment : 다른 사람 풀이인데 기발하다 </h2>
 */
public class P42586_Better {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
        int[] countArr = new int[100];
        Set<Integer> set = new LinkedHashSet<>(); // 입력 순서가 유지되는 SET

        for (int i = 0; i < progresses.length; i++) {
            int leftWork = 100 - progresses[i];
            int neededDays = leftWork / speeds[i];
            if (leftWork % speeds[i] != 0) {
                neededDays++;
            }
            day = Math.max(neededDays, day);
            countArr[day]++;
            set.add(day);
        }

        int index = 0;
        int[] answer = new int[set.size()];
        for (Integer date : set) {
            answer[index] = countArr[date];
            index++;
        }

        return answer;
    }

    static class TestP42586 {
        private final P42586_Better p = new P42586_Better();

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
