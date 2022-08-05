package level1;

import java.io.IOException;

/**
 * <h1>서울에서 김서방 찾기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/03</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment :</h2>
 */
public class P12919 {

    public static void main(String[] args) throws IOException {
        Solution12919 s = new Solution12919();
        s.solution(new String[] {"Jane", "Kim"});
    }
}

class Solution12919 {
    public String solution(String[] seoul) {
        int index = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }
        String answer = String.format("김서방은 %d에 있다", index);
        System.out.println(answer);
        return answer;
    }
}
