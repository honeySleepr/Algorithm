package level1;

import java.io.IOException;

/**
 * <h1>신규 아이디 추천</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/01</h3>
 * <h2>풀이 방법 : 정규 표현식 활용 </h2>
 * <br><h2>comment : 덕분에 정규표현식을 배웠다 </h2>
 */
public class P72410 {

    public static void main(String[] args) throws IOException {
        Solution72410 s = new Solution72410();
        s.solution("...!@BaT#*..y.abcdefghijklm.");
        s.solution("z-+.^.");
        s.solution("=.=");
        s.solution("123_.def");
        s.solution("abcdefghijklmn.p");
    }
}

class Solution72410 {
    private static final String EMPTY = "";

    public String solution(String new_id) {

        String fixedId = new_id.toLowerCase() // 1단계
            .replaceAll("[^a-z0-9-_.]", EMPTY) //2단계
            .replaceAll("\\.{2,}", ".") // 3단계
            .replaceAll("^\\.|\\.$", EMPTY) // 4단계
            .replaceAll("^$", "a"); // 5단계

        if (fixedId.length() >= 16) { // 6단계
            fixedId = fixedId.substring(0, 15)
                .replaceAll("\\.$", EMPTY);
        }

        if (fixedId.length() <= 2) { // 7단계
            char c = fixedId.charAt(fixedId.length() - 1);
            while (fixedId.length() != 3) {
                fixedId += c;
            }
        }

        return fixedId;
    }
}
