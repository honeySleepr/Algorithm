package level1;

import java.util.Arrays;

/**
 * <h1>자연수 뒤집어 배열로 만들기</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/10</h3>
 * <br><h2>comment :</h2>
 */
public class P12932 {

    public static void main(String[] args) {
        SolutionP12932 s = new SolutionP12932();
        System.out.println(Arrays.toString(s.solution(12345)));
    }

}

class SolutionP12932 {
    public int[] solution(long n) {
        int length = String.valueOf(n).length();
        int[] answer = new int[length];
        long digit = 0;
        for (int i = 0; i < length; i++) {
            answer[i] = (int)(n % 10);
            n /= 10;
        }
        return answer;
    }

}
