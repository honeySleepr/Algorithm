import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <h1>문자 찾기</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment :</h2>
 */
public class P0101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toLowerCase().toCharArray();
        char target = br.readLine().toLowerCase().charAt(0);
        char aChar = chars[0];
        int answer = 0;
        for (char c : chars) {
            if (c == target) {
                answer++;
            }
        }
        System.out.println(answer);

    }
}
/*
Computercooler
c

answer : 2
*/
