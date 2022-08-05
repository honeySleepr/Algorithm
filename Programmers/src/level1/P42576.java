package level1;

import java.io.IOException;
import java.util.HashMap;

/**
 * <h1>완주하지 못한 선수</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/03</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment :</h2>
 */
public class P42576 {

    public static void main(String[] args) throws IOException {
        Solution42576 s = new Solution42576();
        s.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"});
        s.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"});
    }
}

class Solution42576 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String answer = "";
        for (String s : participant) {
            if (map.containsKey(s) && map.get(s) != 0) {
                map.replace(s, map.get(s) - 1);
            } else {
                answer = s;
                break;
            }
        }
        return answer;
    }
}
