package level1;

/**
 * <h1>3진법 뒤집기</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/11</h3>
 * <br><h2>comment :</h2>
 */
public class P68935 {

    public static void main(String[] args) {
        SolutionP68935 s = new SolutionP68935();
        System.out.println(s.solution(45));
    }

}

class SolutionP68935 {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        return Integer.parseInt(sb.toString(), 3);
    }
}
