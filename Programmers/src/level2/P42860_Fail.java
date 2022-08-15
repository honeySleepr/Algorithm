package level2;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>조이스틱</h1>
 * <h3>도움!! : O</h3>
 * <h3>체감 난이도 : ⭐⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/13</h3>
 * <br><h2>comment : P42860_V2 comment 참고 </h2>
 */
public class P42860_Fail {

    public static void main(String[] args) {
        SolutionP42860_Fail s = new SolutionP42860_Fail();
        System.out.println(s.solution("AAABBAAAABBAAAAAAA"));
        // System.out.println(s.solution("JEROEN")); // 56
        // System.out.println(s.solution("JAN")); // 23
        // System.out.println(s.solution("JEAAAN")); // 23
    }

}

class SolutionP42860_Fail {
    private String name;
    private int count;

    public int solution(String name) {
        this.name = name;
        Map<Integer, Boolean> map = new HashMap<>();
        /* A 부터 J 까지의 칸 수 = 'J'-'A'*/
        /* A 부터 J 까지 거꾸로 가는 칸 수 = 'Z'-'J'+1*/
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 'A') {
                map.put(i, true);
            }
        }
        count = name.length();
        int answer = DFS(0, 0, map); // 최소 좌우(<>) 이동 거리
        // System.out.println("minMoves = " + minMoves);

        for (char letter : chars) {
            answer += Math.min(letter - 'A', 'Z' - letter + 1);
        }

        return answer;
    }

    private int DFS(int L, int index, Map<Integer, Boolean> map) {

        if (index > name.length() - 1) {
            index = 0;
        } else if (index < 0) {
            index = name.length() - 1;
        }
        map.remove(index);

        if (map.isEmpty() || L > count) {
            return L;
        }
        // System.out.println("L : " + L + " index : " + index);

        count = Math.min(DFS(L + 1, index + 1, new HashMap<>(map)),
            DFS(L + 1, index - 1, new HashMap<>(map)));

        return count;
    }
}
