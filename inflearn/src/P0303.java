import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://cote.inflearn.com/contest/10/problem/03-03
//
public class P0303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        int totalCount = Integer.parseInt(split[0]);
        int given = Integer.parseInt(split[1]);

        List<Integer> list = Arrays.stream(br.readLine().split("\\s"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int sum = 0;

        for (int i = 0; i < given; i++) {
            sum += list.get(i);
        }

        int max = sum;

        for (int i = 0; i < totalCount - given; i++) {
            sum -= list.get(i);
            sum+= list.get(i+given);
            if (max < sum) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}
