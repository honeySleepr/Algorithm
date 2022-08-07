package level1;

/**
 * <h1>하샤드 수</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/05</h3>
 * <br><h2>comment :</h2>
 */
public class P12947 {

    public static void main(String[] args) {
        SolutionP12947 s = new SolutionP12947();
        System.out.println(s.solution(10));
        System.out.println(s.solution(12));
        System.out.println(s.solution(11));
        System.out.println(s.solution(13));
    }
}

class SolutionP12947 {
    public boolean solution(int x) {
        int sum = String.valueOf(x).chars()
            .map(Character::getNumericValue)
            .reduce(0, Integer::sum);

        if (x % sum == 0) {
            return true;
        }
        return false;
    }
}
