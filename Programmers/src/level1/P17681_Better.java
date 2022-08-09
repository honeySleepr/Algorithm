package level1;

import java.util.Arrays;

/**
 * <h1>비밀지도</h1>
 * <h3>도움!! : O</h3>
 * <h3>날짜 : 2022/08/08</h3>
 * <br><h2>comment : </h2>
 */
public class P17681_Better {

    public static void main(String[] args) {
        SolutionP17681_Better s = new SolutionP17681_Better();
        System.out.println(Arrays.toString(s.solution(5,
            new int[] {9, 20, 28, 18, 11},
            new int[] {30, 1, 21, 17, 28})));
        String st = "string";
        String format = String.format("%10s", st);
        System.out.println(format);
    }

}

class SolutionP17681_Better {
    private final StringBuilder sb = new StringBuilder();

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String combinedBinary = Integer.toBinaryString(arr1[i] | arr2[i]);

            int length = n - combinedBinary.length();
            for (int j = 0; j < length; j++) {
                sb.append(0);
            }
            combinedBinary = sb.append(combinedBinary).toString();
            /* 아래 처럼 할 수도 있는데 연산이 훨씬 느리다 */
            // combinedBinary = String.format("%" + n + "s", combinedBinary);

            combinedBinary = combinedBinary.replaceAll("1", "#");
            combinedBinary = combinedBinary.replaceAll("0", " ");
            answer[i] = combinedBinary;
        }
        return answer;
    }
}
