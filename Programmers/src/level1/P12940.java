package level1;

import java.util.Arrays;

/**
 * <h1>최대공약수와 최소공배수</h1>
 * <h3>도움!! : O</h3>
 * <h3>날짜 : 2022/08/05</h3>
 * <br><h2>comment : 유클리드 호제법을 배웠다!! </h2>
 */
public class P12940 {

    public static void main(String[] args) {
        SolutionP12940 s = new SolutionP12940();
        System.out.println(Arrays.toString(s.solution(3, 12)));
        System.out.println(Arrays.toString(s.solution(1, 10)));
    }

}

class SolutionP12940 {
    public int[] solution(int n, int m) {
        int a = n;
        int b = m;
        int r = 0;

        /* 유클리드 호제법 */
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return new int[] {a, n * m / a};

        /*------재귀로도 가능------*/
        // int gcd = GCD(n, m);
        // return new int[] {gcd, n * m / gcd};
    }
    /* gcd : Greatest Common Divider */
    // private int GCD(int a, int b) {
    //     if (b == 0) {
    //         return a;
    //     }
    //     return GCD(b, a % b);
    // }
}
