package level1;

/**
 * <h1>최소직사각형</h1>
 * <h3>도움!! : O</h3>
 * <h3>체감 난이도 : ⭐⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/09</h3>
 * <br><h2>comment : 풀이 방법을 생각해내지 못했다.
 * <br>주어진 가로, 세로와 상관없이 둘 중 더 큰 변을 가로로 잡고, 더 작은 쪽을 세로로 잡아서
 * <br> 걔 중에 최대값을 각각 구하면 필요한 지갑의 최소 크기를 구할 수 있다 </h2>
 */
public class P86491 {

    public static void main(String[] args) {
        SolutionP86491 s = new SolutionP86491();
        System.out.println(s.solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }

}

class SolutionP86491 {
    private static final int W = 0;
    private static final int H = 1;

    public int solution(int[][] sizes) {
        int max = 0;
        int secondMax = 0;
        for (int i = W; i < sizes.length; i++) {
            /* 명함의 두 변 중 더 큰 쪽. 그 중에서 최대값을 골라낸다 */
            max = Math.max(max, Math.max(sizes[i][W], sizes[i][H]));
            /* 명함의 두 변 중 작은 쪽. 그 중에서 최대값을 골라낸다 */
            secondMax = Math.max(secondMax, Math.min(sizes[i][W], sizes[i][H]));
        }
        int answer = max * secondMax;
        return answer;
    }
}
