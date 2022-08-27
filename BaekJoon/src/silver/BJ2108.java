package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>통계학</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎⭐︎⭐︎</h3>
 * <h3>날짜 : 2022/08/21</h3>
 * <br><h2>comment : 미친 문제다 질문 게시판 봤는데도 반례 찾느라 너무 오래 걸린 문제.</h2>
 */
public class BJ2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int parseInt = Integer.parseInt(br.readLine());
            list.add(parseInt);
        }

        for (int i : solution(N, list)) {
            System.out.println(i);
        }

    }

    private static int[] solution(int N, List<Integer> list) {
        list.sort(Comparator.naturalOrder());
        List<Rep> repList = new ArrayList<>();

        Integer temp = null;
        int count = 1;
        int maxCount = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(temp)) {
                count++;
            }
            if (count > 1 && (!temp.equals(list.get(i)) || i == list.size() - 1)) {
                maxCount = Math.max(count, maxCount);
                repList.add(new Rep(count, temp));
                count = 1;
            }
            temp = list.get(i);
        }

        repList.sort((o1, o2) -> {
            if (o1.count == o2.count) {
                return o1.value - o2.value; /* 오름 차순 */
            }
            return -(o1.count - o2.count); /* 내림 차순*/
        });

        int maxRep = 0;
        if (repList.size() > 1) { /* 중복값이 여러개 인 경우 */
            if (repList.get(0).count == repList.get(1).count) {
                maxRep = repList.get(1).value; /* 최빈값이 여러개인 경우 두번째 작은 값 */
            } else { // 이 부분을 고려하는걸 빼먹어서 계속 틀렸다..
                maxRep = repList.get(0).value; /* 최빈 값이 하나인 경우 */
            }
        }
        if (repList.size() == 1) { /* 중복 값이 딱 하나인 경우 */
            maxRep = repList.get(0).value;
        }
        if (repList.isEmpty()) { /* 중복 값이 하나도 없는 경우*/
            maxRep = list.size() == 1 ? list.get(0) : list.get(1); /* 원본 리스트에서 두번 째 작은 값 */
        }

        long sum = list.stream().mapToLong(Integer::longValue).sum();
        int avg = (int)Math.round(sum / (double)list.size());
        int mid = list.get(list.size() / 2);
        int range = list.get(list.size() - 1) - list.get(0);
        return new int[] {avg, mid, maxRep, range};
    }

    static class Rep {
        private int count;
        private int value;

        public Rep(int count, int value) {
            this.count = count;
            this.value = value;
        }
    }

    static class TestBJ2108 {
        @Test
        void test1() {
            int N = 5;
            List<Integer> list = new ArrayList<>(List.of(1, 3, 8, -2, 2));
            int[] answer = {2, 2, 1, 10};
            assertArrayEquals(answer, solution(N, list));
        }

        @Test
        void test2() {
            int N = 1;
            List<Integer> list = new ArrayList<>(List.of(4000));
            int[] answer = {4000, 4000, 4000, 0};
            assertArrayEquals(answer, solution(N, list));
        }

        @Test
        void test3() {
            int N = 5;
            List<Integer> list = new ArrayList<>(List.of(-1, -2, -3, -1, -2));
            int[] answer = {-2, -2, -1, 2};
            assertArrayEquals(answer, solution(N, list));
        }

        @Test
        void test4() {
            int N = 3;
            List<Integer> list = new ArrayList<>(List.of(0, 0, -1));
            int[] answer = {0, 0, 0, 1};
            assertArrayEquals(answer, solution(N, list));
        }

        @Test
        void test5() {
            int N = 5;
            List<Integer> list = new ArrayList<>(List.of(1, 1, 1, 2, 2));
            int[] answer = {1, 1, 1, 1};
            assertArrayEquals(answer, solution(N, list));
        }

        @Test
        void test6() {
            int N = 9;
            List<Integer> list = new ArrayList<>(List.of(4, 0, 1, 3, 2, 1, 3, -4, -1));
            int[] answer = {1, 1, 3, 8};
            assertArrayEquals(answer, solution(N, list));
        }

        @Test
        void test7() {
            int N = 7;
            List<Integer> list = new ArrayList<>(List.of(2, 2, 5, 5, 4, 5, 5));
            int[] answer = {4, 5, 5, 3};
            assertArrayEquals(answer, solution(N, list));
        }
    }
}
