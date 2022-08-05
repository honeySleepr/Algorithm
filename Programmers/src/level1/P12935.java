package level1;

import java.util.Arrays;

/**
 * <h1>제일 작은 수 제거하기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/05</h3>
 * <br><h2>comment : stream이 편하긴 한데 확실히 느리다(평균 3ms 정도). for문으로 풀면 평균이 0.1ms도 채 안된다</h2>
 */
public class P12935 {

    public static void main(String[] args) {
        SolutionP12935 s = new SolutionP12935();
        System.out.println(Arrays.toString(s.solution(new int[] {4, 3, 2, 1})));
        System.out.println(Arrays.toString(s.solution(new int[] {10})));
    }

}

class SolutionP12935 {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int[] answer = new int[arr.length - 1];
        int arrIndex = 0;
        for (int i = 0; i < answer.length; i++) {
            if (arr[i] == min) {
                arrIndex++;
            }
            answer[i] = arr[arrIndex];
            arrIndex++;
        }

        if (answer.length == 0) {
            return new int[] {-1};
        }
        return answer;

        /*-----------Stream 연습----------------*/
        // int min = Arrays.stream(arr)
        //     .min()
        //     .getAsInt();
        //
        // int[] ints = Arrays.stream(arr)
        //     .filter(value -> value != min)
        //     .toArray();
        //
        // return ints;
    }
}
