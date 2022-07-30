import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>유효한 팰린드롬</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <br><h2>comment : `string.replaceAll("[^A-Z]", "")`로 알파벳이 아닌건 전부 빈문자열로 바꿀 수 있다</h2>
 * <h2> ^A-Z -> [ ^: 부정, A-Z : 대문자 알파벳 ]  </h2>
 */
public class P0108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toLowerCase().toCharArray();
        List<Character> list = new ArrayList<>();

        for (char c : chars) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                list.add(c);
            }
        }
        String answer = "YES";
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get((list.size() - 1) - i)) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);

    }
}
/*
found7, time: study; Yduts; emit, 7Dnuof

answer : YES
 */
