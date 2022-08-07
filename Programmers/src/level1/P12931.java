package level1;

/**
 * <h1>자릿수 더하기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/06</h3>
 * <br><h2>comment :</h2>
 */
public class P12931 {

    public static void main(String[] args) {
        SolutionP12931 s = new SolutionP12931();
        System.out.println(s.solution(987));
    }

}

class SolutionP12931 {
    public int solution(int n) {

        return String.valueOf(n).chars()
            .map(Character::getNumericValue)
            .sum();
    }
}
