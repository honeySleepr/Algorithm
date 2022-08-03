package level1;

import java.io.IOException;
import java.util.Arrays;

/**
 * <h1>문자열 내 마음대로 정렬하기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/03</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment :</h2>
 */
public class P12915 {

    public static void main(String[] args) throws IOException {

        Solution12915 s = new Solution12915();
        s.solution(new String[] {"abce", "abcd", "cda"}, 2);
        s.solution(new String[] {"sun", "bed", "car"}, 1);
    }
}

class Solution12915 {
    public String[] solution(String[] strings, int n) {

        return Arrays.stream(strings)
            .sorted((st1, st2) -> {
                if (st1.charAt(n) == st2.charAt(n)) {
                    return st1.compareTo(st2); /* n번째 자리가 같다면 사전순 비교 */
                }
                return st1.charAt(n) - st2.charAt(n);
            })
            .toArray(value -> new String[strings.length]);
    }
}
