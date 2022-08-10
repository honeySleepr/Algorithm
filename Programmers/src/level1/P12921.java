package level1;

/**
 * <h1>소수 찾기</h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/10</h3>
 * <br><h2>comment : 에라토스테네스의 체</h2>
 */
public class P12921 {

    public static void main(String[] args) {
        SolutionP12921 s = new SolutionP12921();
        System.out.println(s.solution(5));
    }

}

class SolutionP12921 {
    public int solution(int n) {
        boolean[] hasDivider = new boolean[n + 1];
        hasDivider[0] = true;
        hasDivider[1] = true; /* 0과 1은 소수가 아니다 */
        int answer = 0;

        for (int i = 2; i * i <= n; i++) {
            if (hasDivider[i]) {
                continue;
            }
            for (int j = i * i; j <= n; j += i) {
                hasDivider[j] = true;
            }
        }

        for (boolean b : hasDivider) {
            if (!b) {
                answer++;
            }
        }
        return answer;
    }

}
