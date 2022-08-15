package level2;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>조이스틱</h1>
 * <h3>도움!! : O</h3>
 * <h3>체감 난이도 : ⭐⭐⭐︎</h3>
 * <h3>날짜 : 2022/08/13</h3>
 * <br><h2>comment : DFS를 이용한 양방향 그래프 최소거리 완전 탐색 (지나온 길 다시 밟기 허용)
 * <br> 정석 풀이법은 문제 카테고리인 탐욕법을 이용해서 정방향으로 도는게 빠른지, 역방향으로 도는게 빠른지를 계산하는 방식인 것 같다. 하지만 코드를 봤음에도 이해가 가지 않았다<a href="https://velog.io/@jeeseob5761/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1">(풀이 링크)</a>
 * <br><br> 그래서 DFS를 이용해 풀었는데, 지나온 index를 각 dfs마다 따로 저장하는 것을 map을 복사하여 구현하였을 때는 13번 테스트에서 시간초과가 났다.
 * <br> V2에서는 map을 복사하지 않고, checkArr 행렬을 복사함으로써 속도를 줄일 수 있었다
 * <br> * 행렬 복사 시 최대 걸리는 시간 : 27.28ms
 * <br> * map 복사 시 최대 걸리는 시간 : 9533.75ms 이상 (13번 테스트케이스 시간 초과)
 * <br> 같은 케이스에서 map은 9000ms 이상 걸릴 때 array는 4.97ms 소요</h2>
 *
 */
public class P42860_V2 {

    public static void main(String[] args) {
        SolutionP42860_V2 s = new SolutionP42860_V2();
        System.out.println(s.solution("AAABBAAAABBAAAAAAA")); // 14
        // System.out.println(s.solution("JEROEN")); // 56
        // System.out.println(s.solution("JAN")); // 23
    }

}

class SolutionP42860_V2 {
    private String name;
    private int count;
    private Map<Integer, Boolean> map = new HashMap<>();

    public int solution(String name) {
        this.name = name;
        /* A 부터 J 까지의 칸 수 = 'J'-'A'*/
        /* A 부터 J 까지 거꾸로 가는 칸 수 = 'Z'-'J'+1*/
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 'A') {
                map.put(i, true);
            }
        }
        count = name.length();
        boolean[] checkArr = new boolean[name.length()];
        int answer = DFS(0, 0, 0, checkArr); // 최소 좌우(<>) 이동 거리
        // System.out.println("count = " + answer);

        for (char letter : chars) {
            answer += Math.min(letter - 'A', 'Z' - letter + 1);
        }

        return answer;
    }

    private int DFS(int L, int index, int check, boolean[] checkArr) {

        if (index > name.length() - 1) { /* index가 0 보다 작거나 글자 길이보다 큰 경우 변환 */
            index = 0;
        } else if (index < 0) {
            index = name.length() - 1;
        }
        if (map.containsKey(index) && !checkArr[index]) { /* map을 이용해 목표값이 맞는지 확인하고, checkArr을 통해서 아직 한번도 안 지난 곳인지 확인 */
            checkArr[index] = true;
            check++;
        }

        if (check == map.size() || L > count) { /* 전체 글자 길이보다 L이 커지면 이미 최소값 찾기는 글렀으므로 return */
            return L;
        }
        // System.out.println("L : " + L + " index : " + index + " check :" + check);

        count = Math.min(count, DFS(L + 1, index + 1, check, checkArr.clone())); /* 정방향으로 이동 (+1) */
        count = Math.min(count, DFS(L + 1, index - 1, check, checkArr.clone())); /* 역방향으로 이동 (-1) */

        return count;
    }
}
