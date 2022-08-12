package level1;

import java.util.Arrays;

/**
 * <h1>예산</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/10</h3>
 * <br><h2>comment :</h2>
 */
public class P12982 {

    public static void main(String[] args) {
        SolutionP12982 s = new SolutionP12982();
        System.out.println(s.solution(new int[] {1, 3, 2, 5, 4}, 9));
        System.out.println(s.solution(new int[] {1, 3, 2, 5, 4}, 10));
    }

}

class SolutionP12982 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;

        for (int i = 0; i < d.length; i++) {
            if (d[i] > budget) {
                break;
            }
            budget -= d[i];
            count++;
        }
        return count;
    }
}
