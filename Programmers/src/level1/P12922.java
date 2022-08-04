package level1;

import java.io.IOException;

/**
 * <h1>수박수박수..</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/04</h3>
 * <br><h2>comment :</h2>
 */
public class P12922 {

    public static void main(String[] args) throws IOException {
        Solution12922 s = new Solution12922();
        s.solution(47);
    }
}

class Solution12922 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb.append("수");
            } else {
                sb.append("박");
            }
        }
        return sb.toString();
    }
}
