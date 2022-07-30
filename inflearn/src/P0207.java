import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>점수 계산</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 */
public class P0207 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        int answer = 0;
        int count = 1;
        int prevPoint = 0;
        for (int i = 0; i < N; i++) {
            int point = Integer.parseInt(split[i]);
            if (point == 1) {
                if (prevPoint == 1) {
                    count++;
                    answer += count;
                } else {
                    count = 1;
                    answer++;
                }
            }
            prevPoint = point;
        }
        System.out.println(answer);
    }

}
