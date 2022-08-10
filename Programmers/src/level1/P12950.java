package level1;

/**
 * <h1>행렬의 덧셈</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/09</h3>
 * <br><h2>comment :</h2>
 */
public class P12950 {

    public static void main(String[] args) {
        SolutionP12950 s = new SolutionP12950();
    }

}

class SolutionP12950 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr1[0].length; k++) {
                answer[i][k] = arr1[i][k] + arr2[i][k];
            }
        }
        return answer;

        /*--------아래 처럼 좀 더 간단하게도 할 수 있다--------*/

        // int[][] answer = arr1;
        // for{
        //     for{
        // answer += arr2;
        // }}
    }

}
