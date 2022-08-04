package level1;

import java.io.IOException;

/**
 * <h1>시저 암호</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/04</h3>
 * <br><h2>comment :</h2>
 */
public class P12926 {

    public static void main(String[] args) throws IOException {
        Solution12926 s = new Solution12926();
        System.out.println(s.solution("a B z", 4));
    }
}

class Solution12926 {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            int ascii = (chars[i] + n);

            if (Character.isLowerCase(chars[i])) { /* a-z : 97-122 */
                if (ascii > 122) {
                    chars[i] = (char)('a' + (ascii - 'z') - 1);
                } else {
                    chars[i] = (char)ascii;
                }
                continue;
            }

            if (Character.isUpperCase(chars[i])) { /* A-Z : 65-90 */
                if (ascii > 90) {
                    chars[i] = (char)('A' + (ascii - 'Z') - 1);
                } else {
                    chars[i] = (char)ascii;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
