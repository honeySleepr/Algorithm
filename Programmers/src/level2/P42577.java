package level2;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>전화번호 목록</h1>
 * <h3>도움!! : O</h3>
 * <h3>체감 난이도 : ⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/24</h3>
 * <br><h2>comment : String 의 naturalOrder 정렬을 이용하면 쉽게 풀 수 있는 문제였다 (아래 코드에 출력 부분 주석 해제하고 테스트 돌려보면 파악할 수 있다) </h2>
 */
public class P42577 {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        // System.out.println(Arrays.toString(phoneBook));
        for (int i = 1; i < phoneBook.length; i++) {
            if (phoneBook[i].startsWith(phoneBook[i - 1])) {
                return false;
            }
        }
        return true;
    }

    static class TestP42577 {
        private final P42577 p = new P42577();

        @Test
        void test1() {
            String[] input = {"119", "97674223", "1195524421"};
            assertThat(p.solution(input)).isEqualTo(false);
        }

        @Test
        void test2() {
            String[] input = {"123", "456", "789"};
            assertThat(p.solution(input)).isEqualTo(true);
        }

        @Test
        void test3() {
            String[] input = {"2", "10", "121", "1", "120", "1000", "30"};
            assertThat(p.solution(input)).isEqualTo(false);
        }

        @Test
        void test4() {
            String[] input = {"124332", "334145", "123", "1241", "333", "120", "1000", "30"};
            assertThat(p.solution(input)).isEqualTo(true);
        }

        @Test
        void test5() {
            String[] input = {"1000", "19", "10003"};
            assertThat(p.solution(input)).isEqualTo(false);
        }
    }

}
