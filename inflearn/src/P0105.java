import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>특정 문자 뒤집기</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment : 대칭이 아닌 경우도 고려해야한다</h2>
 * <br><h2>comment : 문자열의 양 끝에 l, r 인덱스를 두고 풀 수도 있다 </h2>
 */
public class P0105 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Deque<Character> queue = new ArrayDeque<>();

        for (int i = chars.length - 1; i >= 0; i--) {
            if (Character.isAlphabetic(chars[i])) {
                queue.add(chars[i]);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                chars[i] = queue.poll();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
/*
a#b!GE*T@S

answer : S#T!EG*b@a
*/
/*
kdj#@kdjg%$#kdjgk@kd$dk

answer : kdd#@kkgj%$#dkgjd@kj$dk
*/
