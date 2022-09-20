package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <h1>동전 0</h1>
 * <h2>코드 참고 : O</h2>
 * <h2>반례 참고 : X</h2>
 * <h2>체감 난이도 : ⭐⭐︎</h2>
 * <h2>날짜 : 2022/09/14</h2>
 * <br><h2>comment : DFS, BFS, 냅색 다해봤는데 못 풀었다. 알고보니 그리디로 푸는 쉬운 문제였다.
 * 알고리즘은 이것저것 학습했지만 아직 어떤 상황에서 어떤 알고리즘을 사용해 접근해야하는지 판단하기가 어렵다 </h2>
 */
public class BJ11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        final int K = Integer.parseInt(split[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.reverseOrder());

        int temp = K;
        int count = 0;
        while (temp > 0) {
            for (Integer coin : list) {
                if (temp - coin < 0) {
                    continue;
                }
                count += temp / coin;
                temp %= coin;
                break;
            }
        }
        System.out.println(count);
    }
}
