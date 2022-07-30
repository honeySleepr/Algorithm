import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>암호</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <br><h2>comment : Integer.parseInt(string, 2) : 2진수인 string을 10진수로 바꿔준다 </h2>
 */
public class P0112 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        /* 7개씩 쪼개기 -> 2진수로 변환하기 -> 10진수로 변환 -> 알파벳으로 변환 */
        for (int i = 0; i < N; i++) {
            int num = 0;
            for (int k = 0; k < 7; k++) {
                if (chars[(7 * i) + k] == '#') {
                    num += Math.pow(2, 6D - k);
                }
            }
            char letter = (char)num;
            sb.append(letter);
        }
        System.out.println(sb);
    }
}
/*
4
#****###**#####**#####**##**

답 : COOL
*/
