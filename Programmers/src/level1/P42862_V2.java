package level1;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>체육복</h1>
 * <h3>도움!! : O</h3>
 * <h3>날짜 : 2022/08/03</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment : </h2>
 */
/* 반례 : [4, {2,3}, {3,4}] - 옷 빌릴 수 있는지 판별하는 로직에서 3번은 제외되어야한다 */
/* 반례 : [5, {4,2}, {3,5}] - 정렬을 하지 않는 경우 4가 3을 빌려가버려서 2가 옷을 못 빌리게 되어 학생 `최대값`을 못 구하게된다. reserve는 map에 넣으니 정렬하지 않아도 된다 */
public class P42862_V2 {

    public static void main(String[] args) throws IOException {
        Solution42862_V2 s = new Solution42862_V2();
        s.solution(5, new int[] {1, 2, 3, 4, 5}, new int[] {3});
        s.solution(10, new int[] {1, 2, 3, 4, 10}, new int[] {5, 4, 3});
        s.solution(4, new int[] {2, 3}, new int[] {3, 4});
        s.solution(5, new int[] {4, 2}, new int[] {3, 5});
    }
}

class Solution42862_V2 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        int answer = n - lost.length;
        Map<Integer, Boolean> reserveMap = new HashMap<>();

        for (int i : reserve) {
            reserveMap.put(i, true);
        }
        for (int i = 0; i < lost.length; i++) {
            if (reserveMap.remove(lost[i]) != null) {
                answer++;
                lost[i] = -100; /* [4, {2,3}, {3,4}] 같은 상황에서 3을 검사 목록에서 제외되도록 하지 않으면 3이 4를 빌리게 된다 */
            }
        }

        for (int i : lost) {
            if (reserveMap.remove(i - 1) != null || reserveMap.remove(i + 1) != null) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
