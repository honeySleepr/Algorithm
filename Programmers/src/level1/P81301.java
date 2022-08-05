package level1;

import java.io.IOException;
import java.util.Map;

/**
 * <h1>숫자 문자열과 영단어</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/07/31</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment :</h2>
 */
public class P81301 {

    public static void main(String[] args) throws IOException {
        Solution81301 s = new Solution81301();
        s.solution("123");
        s.solution("2three45sixseven");
    }

}

class Solution81301 {
    private static final Map<String, Integer> map = Map.of(
        "zero", 0,
        "one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight", 8,
        "nine", 9
    );

    public int solution(String s) {
        StringBuilder answerSb = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        Integer num;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                answerSb.append(c);
            } else {
                tempSb.append(c);
                if ((num = map.get(tempSb.toString())) != null) {
                    answerSb.append(num);
                    tempSb.setLength(0);
                }
            }
        }
        System.out.println(answerSb);
        return Integer.parseInt(answerSb.toString());
    }
}
/*
one4seveneight
답 : 1478
*/
