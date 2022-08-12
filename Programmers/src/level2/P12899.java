package level2;

/**
 * <h1>124 나라의 숫자</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/12</h3>
 * <br><h2>comment : 규칙 찾을 때는 표를 그리는게 최고의 방법인 것 같다</h2>
 */
public class P12899 {

    public static void main(String[] args) {
        SolutionP12899 s = new SolutionP12899();
        System.out.println(s.solution(1));
        System.out.println(s.solution(2));
        System.out.println(s.solution(3));
        System.out.println(s.solution(4));
        System.out.println(s.solution(5));
        System.out.println(s.solution(6));
        System.out.println(s.solution(7));
        System.out.println(s.solution(8));
        System.out.println(s.solution(33)); // 414
    }
    /* 10 : 41, 11 : 42, 12 : 44, 13 : 111 14:112 15:114 16:121 */
}

class SolutionP12899 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = {4, 1, 2};
        while (n > 0) {
            sb.append(arr[n % 3]);
            n = (n - 1) / 3;
        }
        return sb.reverse().toString();
    }
}
