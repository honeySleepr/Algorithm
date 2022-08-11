package level1;

/**
 * <h1>내적</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/10</h3>
 * <br><h2>comment :</h2>
 */
public class P70128 {

    public static void main(String[] args) {
        SolutionP70128 s = new SolutionP70128();
        System.out.println(s.solution(new int[] {1, 2, 3, 4}, new int[] {-3, -1, 0, 2}));
    }

}

class SolutionP70128 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
