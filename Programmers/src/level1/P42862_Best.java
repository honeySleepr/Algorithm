package level1;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>체육복</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/18</h3>
 * <br><h2>comment :</h2>
 */
public class P42862_Best {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length;
        int[] arr = new int[n + 1];
        for (int i : reserve) {
            arr[i] = 1;
        }
        for (int i = 0; i < lost.length; i++) {
            if (arr[lost[i]] == 1) {
                arr[lost[i]] = 0;
                lost[i] = 0;
                answer++;
            }
        }

        for (int i : lost) {
            if (i - 1 > 0 && arr[i - 1] == 1) {
                arr[i - 1] = 0;
                answer++;
                continue;
            }
            if (i + 1 < arr.length && arr[i + 1] == 1) {
                arr[i + 1] = 0;
                answer++;
            }
        }
        return answer;
    }

    static class TestP42862_V3Best {
        private final P42862_Best p = new P42862_Best();

        @Test
        void 입력_() {
            int n = 5;
            int[] lost = {2, 4};
            int[] reserve = {1, 3, 5};
            assertThat(p.solution(n, lost, reserve)).isEqualTo(5);
        }

        @Test
        void 입력_2() {
            int n = 5;
            int[] lost = {2, 4};
            int[] reserve = {3};
            assertThat(p.solution(n, lost, reserve)).isEqualTo(4);
        }

        @Test
        void 입력_3() {
            int n = 3;
            int[] lost = {3};
            int[] reserve = {1};
            assertThat(p.solution(n, lost, reserve)).isEqualTo(2);
        }

        @Test
        void 입력_4() {
            int n = 10;
            int[] lost = {3, 4, 5, 6, 7, 8};
            int[] reserve = {2, 3, 5, 6, 9};
            assertThat(p.solution(n, lost, reserve)).isEqualTo(8);
        }

        @Test
        void 입력_5() {
            int n = 4;
            int[] lost = {2, 3};
            int[] reserve = {3, 4};
            assertThat(p.solution(n, lost, reserve)).isEqualTo(3);
        }
    }
}
