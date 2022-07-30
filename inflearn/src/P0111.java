import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>문자열 압축</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment :</h2>
 */
public class P0111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chars = br.readLine().toCharArray();
        char save = chars[0];
        sb.append(chars[0]);
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == save) {
                count++;
                if (i == chars.length - 1) { /* 맨 마지막에 같은 알파벳 2개 이상 나올 경우 count 출력이 누락되지 않도록 함 */
                    sb.append(count);
                }
                continue;
            }

            if (count != 1) {
                sb.append(count);
            }

            sb.append(chars[i]);
            count = 1;
            save = chars[i];
        }

        System.out.println(sb);
    }
}
/*
KKHSSSSSSSE

answer : K2HS7E
*/
