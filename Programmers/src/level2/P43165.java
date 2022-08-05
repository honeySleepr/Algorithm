package level2;

/**
 * <h1>타겟 넘버</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/04</h3>
 * <br><h2>comment : DFS </h2>
 */
public class P43165 {

    public static void main(String[] args) {
        SolutionP43165 s = new SolutionP43165();
        System.out.println(s.solution(new int[] {3, 2, 1}, 6));
        System.out.println(s.solution(new int[] {4, 1, 2, 1}, 4));
    }

}

class SolutionP43165 {
    private int size;
    private int target;
    private int answer;
    private int[] input;

    public int solution(int[] numbers, int target) {
        size = numbers.length;
        this.target = target;
        input = numbers;

        DFS(0, 0);
        return answer;
    }

    private void DFS(int L, int sum) {

        if (L == size) {
            if (sum == target) {
                answer++;
            }
            System.out.printf("DFS(%d, %d) 끝\n", L, sum);
            return;
        }

        DFS(L + 1, sum + input[L]);
        DFS(L + 1, sum - input[L]);
        System.out.printf("DFS(%d, %d) 끝\n", L, sum);
    }
}
