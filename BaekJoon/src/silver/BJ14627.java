package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>파닭파닭</h1>
 * <h2>코드 참고 : X</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/06</h2>
 * <br><h2>comment : long, ArithmeticException, `남은 파의 길이를 구해야한다` 이 세가지 포인트 때문에 발목을 잡혔다 </h2>
 */
/* 반례:
1 10
10
답 : 0

3 5
10
10
10
답 : 5 (닭은 5마리만 팔고 나머지 파는 라면을 위해 남겨야한다)
* */
public class BJ14627 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int S = Integer.parseInt(split[0]);
        final int C = Integer.parseInt(split[1]);
        int[] arr = new int[S];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < S; i++) {
            int length = Integer.parseInt(br.readLine());
            arr[i] = length;
            max = Math.max(length, max);
        }

        /* [이분탐색 템플릿, 이분 탐색] */
        int lo = 1; /* lo=0 으로하면 mid=0이 되어 ArithmeticException(`/ by zero`)이 발생할 수 있다 */
        /*lo 값을 잡을 때 실제로 사용될 수 있는 값인지 생각하자. 행렬의 인덱스였다면 0을 줘야겠지만 이 경우는 `나눌 수 있는 최소값`인 1을 줘야한다*/
        int hi = max + 1;
        int mid = 0; /* */
        int count = 0;
        int length = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            count = getPadakCount(mid, arr);
            if (count < C) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
                length = Math.max(mid, length);
            }
        }

        long answer = 0;
        long chickenCount = 0; /* 오호 얘네 둘만 long으로 바꿔줘도 통과하는구만! */

        for (int i : arr) {
            chickenCount += i / length;
            answer += i % length;
        }

        /* 아래를 안해주면 실제 팔린 파닭보다 더 많은 파닭을 만들게 될 수 있다. 팔린 파닭 개수를 맞췄다면 남은 파는 라면을 위해 남겨둬야한다 */
        if (chickenCount != C) {
            answer += (chickenCount - C) * length;
        }

        System.out.println(answer);
    }

    private static int getPadakCount(int mid, int[] arr) {
        int count = 0;
        for (long length : arr) {
            count += length / mid;
        }
        return count;
    }

}
