package level2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>가장 큰 수</h1>
 * <h3>날짜 : 2022/07/28</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment : 1~6번 케이스가 안풀려서 결국 질문하기에서 아이디어 얻어서 풀었다. 반례들이 너무 어렵다 </h2>
 */
public class P42746 {

    public static void main(String[] args) throws IOException {
        Solution42746 s = new Solution42746();
        s.solution(new int[] {978, 97});

        /* 반례 : {0,0,0,0} -> 0 */
        /* 반례 : {978, 97} or {97, 978} -> 97,978 */
        /* 반례 : {979, 97} or {97, 979} -> 979,97 */
        /* 반례 : {232, 23} or {23, 232} -> 23,232 */
    }
}

class Solution42746 {
    public String solution(int[] numbers) {

        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }

        Collections.sort(list, (o1, o2) -> {
            String a = String.valueOf(o1) + String.valueOf(o2);
            String b = String.valueOf(o2) + String.valueOf(o1);
            return -(Integer.parseInt(a) - Integer.parseInt(b));
        });

        StringBuilder sb = new StringBuilder();
        list.forEach(integer -> sb.append(integer));

        if (sb.charAt(0) == '0') { /* {0,0,0} -> "0" */
            return "0";
        }
        return sb.toString();
    }

}
