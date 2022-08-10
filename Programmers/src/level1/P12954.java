package level1;

import java.util.Arrays;

/**
 * <h1>x만큼 간격이 있는 n개의 숫자</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/09</h3>
 * <br><h2>comment : int 범위 유의 </h2>
 */
public class P12954 {

    public static void main(String[] args) {
        SolutionP12954 s = new SolutionP12954();
        System.out.println(Arrays.toString(s.solution(2, 5)));
    }

}

class SolutionP12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = x + (i * (long)x);
        }
        return answer;
    }
}
