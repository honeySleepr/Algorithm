package level1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <h1>문자열 내림차순으로 배치하기</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/09</h3>
 * <br><h2>comment : stream.collect()를 새로 배웠다</h2>
 */
public class P12917 {

    public static void main(String[] args) {
        SolutionP12917 s = new SolutionP12917();
        System.out.println(s.solution("Zbcdefg"));
    }

}

class SolutionP12917 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split("");
        Arrays.sort(split, Comparator.reverseOrder());
        for (String st : split) {
            sb.append(st);
        }
        return sb.toString();

        /*--------Stream 버전-----------*/
        // return s.chars()
        //     .boxed()
        //     .sorted(Comparator.reverseOrder())
        //     .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        //     .toString();
    }
}
