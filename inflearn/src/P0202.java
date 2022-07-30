import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>보이는 학생</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/29</h3>
 */
public class P0202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("\\s");
        int answer = 1; /* 맨 앞에 애는 보이니까 */
        int max = Integer.parseInt(split[0]);

        for (int i = 1; i < N; i++) {
            int height = Integer.parseInt(split[i]);
            if (height > max) {
                answer++;
                max = height;
            }
        }
        System.out.println(answer);
    }
}
/*
8
130 135 148 140 145 150 150 153

답 : 5
*/
