package level1;

/**
 * <h1>나머지가 1이 되는 수 찾기</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/10</h3>
 * <br><h2>comment :</h2>
 */
public class P87389 {

    public static void main(String[] args) {
        SolutionP87389 s = new SolutionP87389();
        System.out.println(s.solution(12));
    }

}

class SolutionP87389 {
    public int solution(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return 0;
    }
}
