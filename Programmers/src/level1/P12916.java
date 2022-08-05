/**
 * <h1>문자열 내 p와 y의 개수</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/05</h3>
 * <br><h2>comment :</h2>
 */
package level1;

public class P12916 {

    public static void main(String[] args) {
        SolutionP12916 s = new SolutionP12916();
        System.out.println(s.solution("pPoooyY"));
        System.out.println(s.solution("PyY"));
    }

}

class SolutionP12916 {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'p' || c == 'P') {
                pCount++;
            }
            if (c == 'y' || c == 'Y') {
                yCount++;
            }
        }
        if (pCount != yCount) {
            answer = false;
        }

        return answer;

        /*----------Stream 연습--------------*/
        // long pCount = s.chars().filter(value -> value == 'p' || value == 'P').count();
        // long yCount = s.chars().filter(value -> value == 'y' || value == 'Y').count();
        // if (pCount == yCount) {
        //     return true;
        // }
        // return false;
    }
}
