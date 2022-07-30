import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>등수 구하기</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 * <br><h2>comment : 2중 for문으로 푼다면 count=1 로 두고 기준 값 A 보다 큰 점수가이 나올 때마다 count++ 해주면 된다</h2>
 */
public class P0208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(split[i]);
            list.add(num);
            arr[i] = num;
        }

        Collections.sort(list, Comparator.reverseOrder());
        int place = 0;
        for (Integer p : list) {
            place++;
            if (map.containsKey(p)) {
                continue;
            }
            map.put(p, place);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
