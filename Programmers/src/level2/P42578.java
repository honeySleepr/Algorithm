package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * <h1>위장</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/25</h3>
 * <br><h2>comment : stream 멋졍 </h2>
 */
public class P42578 {
    public int solution(String[][] clothes) {

        Map<String, List<String>> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], new ArrayList<>()));
            List<String> list = map.get(clothe[1]);
            if (list.isEmpty()) {
                list.add(null); /* 해당 옷을 안 입는 경우를 위해 list 첫 칸은 null로 채운다 */
            }
            list.add(clothe[0]);
        }

        int reduce = map.values()
            .stream()
            .mapToInt(List::size)
            .reduce(1, (a, b) -> a * b);

        return reduce - 1; /* 아무 옷도 안입은 상태를 제외하기 위해 -1 */

        /*----------stream 두번으로 처리하는, 조금 더 느리지만 멋진 방법-------------*/
        // return Arrays.stream(clothes)
        //     .collect(Collectors.toMap(arr -> arr[1], string -> 1, (x, y) -> x + 1))
        //     .values()
        //     .stream()
        //     .map(num -> num + 1)
        //     .reduce(1, (x, y) -> x * y) - 1;
    }

    static class TestP42578 {
        private final P42578 p = new P42578();

        @Test
        void test1() {
            String[][] input = {{"a", "A"}, {"b", "B"}, {"c", "A"}};
            assertThat(p.solution(input)).isEqualTo(5);
        }

        @Test
        void test2() {
            String[][] input = {{"a", "A"}, {"b", "A"}, {"c", "A"}};
            assertThat(p.solution(input)).isEqualTo(3);
        }
    }
}
