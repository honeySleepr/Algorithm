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
/* 반례 : [4, {2,3}, {3,4}] */
public class P42862 {

    public static void main(String[] args) throws IOException {
        Solution42862 s = new Solution42862();
        s.solution(5, new int[] {1, 2, 3, 4, 5}, new int[] {3});
        s.solution(10, new int[] {1, 2, 3, 4, 10}, new int[] {5, 4, 3});
        s.solution(4, new int[] {2, 3}, new int[] {3, 4});
    }
}

class Solution42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        Map<Integer, Boolean> lostMap = new HashMap<>();
        Map<Integer, Boolean> reserveMap = new HashMap<>();

        for (int i : lost) {
            lostMap.put(i, true);
        }
        for (int i : reserve) {
            reserveMap.put(i, true);
        }

        int[] checkArr = new int[n + 2]; /* n=10이라면 checkArr[11] 까지 있어야 i+1을 돌려도 예외가 안터진다 */
        for (int i : reserve) { /* 체크 행렬을 만들어 여분이 있는 학생만 1로 표시해둔다 */
            if (lostMap.containsKey(
                i)) { /* lost, reserve에 공존하는 경우 미리 처리해준다. 여기서 처리하지 않으면 문제가 되는 반례 : [4, {2,3}, {3,4}]*/
                answer++;
            } else {
                checkArr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(checkArr));
        for (int i : lost) {
            if (reserveMap.containsKey(i)) { /* 위와 마찬가지로 공존하는 경우 처리하는 부분. 이것보다 나은 방법이 있을텐데.. 모르겠다 */
                continue;
            }

            if (checkArr[i - 1] == 1) {
                checkArr[i - 1] = 0;
                answer++;
                continue;
            }
            if (checkArr[i + 1] == 1) {
                checkArr[i + 1] = 0;
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
