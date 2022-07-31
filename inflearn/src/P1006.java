import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>최대점수 구하기(냅색 알고리즘)</h1>
 * <h3>해설 참고 : O</h3>
 * <h3>코드 참고 : X</h3>
 * <h3>날짜 : 2022/07/28</h3>
 * <h2>풀이 방법 : </h2>
 * <h2>1. </h2>
 * <h2>2. </h2>
 * <br><h2>comment : 냅색 알고리즘에서 주어진 아이템이 유한개면 for문을 뒤에서부터, 무한개면 앞에서부터 돈다</h2>
 * <h2>앞에서 부터 돌게 되면, [점수 6, 시간 3] 이 주어졌을 때 arr[3] = 6, arr[6] = 12 가 된다. 즉 같은 문제를 2번 이상 풀게 되는 것이다.</h2>
 * <h2>뒤에서 부터 돌게 되면 위와 같이 한 문제에 대한 중복이 발생하지 않는다</h2>
 */
public class P1006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\s");
        final int N = Integer.parseInt(split[0]);
        final int M = Integer.parseInt(split[1]);
        List<Quiz> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split("\\s");
            int point = Integer.parseInt(strings[0]);
            int time = Integer.parseInt(strings[1]);
            list.add(new Quiz(point, time));
        }

        int[] arr = new int[M + 1];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int time = list.get(i).time;
            int point = list.get(i).point;
            for (int k = M; k >= time; k--) {
                arr[k] = Math.max(arr[k], arr[k - time] + point);
            }

        }
        System.out.println(arr[M]);
    }

    static class Quiz {

        private final int point;
        private final int time;

        public Quiz(int point, int time) {
            this.point = point;
            this.time = time;
        }

    }
}
/*
5 20
10 5
25 12
15 8
6 3
7 4

answer : 41
*/
