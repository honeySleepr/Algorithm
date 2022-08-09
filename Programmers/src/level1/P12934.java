package level1;

/**
 * <h1>정수 제곱근 판별</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/09</h3>
 * <br><h2>comment :</h2>
 */
public class P12934 {

    public static void main(String[] args) {
        SolutionP12934 s = new SolutionP12934();
        System.out.println(s.solution(121));
    }

}

class SolutionP12934 {
    public long solution(long n) {
        long answer = 0;
        double sqrt = Math.sqrt(n);
        int sqrtInt = (int)sqrt;
        if (sqrt - sqrtInt != 0) {
            answer = -1;
        } else {
            answer = (long)Math.pow(sqrtInt + 1, 2);
        }

        return answer;
    }

}
