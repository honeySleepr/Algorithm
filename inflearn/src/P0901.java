import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 씨름 선수
public class P0901 {

    private static void solution(List<Integer> height, List<Integer> weight, int parseInt) {
        int chosen = parseInt;

        for (int i = 0; i < parseInt; i++) {
            for (int j = 0; j < parseInt; j++) {
                if (height.get(i) < height.get(j) && weight.get(i) < weight.get(j)) {
                    chosen--;
                    break;
                }
            }
        }
        System.out.println(chosen);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> height = new ArrayList<>();
        List<Integer> weight = new ArrayList<>();
        int parseInt = Integer.parseInt(br.readLine());
        for (int i = 0; i < parseInt; i++) {
            String[] split = br.readLine().split("\\s");
            height.add(Integer.parseInt(split[0]));
            weight.add(Integer.parseInt(split[1]));
        }

        solution(height, weight, parseInt);
    }
}
