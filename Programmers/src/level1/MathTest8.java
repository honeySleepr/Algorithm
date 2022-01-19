package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathTest8 {
    public static void main(String[] args) {
        int[] mathProblem = {5, 2, 3, 4, 1, 4, 3, 5, 2};
        Solution8 solution8 = new Solution8();
        solution8.solution(mathProblem);
    }
}

class Solution8 {
    public int[] solution(int[] mathProblem) {
        List<int[]> giveUp = List.of(
            new int[] {1, 2, 3, 4, 5},
            new int[] {2, 1, 2, 3, 2, 4, 2, 5},
            new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        int[] score = {0, 0, 0};
        List<Integer> answerList = new ArrayList<>();

        for (int j = 0; j < 3; j++) {
            int answerPatternLength = giveUp.get(j).length;

            for (int i = 0; i < mathProblem.length; i++) {
                if (mathProblem[i] == giveUp.get(j)[i % answerPatternLength]) {
                    score[j]++;
                }
            }
        }
        int max = Arrays.stream(score).max().getAsInt();

        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                answerList.add(i + 1);
            }
        }
        return answerList.stream().mapToInt(m -> m).toArray();
    }
}
