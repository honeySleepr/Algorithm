package level1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>실패율</h1>
 * <h3>도움!! : O</h3>
 * <h3>날짜 : 2022/08/03</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment : double 값을 비교해야하는데 compareTo()는 int를 반환해서해서 변환하느라 애먹었다. 처음에는 계산된 double 값에 100만 같은 값을 곱해서 실제
 * int로 변환하는 방법을 써봤는데, 지저분하기도 하고 Pass 되지도 않았다.<br>
 * 더 나은 방법은 compareTo 안에서 double 끼리 직접 비교한 뒤 +1 또는 -1을 반환하도록 하는 것이다</h2>
 */
public class P42889_V1 {

    public static void main(String[] args) throws IOException {
        Solution42889_V1 s = new Solution42889_V1();
        s.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
        s.solution(4, new int[] {4, 4, 4, 4, 4});
        s.solution(5, new int[] {3, 3, 3, 3});
    }
}

class Solution42889_V1 {
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N + 2]; // 모든 스테이지 클리어한 사람은 arr[N+1]에 들어간다. arr[0]은 비워둔다

        for (int i : stages) {
            arr[i]++;
        }

        int sum = arr[N + 1]; // 모든 스테이지 클리어한 사람 수 먼저 저장
        List<Pair> list = new ArrayList<>();
        for (int i = N; i > 0; i--) { // 뒤에서 부터 돈다
            sum += arr[i];
            if (sum == 0) {
                list.add(new Pair(i, 0));
            } else {
                list.add(new Pair(i, (double)arr[i] / sum));
            }
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).index;
        }

        return answer;
    }

    class Pair implements Comparable<Pair> {
        int index;
        double failRate;

        public Pair(int index, double failRate) {
            this.index = index;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.failRate == o.failRate) { // 실패율이 같은 경우 인덱스를 기준으로 오.름.차.순 정렬
                return this.index - o.index;
            }
            if (this.failRate - o.failRate > 0) {
                return -1; // this가 비교대상보다 더 클때 `양수`를 반환해야 오름차순이 된다. 즉, 여기서 실패율은 내.림.차.순으로 정렬하겠다는 것!
            } else {
                return 1;
            }
        }
    }

}
