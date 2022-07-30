import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>가장 짧은 문자거리</h1>
 * <h3>해설 참고 : X</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment :</h2>
 */
public class P0110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        char[] chars = split[0].toCharArray();
        char target = split[1].toCharArray()[0];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target) {
                list.add(i);
            }
        }
        int[] answer = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == target) {
                answer[i] = 0;
                continue;
            }
            int distance = Integer.MAX_VALUE;
            for (Integer index : list) { /* target 인덱스와 현재 인덱스를 비교하여 가장 작은 값 산출 */
                if (distance <= 1) {
                    break;
                }
                distance = Math.min(Math.abs(i - index), distance);
            }
            answer[i] = distance;
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
/*
teachermode e

answer : 1 0 1 2 1 0 1 2 2 1 0
*/
