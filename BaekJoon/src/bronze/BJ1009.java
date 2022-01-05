package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BJ1009 {
    static Map<Integer, int[]> remainderMap = Map.of(
        0, new int[] {10}, /* num1 = 10 인 경우가 문제였는데 찾느라 너무 오래걸렸다 */
        1, new int[] {1},
        2, new int[] {2, 4, 8, 6},
        3, new int[] {3, 9, 7, 1},
        4, new int[] {4, 6},
        5, new int[] {5},
        6, new int[] {6},
        7, new int[] {7, 9, 3, 1},
        8, new int[] {8, 4, 2, 6},
        9, new int[] {9, 1});

    static int compute(int num1, int num2) {

        int arrLength = remainderMap.get(num1 % 10).length;
        int answer = 0;

        if (num2 % arrLength == 0) {
            answer = remainderMap.get(num1 % 10)[arrLength - 1];
        } else {
            answer = remainderMap.get(num1 % 10)[(num2 % arrLength) - 1];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        int[] answer = new int[caseNum];
        List<String[]> input = new ArrayList<>();

        for (int i = 0; i < caseNum; i++) {
            input.add(br.readLine().split("\\s+"));
        }

        for (int i = 0; i < caseNum; i++) {

            int num1 = Integer.parseInt(input.get(i)[0]);
            int num2 = Integer.parseInt(input.get(i)[1]);

            answer[i] = compute(num1, num2);
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}