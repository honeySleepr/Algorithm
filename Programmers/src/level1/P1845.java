package level1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>폰켓몬</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/03</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment : 이전에 이미 나온 적이 있는 포켓몬인지 Set을 이용해 판별 </h2>
 */
public class P1845 {

    public static void main(String[] args) throws IOException {

        Solution1845 s = new Solution1845();
        s.solution(new int[] {3, 1, 2, 3});
        s.solution(new int[] {3, 3, 3, 2, 2, 4});
        s.solution(new int[] {3, 3, 3, 2, 2, 2});
    }

}

class Solution1845 {
    public int solution(int[] nums) {

        Set<Integer> set = new HashSet<>();
        final int N = nums.length / 2;

        for (int pokemon : nums) {
            set.add(pokemon);
            if (set.size() >= N) {
                break;
            }
        }
        return set.size();
    }
}
