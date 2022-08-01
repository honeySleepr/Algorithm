package level1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>신고 결과 받기</h1>
 * <h3>도움!! : X</h3>
 * <h3>날짜 : 2022/08/01</h3>
 * <h2>풀이 방법 : </h2>
 * <br><h2>comment :</h2>
 */
public class P92334 {

    public static void main(String[] args) throws IOException {
        Solution92334 s = new Solution92334();
        s.solution(
            new String[] {"muzi", "frodo", "apeach", "neo"},
            new String[] {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
            2);
        s.solution(
            new String[] {"con", "ryan"},
            new String[] {"ryan con", "ryan con", "ryan con", "ryan con"},
            2);
    }
}

class Solution92334 {
    public int[] solution(String[] id_list, String[] report, int k) {

        /* [이름 : 인덱스] 맵*/
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
        }

        List<List<String>> listList = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            listList.add(new ArrayList<>());
        }
        String reporter;
        String target;
        for (String s : report) {
            String[] split = s.split("\\s");
            reporter = split[0];
            target = split[1];
            int index = map.get(target);
            if (!listList.get(index).contains(reporter)) {
                listList.get(index).add(reporter);
            }
        }

        int[] answer = new int[id_list.length];
        for (List<String> list : listList) {
            if (list.size() >= k) {
                for (String reporterName : list) {
                    answer[map.get(reporterName)]++;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
/* ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"] */
