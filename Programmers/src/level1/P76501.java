package level1;

/**
 * <h1></h1>
 * <h3>도움!! : X</h3>
 * <h3>체감 난이도 : ⭐︎</h3>
 * <h3>날짜 : 2022/08/10</h3>
 * <br><h2>comment :</h2>
 */
public class P76501 {

    public static void main(String[] args) {
        SolutionP76501 s = new SolutionP76501();
        System.out.println(s.solution(new int[] {4, 7, 12}, new boolean[] {true, false, true}));
    }

}

class SolutionP76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
