package level2;

/**
 * <h1>피로도</h1>
 * <h3>도움!! : O</h3>
 * <h3>날짜 : 2022/08/08</h3>
 * <br><h2>comment : DFS를 이용한 완전 탐색</h2>
 */
public class P87946 {

    public static void main(String[] args) {
        SolutionP87946 s = new SolutionP87946();
        System.out.println(s.solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
    }

}

class SolutionP87946 {
    private static final int ENTRY = 0;
    private static final int FEE = 1;
    private boolean[] checkArr;
    private int[][] arr;
    private int answer;
    private boolean maxedOut;

    public int solution(int hp, int[][] dungeons) {
        checkArr = new boolean[dungeons.length]; // true: 이미 깬 것, false: 아직 안 깬 것
        arr = dungeons;

        DFS(0, hp);

        return answer;
    }

    private void DFS(int L, int hp) {
        if (maxedOut) { /* 최대값이 나온 경우 DFS 그만 돌기 */
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!checkArr[i] && hp >= arr[i][ENTRY]) {
                checkArr[i] = true;
                DFS(L + 1, hp - arr[i][FEE]);
                checkArr[i] = false;
            }
        }
        answer = Math.max(L, answer);

        if (answer == arr.length) {
            maxedOut = true; /* 최대값이 이미 나온 경우 표시 */
        }
    }
}
