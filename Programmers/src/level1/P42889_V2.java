package level1;

import java.io.IOException;

/**
 * <h1>실패율</h1>
 * <h3>도움!! : O</h3>
 * <h3>날짜 : 2022/08/03</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment : 인덱스와 실패율을 필드로 가지는 객체를 만들지 않고 푸는 방법을 보게 되어 구현해보았다<br>
 * 실패율을 담은 행렬과 인덱스를 담은 행렬을 같이 내림차순으로 삽입정렬한다.
 * </h2>
 */
public class P42889_V2 {

    public static void main(String[] args) throws IOException {
        Solution42889_V2 s = new Solution42889_V2();
        s.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
        s.solution(4, new int[] {4, 4, 4, 4, 4});
        s.solution(5, new int[] {3, 3, 3, 3});
    }
}

class Solution42889_V2 {
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N + 2]; // 모든 스테이지 클리어한 사람은 arr[N+1]에 들어간다. arr[0]은 비워둔다
        double[] failRate = new double[N]; // 실패율을 저장하는 array
        int[] answer = new int[N]; // 인덱스를 저장하는 array

        for (int i = 0; i < answer.length; i++) {
            answer[i] = i + 1;
        }
        for (int i : stages) {
            arr[i]++;
        }

        double sum = arr[N + 1]; // 모든 스테이지 클리어한 사람 수 먼저 저장

        for (int i = N; i > 0; i--) {
            sum += arr[i];
            if (sum == 0) {
                failRate[i - 1] = 0;
            } else {
                failRate[i - 1] = arr[i] / sum;
            }
        }
        // System.out.println(Arrays.toString(failRate));
        // System.out.println(Arrays.toString(answer));
        // System.out.println("================");
        /* 삽입 정렬 */
        int index = 0;
        double savedFailRate = 0;
        int savedAnswer = 0;
        for (int i = 1; i < failRate.length; i++) {
            index = i;
            savedFailRate = failRate[i];
            savedAnswer = answer[i];
            for (int j = i - 1; j >= 0; j--) { // 실패율을 기준으로 내림차순 정렬하면서 동시에 인덱스 array도 같이 정렬해준다
                if (failRate[j] < savedFailRate) { // 실패율은 내림차순 정렬이지만, answer 행렬의 인덱스는 오름차순 정렬이 된다
                    failRate[j + 1] = failRate[j]; // answer 행렬은 처음부터 오름차순으로 만들어져 있고, 실패율이 같은 경우 answer 행렬을 건드리지 않기 때문이다
                    answer[j + 1] = answer[j];
                    index = j;
                } else {
                    break;
                }
            }
            failRate[index] = savedFailRate;
            answer[index] = savedAnswer;
        }
        // System.out.println(Arrays.toString(failRate));
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}
