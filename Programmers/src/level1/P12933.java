package level1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <h1>정수 내림차순으로 배치하기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/04</h3>
 * <br><h2>comment :</h2>
 */
public class P12933 {

    public static void main(String[] args) throws IOException {
        Solution2933 s = new Solution2933();
        System.out.println(s.solution(118372L));
    }
}

class Solution2933 {
    public long solution(long n) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = String.valueOf(n).split("");

        Arrays.stream(split)
            .sorted(Comparator.reverseOrder())
            .forEach(stringBuilder::append);

        return Long.parseLong(stringBuilder.toString());
    }
}
