package level1;

import java.util.Arrays;

/**
 * <h1>평균 구하기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/09</h3>
 * <br><h2>comment :</h2>
 */
public class P12944 {

    public static void main(String[] args) {
        SolutionP12944 s = new SolutionP12944();
        System.out.println(s.solution(new int[] {1, 2, 3, 4}));
    }

}

class SolutionP12944 {
    public double solution(int[] arr) {
        return (double)Arrays.stream(arr).sum() / arr.length;

        /*----------.average() 도 있다 ----------*/
        // return Arrays.stream(arr).average().orElseThrow();
    }
}
